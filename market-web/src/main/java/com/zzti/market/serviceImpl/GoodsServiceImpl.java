package com.zzti.market.serviceImpl;




import java.io.File;
import java.io.IOException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.zzti.market.dao.ChildtypeDao;
import com.zzti.market.dao.FathertypeDao;
import com.zzti.market.dao.GoodsDao;
import com.zzti.market.entity.*;
import com.zzti.market.mapper.*;
import com.zzti.market.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class GoodsServiceImpl implements GoodsService {
	

	@Resource
	FathertypeDao fathertypeDao;
	@Resource
	ChildtypeDao childtypeDao;
	@Resource
	GoodsDao goodsDao;

//
//	public void ReleaseGoods( MultipartFile[] cms, Goods goods, HttpServletRequest request, HttpSession session) {
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
//		goods.setUserid(user.getUserid());
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
	/**
	 * @method fathertype
	 * @Author: zhixiang.yang
	 * @Description: 获取一级分类列表
	 * @Date: 11:23 2018/3/30
	 * @param
	 * @return: java.util.List<com.zzti.market.entity.Fathertype>
	 */
	public List<Fathertype> fathertype() {

		return fathertypeDao.getFathertype();

	}
	/**
	 * @method childtype
	 * @Author: zhixiang.yang
	 * @Description:根据一级分类获取相应的二级分类列表
	 * @Date: 11:23 2018/3/30
	 * @param typeid
	 * @return: java.util.List<com.zzti.market.entity.Childtype>
	 */
	public List<Childtype> childtype( String typeid) {
		// TODO Auto-generated method stub
		return childtypeDao.getChildType(typeid);
	}

	public int getCountGoods (String status){
		return   goodsDao.getCountGoods(status);
	}

	public int getCountGoodsByUserId(String status,String userId){
		return  goodsDao.getCountGoodsByUserId(status,userId);
	}

	public int getCountGoodsByGoodsType ( String status, String goodstype ){
		return  goodsDao.getCountGoodsByGoodsType(status,goodstype);
	}
	public int getCountGoodsBySearch ( String status, String goodsname ){
		return goodsDao.getCountGoodsBySearch(status,goodsname);
	}


//	public List<GoodsMore> allGoods( String status, Integer startPage,
//									 Integer pageSize, HttpServletRequest request) {
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

//	public int findGoodsNumber(String status) {
//
//		return goodsMapper.findGoodsNumber(status);
//	}

	
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
//		goods.setUsername(user.getUsername());
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

//	@Override
//	public int findGoodsNumberBySearch(String status, String goodsname) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	
	
	
	


	
	
	
}
