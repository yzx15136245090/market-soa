package com.zzti.market.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zzti.market.entity.Childtype;
import com.zzti.market.entity.Fathertype;
import com.zzti.market.entity.Goods;
import com.zzti.market.entity.GoodsMore;
import com.zzti.market.result.GoodsResult;
import org.springframework.web.multipart.MultipartFile;

public interface GoodsService {
	//发布商品
//void ReleaseGoods ( MultipartFile[] cms, Goods goods, HttpServletRequest request, HttpSession session );
	//获取父类名称
	List<Fathertype> fathertype ();
	//获取子类名称
	List<Childtype> childtype ( String typeid );
	//获取某种状态下的商品数量
	int getCountGoods (String name,
					   String type,
					   String userId,
					   String status);


	//发布或下架商品，更改商品状态
	void releaseGoods(String userId,
					  String goodsname,
					  String goodstype,
					  String goodschildtype,
					  String description,
					  String price,
					  Integer bargain,
					  Integer old,
					  Integer  inDate,
					  String place,
					  List<String> goodspicList,
					  List<String> picnameList);


	List<GoodsResult> getGoodsListPage(Integer startPage, Integer pageSize,
									   String name,
									   String type,
									   String userId,
									   String status);

	List<GoodsResult> getGoodsListByIdList(List<String> goodsidList);

	GoodsResult GoodsToResult(Goods goods);

	List<GoodsResult> GoodsToResultList(List<Goods> goodsList);

//List<GoodsMore> allGoods ( String status, Integer startPage,
//						   Integer pageSize, HttpServletRequest request );

//登录用户发布的商品，我的发布
//List<Goods> userGoods ( String status, String userid,
 //                       Integer startPage, Integer pageSize, HttpServletRequest request );
//int findGoodsNumberByUserId ( String status, String userid );
//按照类别搜索的某一类商品
//List<Goods> typeGoods ( String status, String goodstype,
 //                       Integer startPage, Integer pageSize, HttpServletRequest request );

//商品详情
//Goods goodsDetail ( String goodsid, HttpServletRequest request );
//模糊搜索商品
//List<Goods> searchGoods ( String status, String goodsname,
//                          Integer startPage, Integer pageSize, HttpServletRequest request );




}
