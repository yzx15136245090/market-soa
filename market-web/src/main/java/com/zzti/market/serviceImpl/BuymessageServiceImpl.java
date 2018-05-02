package com.zzti.market.serviceImpl;


import com.alibaba.dubbo.common.utils.StringUtils;
import com.zzti.market.dao.BuymessageDao;
import com.zzti.market.entity.Buymessage;
import com.zzti.market.service.BuymessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class BuymessageServiceImpl implements BuymessageService {

		@Resource
		BuymessageDao buymessageDao;

		private Buymessage buymessage;


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

	@Override
	public List<Buymessage> getBuymessage(String userid, Integer startPage, Integer pageSize, Integer buystatus) {
		try {
			if(StringUtils.isNotEmpty(userid)){
				return buymessageDao.getBuymessageByUserId(buystatus,startPage*pageSize,pageSize,userid);

            }else{
				return  buymessageDao.getBuymessagePage(buystatus,startPage*pageSize,pageSize);

			}
		} catch (Exception e) {
			throw new RuntimeException("getBuymessage异常");
		}
	}

	@Override
	public int getCountBuymessage(String userid, Integer buystatus) {

		try {
			if(StringUtils.isNotEmpty(userid)){
                return  buymessageDao.getCountByStatusAndUserId(buystatus,userid);
            }else {
                return  buymessageDao.getCountByStatus(buystatus);
            }
		} catch (Exception e) {
			throw new RuntimeException("getCountBuymessage");
		}
	}
}
