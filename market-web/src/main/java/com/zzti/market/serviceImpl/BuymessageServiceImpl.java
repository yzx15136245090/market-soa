package com.zzti.market.serviceImpl;


import com.zzti.market.entity.Buymessage;
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
Buymessage buymessage;
User user;
@Resource
BuymessageMapper buymessageMapper;
@Resource
UserMapper userMapper;
	public void ReleaseBuymessage(Buymessage buymessage,
			HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub
		String buyid = UUID.randomUUID().toString().replace("-", "");
		buymessage.setBuymessageid(buyid);
		buymessage.setCreatdate(new Date());
		buymessage.setBuystatus(0);
		User user=new User();
		user=(User) session.getAttribute("user");
		buymessage.setUserid(user.getUserId());
		buymessageMapper.insert(buymessage);
	}
	public List<Buymessage> allBuymessage(int buystatus) {
		// TODO Auto-generated method stub
		return buymessageMapper.allMessage(buystatus);
	}
	public List<Buymessage> allBuymessage(int buystatus, Integer startPage,
			Integer pageSize) {
		// TODO Auto-generated method stub
		int size = startPage*pageSize;
		List<Buymessage> findBuymessageByLImit = buymessageMapper.findBuymessageByLImit(buystatus, size, pageSize);
		for(int i=0;i<findBuymessageByLImit.size();i++)
		{	
			Buymessage buymessage=findBuymessageByLImit.get(i);
			System.out.println(buymessage.getUserid());
			user=userMapper.selectByPrimaryKey(buymessage.getUserid());
			buymessage.setUsername(user.getUserName());
		}
		return findBuymessageByLImit;
	}
public int findBuymessageNumber(int buystatus) {
		
		return buymessageMapper.findBuymessageNumber(buystatus);
	}

}
