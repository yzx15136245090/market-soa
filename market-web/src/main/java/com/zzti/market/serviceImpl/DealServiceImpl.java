package com.zzti.market.serviceImpl;


import com.zzti.market.entity.Deal;
import com.zzti.market.entity.Goods;
import com.zzti.market.entity.User;
import com.zzti.market.mapper.DealMapper;
import com.zzti.market.mapper.GoodsMapper;
import com.zzti.market.mapper.GoodspictureMapper;
import com.zzti.market.mapper.UserMapper;
import com.zzti.market.service.DealService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Service
public class DealServiceImpl implements DealService {
//	@Resource
//    GoodspictureMapper goodspictureMapper;
//	@Resource
//    GoodsMapper goodsMapper;
//	@Resource
//    DealMapper dealMapper;
//	@Resource
//    UserMapper userMapper;
//	public List<Goods> shopcatGoods(HttpSession session, Integer startPage, Integer pageSize, HttpServletRequest request){
//		User user=(User) session.getAttribute("user");
//		List<Deal> dealList=dealMapper.dealGoodsByUserId(0,user.getUserId(), startPage, pageSize);
//		List<Goods> goodsList =  new ArrayList<Goods>();
//		for(int i=0;i<dealList.size();i++){
//		Goods goods=new Goods();
//		goods=goodsMapper.selectByPrimaryKey(dealList.get(i).getGoodsid());
//		System.out.println(dealList.get(i).getGoodsid()+"id");
//		user=userMapper.selectByPrimaryKey(goods.getUserid());
//		goods.setUsername(user.getUserName());
//		StringBuffer sa=request.getRequestURL();
//		String sa2=sa.substring(0,sa.lastIndexOf("/"));
//		String picurl=sa2.substring(0,sa2.lastIndexOf("/"));
//		String requesturl=picurl+"/picture/";
//		goods.setRequesturl(requesturl);
//		goods.setPictureurl(goodspictureMapper.selectByGoodsId(dealList.get(i).getGoodsid()).get(0).getPictureurl());
//	    goodsList.add(goods);
//		}
//		return goodsList;
//	}
//	public int addShopCat(HttpSession session,String goodsid)
//	{
//		User user=(User) session.getAttribute("user");
//		Deal deal=new Deal();
//		deal.setGoodsid(goodsid);
//		deal.setUserid(user.getUserId());
//		deal.setDealstatus(0);
//		return dealMapper.insert(deal);
//	}
//	public int weatherAddShopCat(HttpSession session,String goodsid){
//		User user=(User) session.getAttribute("user");
//		return dealMapper.weatherAdd(user.getUserId(), goodsid);
//	}
//	public int shopCatNum(HttpSession session){
//		User user=(User) session.getAttribute("user");
//		return dealMapper.findshopCatNumber(user.getUserId());
//	}
//	public int addorder(HttpSession session,String goodsid){
//		User user=(User) session.getAttribute("user");
//		return dealMapper.updateStatus(1,user.getUserId(), goodsid);
//	}
//    public	List<Goods> SallOrder(HttpSession session,Integer startPage,Integer pageSize, HttpServletRequest request){
//    	User user=(User) session.getAttribute("user");
//    	List<Goods> mySall=new ArrayList<Goods>();
//    	List<Goods> myPub=goodsMapper.selectByUser(user.getUserId(), "0");
//    	List<Deal> mysallDeal=new ArrayList<Deal>();
//    	for(int i=0;i<myPub.size();i++){
//    		mysallDeal= dealMapper.sallOrde(1, myPub.get(i).getGoodsid(), startPage, pageSize);
//    	}
//    	for(int i=0;i<mysallDeal.size();i++){
//    		Goods goods=new Goods();
//    		goods=goodsMapper.selectByPrimaryKey(mysallDeal.get(i).getGoodsid());
//    		System.out.println(mysallDeal.get(i).getGoodsid()+"id");
//    		user=userMapper.selectByPrimaryKey(goods.getUserid());
//    		goods.setUsername(user.getUserName());
//    		StringBuffer sa=request.getRequestURL();
//    		String sa2=sa.substring(0,sa.lastIndexOf("/"));
//    		String picurl=sa2.substring(0,sa2.lastIndexOf("/"));
//    		String requesturl=picurl+"/picture/";
//    		goods.setRequesturl(requesturl);
//    		goods.setPictureurl(goodspictureMapper.selectByGoodsId(mysallDeal.get(i).getGoodsid()).get(0).getPictureurl());
//    		mySall.add(goods);
//    		}
//    		return mySall;
//	}
//   public int sallOrderNum(HttpSession session,Integer startPage,Integer pageSize, HttpServletRequest request){
//	return this.SallOrder(session, startPage, pageSize, request).size();
//   }
//  public  List<Goods> BuyOrder(HttpSession session,Integer startPage,Integer pageSize, HttpServletRequest request){
//		User user=(User) session.getAttribute("user");
//
//	  List<Deal> buy=dealMapper.dealGoodsByUserId(1, user.getUserId(), startPage, pageSize);
//	  List<Goods> myBuy=new ArrayList<Goods>();
//	  for(int i=0;i<buy.size();i++){
//  		Goods goods=new Goods();
//  		goods=goodsMapper.selectByPrimaryKey(buy.get(i).getGoodsid());
//  		System.out.println(buy.get(i).getGoodsid()+"id");
//  		user=userMapper.selectByPrimaryKey(goods.getUserid());
//  		goods.setUsername(user.getUserName());
//  		StringBuffer sa=request.getRequestURL();
//  		String sa2=sa.substring(0,sa.lastIndexOf("/"));
//  		String picurl=sa2.substring(0,sa2.lastIndexOf("/"));
//  		String requesturl=picurl+"/picture/";
//  		goods.setRequesturl(requesturl);
//  		goods.setPictureurl(goodspictureMapper.selectByGoodsId(buy.get(i).getGoodsid()).get(0).getPictureurl());
//  		myBuy.add(goods);
//  		}
//	  return myBuy;
//  }
// public int BuyOrderNum(HttpSession session,Integer startPage,Integer pageSize, HttpServletRequest request){
//	 return this.BuyOrder(session, startPage, pageSize, request).size();
// }
// public int weatherInBuy(HttpSession session,String goodsid){
//	 User user=(User) session.getAttribute("user");
//	 return dealMapper.findGoodsByStatus(1, user.getUserId(), goodsid);
// }
}
