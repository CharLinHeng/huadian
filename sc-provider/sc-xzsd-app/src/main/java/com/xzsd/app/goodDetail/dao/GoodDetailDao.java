package com.xzsd.app.goodDetail.dao;
import com.xzsd.app.goodDetail.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Deprecated 商品详情Dao
 * @author zhc
 * @Time 2020年4月10日15:22:38
 */
@Mapper
public interface GoodDetailDao {
    /**
     * 商品详情查询
     * @param code
     * @return
     */
    Good queryGoodDetail(@Param("goodCode")String code);

    /**
     * 商品评价列表查询
     * @param goodEvaParam
     * @return
     */
    List<GoodEva> queryGoodComEvaList(GoodEvaParam goodEvaParam);

    /**
     * 客户绑定店铺查询
     * @param userParam
     * @return
     */
    UserBindStore queryUserBindStore(UserParam userParam);

    /**
     * 根据参数查询省市区名称
     */
    UserBindStore queryPCD(UserBindStore userBindStore);

    /**
     * 浏览量+1
     * @param goodThrough
     * @return
     */
    int addGoodThrough(GoodThrough goodThrough);
}
