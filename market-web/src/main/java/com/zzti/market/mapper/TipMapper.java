package com.zzti.market.mapper;


import com.zzti.market.entity.Tip;

public interface TipMapper {
    int deleteByPrimaryKey ( String tipid );

    int insert ( Tip record );

    int insertSelective ( Tip record );

    Tip selectByPrimaryKey ( String tipid );

    int updateByPrimaryKeySelective ( Tip record );

    int updateByPrimaryKey ( Tip record );
}