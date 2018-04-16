package com.zzti.market.serviceImpl;


import com.zzti.market.dao.BuymessageDao;
import com.zzti.market.entity.Buymessage;
import com.zzti.market.entity.Result;
import com.zzti.market.entity.User;
import com.zzti.market.mapper.BuymessageMapper;
import com.zzti.market.mapper.UserMapper;
import com.zzti.market.service.BuymessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class BuymessageServiceImpl implements BuymessageService {
   		 private Buymessage buymessage;

		@Resource
		BuymessageDao buymessageDao;

	@Override
	public int ReleaseBuymessage(String userId, String buygoodsname, String buygoodsdescrip, Integer wantprice, String wantsite, Integer buyindate) {
		String bid = UUID.randomUUID().toString().replace("-", "");
		buymessage=new Buymessage();
		buymessage.setUserid(userId);
		buymessage.setBuymessageid(bid);
		buymessage.setBuygoodsname(buygoodsname);
		buymessage.setBuygoodsdescrip(buygoodsdescrip);
		buymessage.setWantprice(wantprice);
		buymessage.setWantsite(wantsite);
		buymessage.setBuyindate(buyindate);
		buymessage.setCreatdate(new Date());
		buymessage.setBuystatus(0);
		return buymessageDao.insert(buymessage);
	}

//	public List<Buymessage> allBuymessage(int buystatus) {
//		// TODO Auto-generated method stub
//		return buymessageMapper.allMessage(buystatus);
//	}
//	public List<Buymessage> allBuymessage(int buystatus, Integer startPage,
//			Integer pageSize) {
//		// TODO Auto-generated method stub
//		int size = startPage*pageSize;
//		List<Buymessage> findBuymessageByLImit = buymessageMapper.findBuymessageByLImit(buystatus, size, pageSize);
//		for(int i=0;i<findBuymessageByLImit.size();i++)
//		{
//			Buymessage buymessage=findBuymessageByLImit.get(i);
//			System.out.println(buymessage.getUserid());
//			user=userMapper.selectByPrimaryKey(buymessage.getUserid());
//			buymessage.setUsername(user.getUserName());
//		}
//		return findBuymessageByLImit;
//	}
//	public int findBuymessageNumber(int buystatus) {
//
//		return buymessageMapper.findBuymessageNumber(buystatus);
//	}

}
