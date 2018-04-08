package com.zzti.market.serviceImpl;

import com.zzti.market.entity.Goods;
import com.zzti.market.entity.Goodspicture;
import com.zzti.market.mapper.GoodspictureMapper;
import com.zzti.market.service.GoodspictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class GoodspictureServiceImpl implements GoodspictureService {
	
	
	@Resource
    GoodspictureMapper goodspictureMapper;

	@Override
	public List<Goodspicture> selectPictureByGoodsId(Goods goods) {
		// TODO Auto-generated method stub
		return goodspictureMapper.selectByGoodsId(goods.getGoodsid());
	}




}
