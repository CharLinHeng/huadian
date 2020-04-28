package com.xzsd.app.homepage.service;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.homepage.dao.HomePageDao;
import com.xzsd.app.homepage.entity.HotGoods;
import com.xzsd.app.homepage.entity.TurnsImage;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * @Auther: zhonghecheng
 * @Date: 2020年4月11日13:45:58
 * @Description: 首页Service
 */
@Service
public class HomePageService {
    @Resource
    private HomePageDao homePageDao;
    /**
     * 热门轮播图列表查询
     * @return
     */
    public AppResponse queryRotateChartsList(){
        List<TurnsImage> turnsImageList = homePageDao.queryRotateChartsList();
        if(turnsImageList.size() > 0){
            String msg = "";
            //查询没过期的轮播图。之后，将其余不在结果列表的轮播图状态设为禁用。说明是过期了的。
            List<String>noOverDueCodes = new ArrayList<>();
            for(int i = 0;i < turnsImageList.size() ; i++){
                noOverDueCodes.add(turnsImageList.get(i).getRotateChartCode());
            }
            //禁用过期的轮播图
            int result = homePageDao.deleteOverdue(noOverDueCodes);
            if(result > 0){
                msg = "已更新过期的轮播图"+result+"个";
            }
            return AppResponse.success( "获取成功!"+msg,turnsImageList);
        }
        return AppResponse.bizError("获取失败");
    }

    /**
     * 热门商品
     * @return
     */
    public AppResponse queryHotGoodsList(){
        //先查询展示的数量
        int num = homePageDao.queryNum();
        //查询
        List<HotGoods>hotGoodsList = homePageDao.queryHotGoodsList(num);
        if(hotGoodsList.size() > 0){
            return AppResponse.success("获取成功!",hotGoodsList);
        }
        return AppResponse.bizError("获取热门商品列表失败");
    }
}
