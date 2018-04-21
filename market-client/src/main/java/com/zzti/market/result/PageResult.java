package com.zzti.market.result;

import java.io.Serializable;

/**
 * @Title:
 * @Package: com.zzti.market.result
 * @ClassName: PageResult
 * @Description:
 * @Author: zhixiang.yang
 * @CreateDate: 2018/4/20 9:59
 * @UpdateUser: zhixiang.yang
 * @UpdateDate: 2018/4/20 9:59
 * @UpdateRemark:
 * @Version: 1.0
 */
public class PageResult extends Result implements Serializable{
    private int  count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
