package com.zzti.market.dao;

import com.zzti.market.entity.Collecgoods;
import com.zzti.market.mapper.CollecgoodsMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title:
 * @Package: com.zzti.market.dao
 * @ClassName: CollectDao
 * @Description:
 * @Author: zhixiang.yang
 * @CreateDate: 2018/4/23 10:21
 * @UpdateUser: zhixiang.yang
 * @UpdateDate: 2018/4/23 10:21
 * @UpdateRemark:
 * @Version: 1.0
 */

@Repository
public class CollectDao {
    @Resource
    private CollecgoodsMapper collecgoodsMapper;

    public int addCollectGoods(Collecgoods collecgoods){
        return collecgoodsMapper.insert(collecgoods);
    }

    public int removeCollectGoods(String goodsid,String userid,String type){

        return  collecgoodsMapper.delete(goodsid,userid,type);
    }

    public int getCountCollectGoods(String userid,String type){
        return  collecgoodsMapper.findCollecNumber(userid,type);
    }

    public List<Collecgoods> getCollectgoodsPage(String userid,Integer startPage,Integer pageSize,String type){
        return collecgoodsMapper.myCollect(userid, startPage, pageSize,type);
    }

}
