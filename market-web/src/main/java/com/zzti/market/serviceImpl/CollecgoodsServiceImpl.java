package com.zzti.market.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zzti.market.dao.CollecgoodsDao;
import com.zzti.market.dao.GoodsDao;
import com.zzti.market.dao.GoodspictureDao;
import com.zzti.market.dao.UserDao;
import com.zzti.market.entity.Collecgoods;
import com.zzti.market.entity.Goods;
import com.zzti.market.entity.User;
import com.zzti.market.mapper.CollecgoodsMapper;
import com.zzti.market.mapper.GoodsMapper;
import com.zzti.market.mapper.GoodspictureMapper;
import com.zzti.market.mapper.UserMapper;
import com.zzti.market.service.CollecgoodsService;
import org.springframework.stereotype.Service;


@Service
public class CollecgoodsServiceImpl implements CollecgoodsService {
	@Resource
	GoodspictureDao goodspictureDao;
	@Resource
	CollecgoodsDao collecgoodsDao;
	@Resource
	GoodsDao goodsDao;
	@Resource
	UserDao userDao;
	@Override
	public void collectGoods(String goodsid, HttpSession session) {
		// TODO Auto-generated method stub
		Collecgoods goods=new Collecgoods();
		User user=new User();
		goods.setGoodsid(goodsid);
		user=(User) session.getAttribute("user");
		goods.setUserid(user.getUserId());
		goods.setCollectdate(new Date());
		collecgoodsDao.insert(goods);
	}

	@Override
	public List<Goods> myCollectGoods( HttpSession session, Integer startPage,
									   Integer pageSize, HttpServletRequest request) {
		// TODO Auto-generated method stub
		User user=(User) session.getAttribute("user");
		List<Collecgoods> collecGoods	=collecgoodsDao.myCollect(user.getUserId(), startPage, pageSize);
		List<Goods> goodsList =  new ArrayList<Goods>();
		for(int i=0;i<collecGoods.size();i++){
		Goods goods=new Goods();
		goods=goodsDao.selectByPrimaryKey(collecGoods.get(i).getGoodsid());
		System.out.println(collecGoods.get(i).getGoodsid()+"id");
		String username=userDao.selectByPrimaryKey(goods.getUserid()).getUserName();
		goods.setUsername(username);
		StringBuffer sa=request.getRequestURL();
		String sa2=sa.substring(0,sa.lastIndexOf("/"));
		String picurl=sa2.substring(0,sa2.lastIndexOf("/"));
		String requesturl=picurl+"/picture/";
		goods.setRequesturl(requesturl);
		goods.setPictureurl(goodspictureDao.selectByGoodsId(collecGoods.get(i).getGoodsid()).get(0).getPictureurl());
	    goodsList.add(goods);
		}
		return goodsList;
	}

	@Override
	public int findCollec(HttpSession session) {
		// TODO Auto-generated method stub
		User	user=(User) session.getAttribute("user");
		return collecgoodsDao.findCollecNumber(user.getUserId());
	}

	@Override
	public int weatherCollect(String goodsid, HttpSession session) {
		// TODO Auto-generated method stub
		User user=(User) session.getAttribute("user");
		return collecgoodsDao.weatherCollect(user.getUserId(), goodsid);
	}

}
