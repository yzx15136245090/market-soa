package com.zzti.market.dao;

import com.zzti.market.entity.Fathertype;
import com.zzti.market.mapper.FathertypeMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title:
 * @Package: com.zzti.market.dao
 * @ClassName: FathertypeDao
 * @Description:
 * @Author: zhixiang.yang
 * @CreateDate: 2018/4/10 10:15
 * @UpdateUser: zhixiang.yang
 * @UpdateDate: 2018/4/10 10:15
 * @UpdateRemark:
 * @Version: 1.0
 */
@Repository
public class FathertypeDao {
    @Resource
    FathertypeMapper fathertypeMapper;

    public List<Fathertype> selectfathertype(){
        return  fathertypeMapper.selectfathertype();
    }
}
