package com.zzti.market.mapper;

import java.util.List;

import com.zzti.market.entity.Buymessage;
import org.apache.ibatis.annotations.Param;


public interface BuymessageMapper {
    int deleteByPrimaryKey ( String buymessageid );

    int insert ( Buymessage record );

    int insertSelective ( Buymessage record );

    Buymessage selectByPrimaryKey ( String buymessageid );

    int updateByPrimaryKeySelective ( Buymessage record );
    int findBuymessageNumber ( int buystatus );
    int updateByPrimaryKey ( Buymessage record );
    List<Buymessage> allMessage ( int buystatus );
    List<Buymessage> findBuymessageByLImit ( @Param("buystatus") int buystatus, @Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize );

    List<Buymessage> findBuymessageByUserId ( @Param("buystatus") int buystatus, @Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize,@Param("userid") String userid);
    int findBuymessageNumberByUserId( @Param("buystatus") int buystatus,@Param("userid")String userid);


}