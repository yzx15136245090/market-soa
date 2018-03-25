package com.zzti.market.mapper;


import com.zzti.market.entity.Credit;

public interface CreditMapper {
    int deleteByPrimaryKey ( String creditid );

    int insert ( Credit record );

    int insertSelective ( Credit record );

    Credit selectByPrimaryKey ( String creditid );

    int updateByPrimaryKeySelective ( Credit record );

    int updateByPrimaryKey ( Credit record );
}