package com.zzti.market.service;


import com.zzti.market.entity.Goods;
import com.zzti.market.entity.Goodspicture;

import java.util.List;

public interface GoodspictureService {
	List<Goodspicture> selectPictureByGoodsId ( Goods goods );
}
