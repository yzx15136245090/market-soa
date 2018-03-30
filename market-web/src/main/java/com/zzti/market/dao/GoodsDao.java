package com.zzti.market.dao;

import com.zzti.market.mapper.GoodsMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @ProjectName: market-soa
 * @Package: com.zzti.market.dao
 * @ClassName: GoodsDao
 * @Description: java类作用描述
 * @Author: zhixiang.yang
 * @CreateDate: 2018/3/30 10:11
 * @UpdateUser: zhixiang.yang
 * @UpdateDate: 2018/3/30 10:11
 * @UpdateRemark:
 * @Version: 1.0
 */
@Repository
public class GoodsDao {
    @Resource
    GoodsMapper goodsMapper;
   /**
    * @method getCountGoods
    * @Author: zhixiang.yang
    * @Description: 获取某种状态下商品的数量
    * @Date: 11:17 2018/3/30
    * @param status
    * @return: int
    */
    public int getCountGoods(String status){
       return   goodsMapper.findGoodsNumber(status);
    }


    /**
     * @method getCountGoodsByUserId
     * @Author: zhixiang.yang
     * @Description:
     * @Date: 11:28 2018/3/30
     * @param status
     * @param userId
     * @return: int
     */
    public int getCountGoodsByUserId(String status,String userId){
        return goodsMapper.findGoodsNumberByUserId(status,userId);
    }

    public int getCountGoodsByGoodsType ( String status, String goodstype ){
        return  goodsMapper.findGoodsNumberByGoodsType(status,goodstype);
    }

    public int getCountGoodsBySearch ( String status, String goodsname ){
        return  goodsMapper.findGoodsNumberByGoodsType(status,goodsname);
    }

}
