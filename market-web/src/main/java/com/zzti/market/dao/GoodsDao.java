package com.zzti.market.dao;

import com.zzti.market.entity.Goods;
import com.zzti.market.mapper.GoodsMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Title:
 * @Package: com.zzti.market.dao.daoImpl
 * @ClassName: GoodsDao
 * @Description:
 * @Author: zhixiang.yang
 * @CreateDate: 2018/4/12 14:11
 * @UpdateUser: zhixiang.yang
 * @UpdateDate: 2018/4/12 14:11
 * @UpdateRemark:
 * @Version: 1.0
 */
@Repository
public class GoodsDao {
    @Resource
    GoodsMapper goodsMapper;
    public int insertGoods ( Goods record ){
        return  goodsMapper.insertSelective(record);
    }
}
