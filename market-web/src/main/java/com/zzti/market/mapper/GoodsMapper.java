package com.zzti.market.mapper;

import java.util.List;

import com.zzti.market.entity.Goods;
import org.apache.ibatis.annotations.Param;



public interface GoodsMapper {
    int deleteByPrimaryKey ( String goodsid );
    int insert ( Goods record );
    int insertSelective ( Goods record );
    Goods selectByPrimaryKey ( String goodsid );
    int updateByPrimaryKeySelective ( Goods record );
    List<Goods> selectByUser ( @Param("userid") String userid, @Param("status") String status );
    List<Goods> selectByUserId ( @Param("userid") String userid, @Param("status") String status, @Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize );
    List<Goods> selectByGoodsType ( @Param("goodstype") String goodstype, @Param("status") String status, @Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize );
    int updateByPrimaryKey ( Goods record );
    List<Goods> allGoods ( String status );
    int findGoodsNumber ( String status );
    int findGoodsNumberByUserId ( @Param("status") String status, @Param("userid") String userid );
    int findGoodsNumberByGoodsType ( @Param("status") String status, @Param("goodstype") String goodstype );
    int findGoodsNumberBySearch( @Param("status") String status, @Param("goodsname")String goodsname);
    //分页
    List<Goods> findGoodsByLImit ( @Param("status") String status, @Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize );
    List<Goods> searchGoods ( @Param("status") String status, @Param("goodschildtype") String goodschildtype, @Param("goodsname") String goodsname, @Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize );
    int searchGoodsNumber ( @Param("status") String status, @Param("goodschildtype") String goodschildtype, @Param("goodsname") String goodsname );

}