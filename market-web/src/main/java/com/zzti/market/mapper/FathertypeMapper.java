package com.zzti.market.mapper;

import com.zzti.market.entity.Fathertype;

import java.util.List;


public interface FathertypeMapper {
    int deleteByPrimaryKey ( String typeid );

    int insert ( Fathertype record );

    int insertSelective ( Fathertype record );

    Fathertype selectByPrimaryKey ( String typeid );

    int updateByPrimaryKeySelective ( Fathertype record );

    int updateByPrimaryKey ( Fathertype record );
    List<Fathertype> selectfathertype ();
}