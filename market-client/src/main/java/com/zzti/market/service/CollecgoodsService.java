package com.zzti.market.service;


import com.zzti.market.entity.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface CollecgoodsService {
	void collectGoods ( String goodsid, HttpSession session );
	List<Goods> myCollectGoods ( HttpSession session, Integer startPage, Integer pageSize, HttpServletRequest request );
	int findCollec ( HttpSession session );
	int weatherCollect ( String goodsid, HttpSession session );
}
