package com.zzti.market.mapper;

import java.util.List;

import com.zzti.market.entity.Ident;
import org.apache.ibatis.annotations.Param;



public interface IdentMapper {
    int deleteByPrimaryKey ( @Param("identid") String identid );

    int insert ( Ident record );

    int insertSelective ( Ident record );

    Ident selectByPrimaryKey ( @Param("identid") String identid );

    int updateByPrimaryKeySelective ( Ident record );

    int updateByPrimaryKey ( Ident record );
   // @Param("startPage") Integer
	List<Ident> selectLimitLengthIs10 ( @Param("form") Integer form );

	int querycowntall ();

	List<Ident> selectLimitLengthIs101 ( @Param("identstatus") Integer identstatus, @Param("form") Integer form );

	int querycowntall1 ( @Param("identstatus") Integer identstatus );

	List<Ident> selectLimitLengthIs102 ( @Param("search") String search, @Param("form") Integer form );

	int querycowntall2 ( @Param("search") String search );
}