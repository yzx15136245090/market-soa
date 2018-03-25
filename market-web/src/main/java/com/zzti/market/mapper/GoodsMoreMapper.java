package com.zzti.market.mapper;

import java.util.List;

import com.zzti.market.entity.Goods;
import com.zzti.market.entity.GoodsMore;
import org.apache.ibatis.annotations.Param;



public interface GoodsMoreMapper {
	List<GoodsMore> findGoodsMoreByLImit ( @Param("status") String status, @Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize );
	Goods selectByPrimaryKey ( String goodsid );
	List<GoodsMore> findGoodsMoreByType ( @Param("status") String status, @Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize, @Param("goodstype") String goodsType );
}
