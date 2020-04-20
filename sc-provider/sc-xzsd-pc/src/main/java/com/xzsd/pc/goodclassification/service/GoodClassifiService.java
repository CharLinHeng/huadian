package com.xzsd.pc.goodclassification.service;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.util.SecurityUtils;
import org.springframework.stereotype.Service;
import com.xzsd.pc.goodclassification.dao.GoodClassifiDao;
import com.xzsd.pc.goodclassification.entity.GoodClassification;
import com.xzsd.pc.goodclassification.entity.GoodClassificationList;
import com.xzsd.pc.goodclassification.entity.GoodClassificationSon;
import com.xzsd.pc.util.RandomCode;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @DescriptionDemo 商品分类管理Service
 * @Author zhonghecheng
 * @Date 2020-03-27
 */
@Service
public class GoodClassifiService {
    @Resource
    GoodClassifiDao goodClassifiDao;
    final static int MAXNODE = 100000;
    /**
     * 新增一级分类
     * @param goodClassification
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addFirstClass(GoodClassification goodClassification){
        //判断是否缺少参数
        if(null == goodClassification.getClassName() ||goodClassification.getClassName().length() == 0 ){
            return AppResponse.paramError("参数不能为空!");
        }
        //判断是否已经含有名称
        int count = goodClassifiDao.countClassName(goodClassification.getClassName(),null);
        if(count > 0 ){
            return AppResponse.paramError("分类名称已经存在!");
        }
        //生成随机分类编号
         goodClassification.setClassCode(RandomCode.random_GoodClassifiCationCode());
         goodClassification.setCreateUser(SecurityUtils.getCurrentUserUsername());
        //新增
        int result = goodClassifiDao.addFirstClass(goodClassification);
        if(result >0){
            return AppResponse.success("新增成功!");
        }
        return  AppResponse.bizError("新增失败!");
        //判断结果
    }

    /**
     * 新增二级分类
     * @param goodClassification
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addSecondClass(GoodClassification goodClassification){
        //判断是否缺少参数
        if(null == goodClassification.getClassName() ||goodClassification.getClassName().length() == 0 ||
           null == goodClassification.getFirstClassCode()||goodClassification.getFirstClassCode().length() == 0){
            return AppResponse.paramError("参数不能为空!");
        }
        //判断是否已经含有名称
        int count = goodClassifiDao.countClassName(goodClassification.getClassName(),null);
        if(count > 0 ){
            return AppResponse.paramError("分类名称已经存在!");
        }
        //生成随机分类编号
        goodClassification.setClassCode(RandomCode.random_GoodClassifiCationCode());
        goodClassification.setCreateUser(SecurityUtils.getCurrentUserUsername());
        int result = goodClassifiDao.addSecondClass(goodClassification);
        if(result >0){
            return AppResponse.success("新增成功!");
        }
        return AppResponse.bizError("新增失败!");
    }

    /**
     * 修改商品分类修改
     * @param goodClassification
     * @return
     */
    public AppResponse updateGoodClass(GoodClassification goodClassification){
        //判断参数是否齐全
        if( null == goodClassification.getClassCode()|| goodClassification.getClassCode() == ""){
            return AppResponse.paramError("编号参数缺失!");
        }
        if( null == goodClassification.getClassName()|| goodClassification.getClassName() == ""){
            return AppResponse.paramError("分列名称参数缺失!");
        }
        if( null == goodClassification.getClassRank()|| goodClassification.getClassRank() == ""){
            return AppResponse.paramError("分类等级未指定!");
        }
        if(goodClassification.getClassRank().equals("2") && ( null ==  goodClassification.getFirstClassCode()||goodClassification.getFirstClassCode() == "")){
            return AppResponse.paramError("父级编号未指定!");
        }
        //潘墩分类名称是否已经存在
        int count = goodClassifiDao.countClassName(goodClassification.getClassName(),goodClassification.getClassCode());
        if(count > 0){
            return AppResponse.paramError("分类名称已经存在!");
        }
        //修改
        int result = goodClassifiDao.updateGoodClass(goodClassification);
        if(result >0){
            return AppResponse.success("修改成功!");
        }
        return AppResponse.bizError("修改失败!原因可能是版本号不正确!");
    }

    /**
     * 商品分类删除
     * @param code
     * @param updateUser
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodClass(String code,String rank,String updateUser){
        //判断分类是否有
        if(null == rank || rank.length() == 0){
            return AppResponse.paramError("分类等级参数未指定");
        }
        updateUser =  SecurityUtils.getCurrentUserUsername();
        //切割
        List<String> codesList = Arrays.asList(code.split(","));
        //判断是否一个
        if(codesList.size()>1){
            return AppResponse.bizError("每次最多删除一个分类!");
        }
        int result = goodClassifiDao.deleteGoodClass(codesList,updateUser);
        if(result >0){
            String msg = "";
            //如果是1级分类，那么还要删除所拥有的二级分类
            if(rank.equals("1")){
                //删除一级分类所拥有的二级分类
                int result_delete2 = goodClassifiDao.deleteSecClass(codesList.get(0),updateUser);
                if(result_delete2 >0){
                    msg = "该一级分类附属的二级分类有"+String.format("%d",result_delete2)+"个，成功删除!";
                }
                else{
                    msg = "该一级分类附属没有二级分类，故只删除其本身。";
                }
            }
            return AppResponse.success("删除成功!"+msg);
        }
        return AppResponse.bizError("删除失败!");
    }
    /**
     * 查询分类详情
     * @param code
     * @return
     */
    public AppResponse queryGoodClass(String code){
        //参数判定
        if(null == code || code.equals("")){
            return AppResponse.bizError("分类编号参数为空");
        }
        //查询
        GoodClassification goodClassification = goodClassifiDao.queryGoodClass(code);
        if(null == goodClassification){
            return AppResponse.bizError("查询为空!");
        }
        return AppResponse.success("查询成功!",goodClassification);
    }
    /**
     * 所有树状关系查询
     * @return
     */
    public AppResponse queryGoodClassList(){
        List<GoodClassification>goodClassificationLists = goodClassifiDao.queryGoodClassList();
        //查询所有，然后分类
        //最终输出
        List<GoodClassificationList> goodClassificationLists1 = new ArrayList<>();
        //纪录所有已经被纪录的
        //索引
        for(int i = 0;i < goodClassificationLists.size();i++){
            if(null == goodClassificationLists.get(i).getClassRank()){
                continue;
            }
            if(goodClassificationLists.get(i).getClassRank().equals("1")){
                       GoodClassificationList goodClassificationList = new GoodClassificationList();
                       goodClassificationList.setClassCode(goodClassificationLists.get(i).getClassCode());
                       goodClassificationList.setClassName(goodClassificationLists.get(i).getClassName());
                       goodClassificationList.setVersion(goodClassificationLists.get(i).getVersion());
                       //查找直系的二级
                        int count = 0;
                        List<GoodClassificationSon>goodClassificationSonList =  new ArrayList<>();
                        for(int j = 0;j< goodClassificationLists.size();j++){
                            if(j == i){ continue;}
                            if(null == goodClassificationLists.get(j).getFirstClassCode()){continue;}
                            if(goodClassificationLists.get(j).getFirstClassCode().equals(goodClassificationLists.get(i).getClassCode())){
                                GoodClassificationSon goodClassificationSon = new GoodClassificationSon();
                                goodClassificationSon.setClassCode(goodClassificationLists.get(j).getClassCode());
                                goodClassificationSon.setClassName(goodClassificationLists.get(j).getClassName());
                                goodClassificationSon.setVersion(goodClassificationLists.get(j).getVersion());
                                goodClassificationSonList.add(goodClassificationSon);
                            }
                        }
                goodClassificationList.setListGoodClassificationSon(goodClassificationSonList);
                goodClassificationLists1.add(goodClassificationList);
            }
        }
        //垃圾回收
        goodClassificationLists = null;
        if(goodClassificationLists1.size()>0){
            return AppResponse.success("查询成功!",goodClassificationLists1);
        }
        return AppResponse.bizError("查询为空!");
    }
}
