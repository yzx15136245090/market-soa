package com.zzti.market.dao;

import com.zzti.market.entity.Childtype;
import com.zzti.market.mapper.ChildtypeMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.validation.groups.ConvertGroup;
import java.util.List;

/**
 * @ProjectName: market-soa
 * @Package: com.zzti.market.dao
 * @ClassName: ChildtypeDao
 * @Description: java类作用描述
 * @Author: zhixiang.yang
 * @CreateDate: 2018/3/30 9:36
 * @UpdateUser: zhixiang.yang
 * @UpdateDate: 2018/3/30 9:36
 * @UpdateRemark:
 * @Version: 1.0
 */
@Repository
public class ChildtypeDao {
    @Resource
    ChildtypeMapper childtypeMapper;

    public List<Childtype> getChildType(String typeid) {
        // TODO Auto-generated method stub
        return childtypeMapper.selectchildtype(typeid);
    }
}
