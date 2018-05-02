package com.zzti.market.serviceImpl;


import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.zzti.market.dao.FathertypeDao;
import com.zzti.market.dao.GoodsDao;
import com.zzti.market.dao.GoodspictureDao;
import com.zzti.market.dao.UserDao;
import com.zzti.market.entity.*;
import com.zzti.market.enums.CommonStatus;
import com.zzti.market.mapper.*;
import com.zzti.market.result.GoodsResult;
import com.zzti.market.service.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsServiceImpl implements GoodsService {
	
    private Goods goods;
	private Goodspicture goodspicture;
	@Resource
	GoodspictureDao goodspictureDao;
	@Resource
	ChildtypeMapper childtypeMapper;
	@Resource
	FathertypeDao fathertypeDao;
	@Resource
	GoodsDao goodsDao;

	@Resource
	UserDao userDao;


	private GoodsResult goodsResult;

	private User user;


	public List<Fathertype> fathertype() {
		List<Fathertype> list= fathertypeDao.selectfathertype();
		return list;
	}
	public List<Childtype> childtype(String typeid) {
		// TODO Auto-generated method stub
		return childtypeMapper.selectchildtype(typeid);
	}

	@Override
	public int getCountGoods(String name,
							 String type,
							 String userId,
							 String status) {
		try {
			if(StringUtils.isEmpty(name)&&StringUtils.isEmpty(type)&&StringUtils.isEmpty(userId)) {
				return goodsDao.findGoodsNumber(status);
			}else if(StringUtils.isNotEmpty(name)){
				return  goodsDao.searchGoodsNumber(status,name);
			}else if(StringUtils.isNotEmpty(type)){
				return goodsDao.findGoodsNumberByGoodsType(status,type);
			}else if(StringUtils.isNotEmpty(userId)){
				return goodsDao.findGoodsNumberByUserId(status,userId);
			}else{
				return  0;
			}
		} catch (DataAccessException e) {
		    throw new RuntimeException("getCountGoods");
		}
	}

	@Override
	public 	void releaseGoods(String userId,
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
								List<String> picnameList){
		String gid = UUID.randomUUID().toString().replace("-", "");
		goods=new Goods();
		goods.setGoodsid(gid);
		goods.setGoodsname(goodsname);
		goods.setUserid(userId);
		goods.setReatedate(new Date());
		goods.setGoodstype(goodstype);
		goods.setGoodschildtype(goodschildtype);
		goods.setDescription(description);
		goods.setPrice(Integer.valueOf(price));
		goods.setBargain(bargain);
		goods.setOld(String.valueOf(old));
		goods.setIndate(inDate);
		goods.setPlace(place);
		goods.setSeetimes(0);
		goods.setPublishtimes(1);
		goods.setStatus(CommonStatus.STATUS_IN.getCode());
		goodsDao.insertGoods(goods);
		for(int i=0;i<goodspicList.size();i++){
				//保存图片并且保存到数据库
				goodspicture=new Goodspicture();
				goodspicture.setGoodspicture(goodspicList.get(i));
				goodspicture.setPictureurl(picnameList.get(i));
				goodspicture.setGoodsid(gid);
				goodspictureDao.insert(goodspicture);
			}
		}



	@Override
	public List<GoodsResult> getGoodsListPage( Integer startPage,
											   Integer pageSize,
											   String name,
											   String type,
											   String userId,
											   String status) {
		int size=startPage*pageSize;
		List<Goods> goodsList = new ArrayList<>();
		try {
			if(StringUtils.isNotEmpty(name)){
				goodsList=goodsDao.searchGoods(status,name,size,pageSize);
			}else if(StringUtils.isNotEmpty(type)){
				goodsList=goodsDao.selectByGoodsType(type,status,size,pageSize);
			}else if(StringUtils.isNotEmpty(userId)){
				goodsList=goodsDao.selectByUserId(userId,status,size,pageSize);
			}else if(StringUtils.isEmpty(name)&&StringUtils.isEmpty(type)&&StringUtils.isEmpty(userId)) {
				goodsList = goodsDao.findGoodsByLImit(CommonStatus.STATUS_IN.getCode(), size, pageSize);
			}
			if(CollectionUtils.isNotEmpty(goodsList)){
				return  this.GoodsToResultList(goodsList);
			}else{
				return  null;
			}
		} catch (DataAccessException e) {
		    throw new RuntimeException("getGoodsList");
		}
	}

	@Override
	public List<GoodsResult> getGoodsListByIdList(List<String> goodsidList) {
		List<Goods> list=new ArrayList<>();
		for(String id:goodsidList){
			list.add(goodsDao.getGoodsById(id));
		}
		return this.GoodsToResultList(list);
	}

	@Override
	public GoodsResult GoodsToResult(Goods goods) {
		goodsResult=new GoodsResult();
		BeanUtils.copyProperties(goods,goodsResult);
		user=userDao.selectByPrimaryKey(goods.getUserid());
		List<Goodspicture> goodspictureList=goodspictureDao.selectByGoodsId(goods.getGoodsid());
		for(Goodspicture g:goodspictureList){
			g.setPictureurl("http://47.93.99.237:8080/picture/"+g.getPictureurl());
		}
		goodsResult.setUsername(user.getUserName());
		goodsResult.setCredit(user.getCredit());
		goodsResult.setGoodspicture(goodspictureList);
		return goodsResult;
	}

	@Override
	public List<GoodsResult> GoodsToResultList(List<Goods> goodsList) {
		List<GoodsResult> list=new ArrayList<>();
		for(Goods g:goodsList){
			list.add(this.GoodsToResult(g));
		}
		return list;
	}

//	public List<GoodsMore> allGoods(String status, Integer startPage,
//			Integer pageSize,HttpServletRequest request) {
//		int size = startPage*pageSize;
//		List<GoodsMore> findGoodsMoreByLImit = goodsMoreMapper.findGoodsMoreByLImit(status, size, pageSize);
//		for(int i=0;i<findGoodsMoreByLImit.size();i++)
//		{
//			System.out.println(findGoodsMoreByLImit.get(i).getGoodsid());
//			GoodsMore goodsMore = findGoodsMoreByLImit.get(i);
//			String goodsid=goodsMore.getGoodsid();
//			if(goodspictureMapper.selectByGoodsId(goodsid).size()!=0){
//			goodsMore.setPictureurl(goodspictureMapper.selectByGoodsId(goodsid).get(0).getPictureurl());
//			StringBuffer sa=request.getRequestURL();
//			System.out.println();
//			String sa2=sa.substring(0,sa.lastIndexOf("/"));
//			String picurl=sa2.substring(0,sa2.lastIndexOf("/"));
//			String requesturl=picurl+"/picture/";
//			System.out.println(requesturl);
//			goodsMore.setRequesturl(requesturl);
//			}
//			else{
//				continue;
//			}
//		}
//		return findGoodsMoreByLImit;
//	}
//
//	public int findGoodsNumber(String status) {
//
//		return goodsMapper.findGoodsNumber(status);
//	}
//
//
//	public List<Goods> userGoods(String status, String userid,
//			Integer startPage, Integer pageSize,HttpServletRequest request) {
//		// TODO Auto-generated method stub
//		int size = startPage*pageSize;
//		List<Goods> goodslist=goodsMapper.selectByUserId(userid, status, startPage, pageSize);
//				for(int i=0;i<goodslist.size();i++)
//				{
//					Goods goods= goodslist.get(i);
//					String goodsid=goods.getGoodsid();
//					StringBuffer sa=request.getRequestURL();
//					String sa2=sa.substring(0,sa.lastIndexOf("/"));
//					String picurl=sa2.substring(0,sa2.lastIndexOf("/"));
//					String requesturl=picurl+"/picture/";
//					goods.setRequesturl(requesturl);
//					goods.setPictureurl(goodspictureMapper.selectByGoodsId(goodsid).get(0).getPictureurl());
//				}
//				return goodslist;
//	}
//	public int findGoodsNumberByUserId(String status, String userid) {
//
//		return goodsMapper.findGoodsNumberByUserId(status, userid);
//	}
//
//	public Goods goodsDetail(String goodsid,HttpServletRequest request){
//		List<Goodspicture> listpicurl=goodspictureMapper.selectByGoodsId(goodsid);
//		Goods goods=goodsMapper.selectByPrimaryKey(goodsid);
//	//	System.out.println(goodsid+"foodsid");
//		User user=userMapper.selectByPrimaryKey(goods.getUserid());
//		//System.out.println(user.getUserid()+"userid");
//		StringBuffer sa=request.getRequestURL();
//		String sa2=sa.substring(0,sa.lastIndexOf("/"));
//		String picurl=sa2.substring(0,sa2.lastIndexOf("/"));
//		String requesturl=picurl+"/picture/";
//		goods.setRequesturl(requesturl);
//		goods.setPictureurl(listpicurl.get(0).getPictureurl());
//		goods.setUsername(user.getUserName());
//		if(listpicurl.size()==1){
//			goods.setPicurl1(listpicurl.get(0).getPictureurl());
//			goods.setPicurl2(listpicurl.get(0).getPictureurl());
//			goods.setPicurl3(listpicurl.get(0).getPictureurl());
//		}
//		else if(listpicurl.size()==2){
//			goods.setPicurl1(listpicurl.get(1).getPictureurl());
//			goods.setPicurl2(listpicurl.get(1).getPictureurl());
//			goods.setPicurl3(listpicurl.get(1).getPictureurl());
//		}
//		else if(listpicurl.size()==3){
//			goods.setPicurl1(listpicurl.get(1).getPictureurl());
//			goods.setPicurl2(listpicurl.get(2).getPictureurl());
//			goods.setPicurl3(listpicurl.get(2).getPictureurl());
//			}
//		else if(listpicurl.size()==4){
//			goods.setPicurl1(listpicurl.get(1).getPictureurl());
//			goods.setPicurl2(listpicurl.get(2).getPictureurl());
//			goods.setPicurl3(listpicurl.get(3).getPictureurl());
//		}
//		return goods;
//
//	}
//
//
//	public  List<Goods> typeGoods(String status, String goodstype,
//	Integer startPage, Integer pageSize,HttpServletRequest request)
//	{
//		int size = startPage*pageSize;
//		List<Goods>  findGoodsByType= goodsMapper.selectByGoodsType(goodstype,status, startPage, pageSize);
//		for(int i=0;i<findGoodsByType.size();i++)
//		{
//			System.out.println(findGoodsByType.get(i).getGoodsid());
//			Goods goods = findGoodsByType.get(i);
//			String goodsid=goods.getGoodsid();
//			goods.setPictureurl(goodspictureMapper.selectByGoodsId(goodsid).get(0).getPictureurl());
//			StringBuffer sa=request.getRequestURL();
//			String sa2=sa.substring(0,sa.lastIndexOf("/"));
//			String picurl=sa2.substring(0,sa2.lastIndexOf("/"));
//			String requesturl=picurl+"/picture/";
//			goods.setRequesturl(requesturl);
//		}
//		System.out.println(findGoodsByType.size()+"dax");
//		return findGoodsByType;
//	}
//	public int findGoodsNumberByGoodsType(String status,String goodstype){
//		return goodsMapper.findGoodsNumberByGoodsType(status, goodstype);
//	}
//	@Override
//	public List<Goods> searchGoods(String status, String goodsname,
//			Integer startPage, Integer pageSize, HttpServletRequest request) {
//		// TODO Auto-generated method stub
//		int size = startPage*pageSize;
//		Childtype childtype=childtypeMapper.childSearchGoods(goodsname);
//		String goodschildtype=childtype.getChildtypeid();
//		List<Goods> goodsList=goodsMapper.searchGoods(status,goodschildtype,goodsname,startPage,pageSize);
//		for(int i=0;i<goodsList .size();i++)
//		{
//			Goods goods = goodsList.get(i);
//			String goodsid=goods.getGoodsid();
//			goods.setPictureurl(goodspictureMapper.selectByGoodsId(goodsid).get(0).getPictureurl());
//			StringBuffer sa=request.getRequestURL();
//			String sa2=sa.substring(0,sa.lastIndexOf("/"));
//			String picurl=sa2.substring(0,sa2.lastIndexOf("/"));
//			String requesturl=picurl+"/picture/";
//			goods.setRequesturl(requesturl);
//		}
//		return goodsList;
//
//
//	}
//
//	@Override
//	public int findGoodsNumberBySearch(String status, String goodsname) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	


	
	
	
}
