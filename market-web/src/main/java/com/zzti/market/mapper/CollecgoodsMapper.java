package com.zzti.market.mapper;



import java.util.List;

import com.zzti.market.entity.Collecgoods;
import org.apache.ibatis.annotations.Param;



public interface CollecgoodsMapper {
    int insert ( Collecgoods record );
    List<Collecgoods> myCollect ( @Param("userid") String userid, @Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize,@Param("type")String type );
    int findCollecNumber ( @Param("userid")String userid,@Param("type") String type);
    int insertSelective ( Collecgoods record );
    int weatherCollect ( @Param("userid") String userid, @Param("goodsid") String goodsid );
    int delete ( @Param("goodsid") String goodsid,@Param("userid")String userid,@Param("type") String type);
}