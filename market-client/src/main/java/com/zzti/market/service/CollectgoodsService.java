package com.zzti.market.service;


import com.zzti.market.entity.Collecgoods;
import com.zzti.market.entity.Goods;
import com.zzti.market.result.GoodsResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface CollectgoodsService {
    int addCollectGoods(String goodsid,String userid,String type);
    int removeCollectGoods(String goodsid,String userid,String type);

    int getCountCollectGoods(String userid,String type);

    List<Collecgoods> getCollecgoodsPage(Integer startPage,Integer pageSize,String userid,String type);


   // List<G>
//	void collectGoods ( String goodsid, HttpSession session );
//	List<Goods> myCollectGoods ( HttpSession session, Integer startPage, Integer pageSize, HttpServletRequest request );
//	int findCollec ( HttpSession session );
//	int weatherCollect ( String goodsid, HttpSession session );
}
