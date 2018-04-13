package com.zzti.market.serviceImpl;


import com.zzti.market.dao.FathertypeDao;
import com.zzti.market.dao.GoodsDao;
import com.zzti.market.dao.GoodspictureDao;
import com.zzti.market.entity.*;
import com.zzti.market.mapper.*;
import com.zzti.market.service.GoodsService;
import org.apache.commons.lang.StringUtils;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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

//	public void ReleaseGoods(MultipartFile[] cms, Goods goods, HttpServletRequest request, HttpSession session) {
//
//		//插入商品信息
//		//session.setAttribute(user, value);
//		String gid = UUID.randomUUID().toString().replace("-", "");
//
//		User user=(User) session.getAttribute("user");
//		goods.setGoodsid(gid);
//		goods.setReatedate(new Date());
//		goods.setStatus("0");
//		goods.setSeetimes(0);
//		goods.setUserid(user.getUserId());
//		goodsMapper.insert(goods);
//		//上传商品图片
//		for(int i=0;i<cms.length;i++){
//			System.out.println(cms.length+"cms.length");
//			System.out.println(cms[i].getSize()+"size");
//			if(cms[i].getSize() !=0){
//				//保存图片并且保存到数据库
//				goodspicture=new Goodspicture();
//				String goodspic=UUID.randomUUID().toString().replace("-", "");
//				goodspicture.setGoodspicture(goodspic);
//				String pname=(cms[i].getOriginalFilename()).substring((cms[i].getOriginalFilename()).lastIndexOf("."));
//				String picname=goodspic+pname;
//				StringBuffer sa=request.getRequestURL();
//				String sa2=sa.substring(0,sa.lastIndexOf("/"));
//				String picurl=sa2.substring(0,sa2.lastIndexOf("/"));
//				System.out.println(sa);
//				System.out.println(picurl);
//				System.out.println(picname);
//				goods.setRequesturl(picurl+"/picture");
//				goodspicture.setPictureurl(picname);
//				String ddd=File.separator;
//				String p1 = request.getSession().getServletContext().getRealPath(ddd);
//				System.out.println(p1);
//				String path=p1.substring(0,p1.lastIndexOf(ddd))+ddd+"picture";
//				try {
//					System.out.println(path+ddd+picname);
//					cms[i].transferTo(new File(path+ddd+picname));
//				} catch (IllegalStateException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				goodspicture.setGoodsid(gid);
//				goodspictureMapper.insert(goodspicture);
//
//			}
//		}
//	}

	public List<Fathertype> fathertype() {
		List<Fathertype> list= fathertypeDao.selectfathertype();
		return list;
	}
	public List<Childtype> childtype(String typeid) {
		// TODO Auto-generated method stub
		return childtypeMapper.selectchildtype(typeid);
	}

	@Override
	public int getCountGoods(String status) {
		return 0;
	}

	@Override
	public int getCountGoodsByUserId(String status, String userId) {
		return 0;
	}

	@Override
	public int getCountGoodsByGoodsType(String status, String goodstype) {
		return 0;
	}

	@Override
	public int getCountGoodsBySearch(String status, String goodsname) {
		return 0;
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
								MultipartFile[] cms,
								HttpServletRequest request){
		String gid = UUID.randomUUID().toString().replace("-", "");
		goods=new Goods();
		goods.setGoodsid(gid);
		goods.setGoodsname(goodsname);
		goods.setGoodstype(goodstype);
		goods.setGoodschildtype(goodschildtype);
		goods.setDescription(description);
		goods.setPrice(Integer.valueOf(price));
		goods.setBargain(bargain);
		goods.setOld(String.valueOf(old));
		goods.setIndate(inDate);
		goods.setPlace(place);
		goodsDao.insertGoods(goods);
		for(int i=0;i<cms.length;i++){
			if(cms[i].getSize() !=0){
				//保存图片并且保存到数据库
				goodspicture=new Goodspicture();
				String goodspic=UUID.randomUUID().toString().replace("-", "");
				goodspicture.setGoodspicture(goodspic);
				String pname=(cms[i].getOriginalFilename()).substring((cms[i].getOriginalFilename()).lastIndexOf("."));
				String picname=goodspic+pname;
				StringBuffer sa=request.getRequestURL();
				String sa2=sa.substring(0,sa.lastIndexOf("/"));
				String picurl=sa2.substring(0,sa2.lastIndexOf("/"));
				goods.setRequesturl(picurl+"/picture");
				goodspicture.setPictureurl(picname);
				String ddd=File.separator;
				String p1 = request.getSession().getServletContext().getRealPath(ddd);
				String path=p1.substring(0,p1.lastIndexOf(ddd))+ddd+"picture";
				try {
					cms[i].transferTo(new File(path+ddd+picname));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				goodspicture.setGoodsid(gid);
				goodspictureDao.insert(goodspicture);
			}
		}
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
