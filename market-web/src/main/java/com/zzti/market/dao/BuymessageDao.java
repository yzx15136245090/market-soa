package com.zzti.market.dao;

import com.zzti.market.entity.Buymessage;
import com.zzti.market.mapper.BuymessageMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Title:
 * @Package: com.zzti.market.dao
 * @ClassName: BuymessageDao
 * @Description:
 * @Author: zhixiang.yang
 * @CreateDate: 2018/4/16 16:07
 * @UpdateUser: zhixiang.yang
 * @UpdateDate: 2018/4/16 16:07
 * @UpdateRemark:
 * @Version: 1.0
 */
@Repository
public class BuymessageDao {
    @Resource
    BuymessageMapper buymessageMapper;
    public int insert(Buymessage buymessage){
       return buymessageMapper.insert(buymessage);
    }
}
