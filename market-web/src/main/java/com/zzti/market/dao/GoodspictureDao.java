package com.zzti.market.dao;

import com.zzti.market.entity.Goodspicture;
import com.zzti.market.mapper.GoodspictureMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Title:
 * @Package: com.zzti.market.dao
 * @ClassName: GoodspictureDao
 * @Description:
 * @Author: zhixiang.yang
 * @CreateDate: 2018/4/11 16:30
 * @UpdateUser: zhixiang.yang
 * @UpdateDate: 2018/4/11 16:30
 * @UpdateRemark:
 * @Version: 1.0
 */
@Repository
public class GoodspictureDao {
    @Resource
    GoodspictureMapper goodspictureMapper;

    public  int insert ( Goodspicture record ){
        return  goodspictureMapper.insert(record);
    }
}
