package com.zzti.market.mapper;

import com.zzti.market.entity.Goodspicture;

import java.util.List;



public interface GoodspictureMapper {
    int deleteByPrimaryKey ( String goodspicture );

    int insert ( Goodspicture record );

    int insertSelective ( Goodspicture record );

    Goodspicture selectByPrimaryKey ( String goodspicture );

    int updateByPrimaryKeySelective ( Goodspicture record );

    int updateByPrimaryKey ( Goodspicture record );
    List<Goodspicture> selectByGoodsId ( String goodsid );
}