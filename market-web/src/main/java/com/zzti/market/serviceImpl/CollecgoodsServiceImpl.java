package com.zzti.market.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zzti.market.entity.Collecgoods;
import com.zzti.market.entity.Goods;
import com.zzti.market.mapper.CollecgoodsMapper;
import com.zzti.market.mapper.GoodsMapper;
import com.zzti.market.mapper.GoodspictureMapper;
import com.zzti.market.mapper.UserMapper;
import com.zzti.market.service.CollecgoodsService;
import org.springframework.stereotype.Service;


@Service
public class CollecgoodsServiceImpl implements CollecgoodsService {
	@Resource
	GoodspictureMapper goodspictureMapper;
	@Resource
	CollecgoodsMapper collecgoodsMapper;
	@Resource
	GoodsMapper goodsMapper;
	@Resource
	UserMapper userMapper;
	//@Override
	/*public void collectGoods(String goodsid, HttpSession session) {
		// TODO Auto-generated method stub
		Collecgoods goods=new Collecgoods();
		User user=new User();
		goods.setGoodsid(goodsid);
		user=(User) session.getAttribute("user");
		goods.setUserid(user.getUserid());
		goods.setCollectdate(new Date());
		collecgoodsMapper.insert(goods);
	}*/

/*	@Override
	public List<Goods> myCollectGoods( HttpSession session, Integer startPage,
									   Integer pageSize, HttpServletRequest request) {
		// TODO Auto-generated method stub
		User user=(User) session.getAttribute("user");
		List<Collecgoods> collecGoods	=collecgoodsMapper.myCollect(user.getUserid(), startPage, pageSize);
		List<Goods> goodsList =  new ArrayList<Goods>();
		for(int i=0;i<collecGoods.size();i++){
		Goods goods=new Goods();
		goods=goodsMapper.selectByPrimaryKey(collecGoods.get(i).getGoodsid());
		System.out.println(collecGoods.get(i).getGoodsid()+"id");
		String username=userMapper.selectByPrimaryKey(goods.getUserid()).getUsername();
		goods.setUsername(username);
		StringBuffer sa=request.getRequestURL();
		String sa2=sa.substring(0,sa.lastIndexOf("/"));
		String picurl=sa2.substring(0,sa2.lastIndexOf("/"));
		String requesturl=picurl+"/picture/";
		goods.setRequesturl(requesturl);
		goods.setPictureurl(goodspictureMapper.selectByGoodsId(collecGoods.get(i).getGoodsid()).get(0).getPictureurl());
	    goodsList.add(goods);	
		}
		return goodsList;
	}

	@Override
	public int findCollec(HttpSession session) {
		// TODO Auto-generated method stub
		User	user=(User) session.getAttribute("user");
		return collecgoodsMapper.findCollecNumber(user.getUserid());
	}

	@Override
	public int weatherCollect(String goodsid, HttpSession session) {
		// TODO Auto-generated method stub
		User user=(User) session.getAttribute("user");
		return collecgoodsMapper.weatherCollect(user.getUserid(), goodsid);
	}
*/
}
