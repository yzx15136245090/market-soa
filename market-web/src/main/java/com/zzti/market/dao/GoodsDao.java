package com.zzti.market.dao;

import com.zzti.market.entity.Goods;
import com.zzti.market.mapper.GoodsMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

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
        return  goodsMapper.insert(record);
    }

    public List<Goods> findGoodsByLImit( String status,  Integer startPage,  Integer pageSize ){
        return  goodsMapper.findGoodsByLImit(status, startPage, pageSize);
    }

    public int findGoodsNumber(String status){
        return  goodsMapper.findGoodsNumber(status);
    }


    public List<Goods> selectByUserId(String userid,String status, Integer startPage,  Integer pageSize ){
        return goodsMapper.selectByUserId(userid, status, startPage, pageSize);
    }

   public int findGoodsNumberByUserId ( String status,String userid ){
        return  goodsMapper.findGoodsNumberByUserId(status, userid);
    }


    public  List<Goods> selectByGoodsType (String goodstype,  String status, Integer startPage, Integer pageSize ){
        return  goodsMapper.selectByGoodsType(goodstype, status, startPage, pageSize);
    }
    public  int findGoodsNumberByGoodsType ( String status, String goodstype ){

        return  goodsMapper.findGoodsNumberByGoodsType(status, goodstype);
    }


    public List<Goods> searchGoods(String status, String goodsname, Integer startPage,  Integer pageSize){
        return  goodsMapper.searchGoods(status, goodsname, startPage, pageSize);
    }

    public int searchGoodsNumber (String status,String goodsname ){
       return  goodsMapper.searchGoodsNumber(status, goodsname);
    }

    public  Goods getGoodsById(String goodsid){
        return  goodsMapper.selectByPrimaryKey(goodsid);
    }

}
