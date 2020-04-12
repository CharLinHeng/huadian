package com.xzsd.pc.goodclassification.service;


import org.springframework.stereotype.Service;
import com.xzsd.pc.goodclassification.dao.GoodClassifiDao;
import com.xzsd.pc.goodclassification.entity.GoodClassification;
import com.xzsd.pc.goodclassification.entity.GoodClassificationList;
import com.xzsd.pc.goodclassification.entity.GoodClassificationSon;
import com.xzsd.pc.util.RandomCode;
import com.xzsd.pc.util.ResponceData;
import com.xzsd.pc.util.ResponceDataState;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 商品分类管理
 * zhc
 * 2020年4月4日15:03:01
 */
@Service

public class GoodClassifiService {

    private ResponceData responceData;
    @Resource
    GoodClassifiDao goodClassifiDao;

    final static int MAXNODE = 100000;
    /**
     * 新增一级分类
     * @param goodClassification
     * @return
     */
    public ResponceData addFirstClass(GoodClassification goodClassification){
        //判断是否缺少参数
        if(null == goodClassification.getClassName() ||goodClassification.getClassName().length() == 0 ){
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"参数不能为空!",null);
            return responceData;
        }

        //判断是否已经含有名称
        int count = goodClassifiDao.countClassName(goodClassification.getClassName());

        if(count > 0 ){
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"分类名称已经存在!",null);
            return responceData;
        }


        //生成随机分类编号
         goodClassification.setClassCode(RandomCode.random_GoodClassifiCationCode());
         goodClassification.setCreateUser("administrator");
        //插入
        int result = goodClassifiDao.addFirstClass(goodClassification);
        if(result >0){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"新增成功!",null);
        }
        else{
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"新增失败!",null);
        }
        //判断结果
        return responceData;
    }

    /**
     * 新增二级分类
     * @param goodClassification
     * @return
     */
    public ResponceData addSecondClass(GoodClassification goodClassification){
        //判断是否缺少参数
        if(null == goodClassification.getClassName() ||goodClassification.getClassName().length() == 0 ||null == goodClassification.getFirstClassCode()||goodClassification.getFirstClassCode().length() == 0){
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"参数不能为空!",null);
            return responceData;
        }
        //判断是否已经含有名称
        int count = goodClassifiDao.countClassName(goodClassification.getClassName());

        if(count > 0 ){
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"分类名称已经存在!",null);
            return responceData;
        }


        //生成随机分类编号
        goodClassification.setClassCode(RandomCode.random_GoodClassifiCationCode());
        goodClassification.setCreateUser("administrator");

        int result = goodClassifiDao.addSecondClass(goodClassification);
        if(result >0){
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"新增成功!",null);
        }
        else{
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"新增失败!",null);
        }
        //判断结果
        return responceData;


    }

    /**
     * 修改商品分类修改
     * @param goodClassification
     * @return
     */
    public ResponceData updateGoodClass(GoodClassification goodClassification){
        //判断参数是否齐全
//        classCode	string	y	分类编号
//        className	string	y	分类名称
//        classRemark	string	y	分类备注
//        classRank	string	y	分类等级
//        firstClassCode	string	n	如果分类等级是二级，那么需要知道所属的一级分类编号
        if( null == goodClassification.getClassCode()){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"编号参数缺失!",null);
        }
        if( null == goodClassification.getClassName()){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"分裂名称参数缺失!",null);
        }
        if( null == goodClassification.getClassRank()){
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"分类等级未指定!",null);
            return responceData;
        }
        if(goodClassification.getClassRank().equals("2") && null ==  goodClassification.getFirstClassCode()){
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"父级编号未指定!",null);
            return responceData;
        }
        //判断版本号
        if(null == goodClassification.getVersion()){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"版本号未之指定!",null);
        }

        //修改


        int result = goodClassifiDao.updateGoodClass(goodClassification);
        if(result >0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"修改成功!",null);
        }
        else{
            return new ResponceData(ResponceDataState.values()[3].getCode(),"修改失败!",null);
        }
    }

    /**
     * 商品分类删除
     * @param code
     * @param updateUser
     * @return
     */
    public ResponceData deleteGoodClass(String code,String rank,String updateUser){
        //判断分类是否有
        if(null == rank || rank.length() == 0){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"分类等级参数未指定",null);
        }
        //更新者
        if(null == updateUser || updateUser.length() == 0){
            updateUser = RandomCode.radmonkey();
        }
        //切割
        List<String> codesList = Arrays.asList(code.split(","));

        //判断是否一个
        if(codesList.size()>1){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"每次最多删除一个分类!",null);
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

            return new ResponceData(ResponceDataState.values()[0].getCode(),"删除成功!"+msg,null);
        }
        else{
            return new ResponceData(ResponceDataState.values()[3].getCode(),"删除失败!",null);
        }
    }

    /**
     * 查询分类详情
     * @param code
     * @return
     */
    public ResponceData queryGoodClass(String code){
        //参数判定
        if(null == code || code.equals("")){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"参数缺失",null);
        }
        //查询
        GoodClassification goodClassification = goodClassifiDao.queryGoodClass(code);

        if(null == goodClassification){
            return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
        }
        else{
            return new ResponceData(ResponceDataState.values()[3].getCode(),"查询成功!",goodClassification);
        }

    }

    /**
     * 所有树状关系查询
     * @return
     */
    public ResponceData queryGoodClassList(){
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
                                goodClassificationSonList.add(goodClassificationSon);

                            }
                        }
                goodClassificationList.setListGoodClassificationSon(goodClassificationSonList);
                goodClassificationLists1.add(goodClassificationList);

            }

        }
        //接下来，释放原来的，然后将剩余的二级插进去
        //此时，一级的分类已经全部新增好，我们只需要查找就ok
        goodClassificationLists = null; //垃圾回收
        if(goodClassificationLists1.size()>0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"查询成功!",goodClassificationLists1);
        }
        else{
            return new ResponceData(ResponceDataState.values()[3].getCode(),"查询为空!",null);
        }

    }
}
