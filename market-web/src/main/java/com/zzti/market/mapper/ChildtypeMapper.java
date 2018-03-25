package com.zzti.market.mapper;

import com.zzti.market.entity.Childtype;

import java.util.List;



public interface ChildtypeMapper {
    int deleteByPrimaryKey ( String childtypeid );

    int insert ( Childtype record );

    int insertSelective ( Childtype record );

    Childtype selectByPrimaryKey ( String childtypeid );

    int updateByPrimaryKeySelective ( Childtype record );

    int updateByPrimaryKey ( Childtype record );
    List<Childtype> selectchildtype ( String typeid );
    Childtype childSearchGoods ( String childtypename );
}