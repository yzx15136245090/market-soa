package com.zzti.market.serviceImpl;


import com.zzti.market.dao.CollectDao;
import com.zzti.market.entity.Collecgoods;
import com.zzti.market.service.CollectgoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CollectgoodsServiceImpl implements CollectgoodsService {

    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private CollectDao collectDao;

    private Collecgoods collecgoods;

    @Override
    public int addCollectGoods(String goodsid, String userid,String type) {
        collecgoods=new Collecgoods();
        collecgoods.setUserid(userid);
        collecgoods.setGoodsid(goodsid);
        collecgoods.setType(type);
        collecgoods.setCollectdate(new Date());
        try {
            return collectDao.addCollectGoods(collecgoods);

        } catch (DataAccessException e) {
            throw new RuntimeException("addCollectGoods异常");
        }
    }

    @Override
    public int removeCollectGoods(String goodsid, String userid,String type) {
        try {
            return collectDao.removeCollectGoods(goodsid,userid,type);
        } catch (DataAccessException e) {
            throw new RuntimeException("removeCollectGoods异常");
        }
    }

    @Override
    public int getCountCollectGoods(String userid,String type) {
        try {
            return collectDao.getCountCollectGoods(userid,type);
        } catch (Exception e) {
            throw new RuntimeException("getCountCollectGoods异常");
        }
    }

    @Override
    public List<Collecgoods> getCollecgoodsPage(Integer startPage, Integer pageSize, String userid,String type) {
        try {
            return collectDao.getCollectgoodsPage(userid, startPage * pageSize, pageSize, type);
        } catch (Exception e) {
            LOGGER.error("getCollecgoodsPage异常", e);
            throw new RuntimeException("");
        }
    }
}
