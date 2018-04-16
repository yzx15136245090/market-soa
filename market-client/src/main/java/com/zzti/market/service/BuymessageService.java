package com.zzti.market.service;


import com.zzti.market.entity.Buymessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface BuymessageService {
	int ReleaseBuymessage (String userId,String  buygoodsname,String buygoodsdescrip,Integer wantprice,String wantsite,Integer buyindate);
//	List<Buymessage> allBuymessage ( int buystatus, Integer startPage, Integer pageSize );
//	List<Buymessage> allBuymessage ( int buystatus );
//	int findBuymessageNumber ( int buystatus );
}
