package com.zzti.market.mapper;


import com.zzti.market.entity.Chatmessage;

public interface ChatmessageMapper {
    int deleteByPrimaryKey ( String chatid );

    int insert ( Chatmessage record );

    int insertSelective ( Chatmessage record );

    Chatmessage selectByPrimaryKey ( String chatid );
    Chatmessage selectByUserId2 ( String userid2 );
    int updateByPrimaryKeySelective ( Chatmessage record );

    int updateByPrimaryKey ( Chatmessage record );
}