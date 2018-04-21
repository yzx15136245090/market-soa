package com.zzti.market.enums;

import java.io.Serializable;

/**
 * @Title:
 * @Package: com.zzti.market.enums
 * @ClassName: CommonStatus
 * @Description:
 * @Author: zhixiang.yang
 * @CreateDate: 2018/4/19 18:28
 * @UpdateUser: zhixiang.yang
 * @UpdateDate: 2018/4/19 18:28
 * @UpdateRemark:
 * @Version: 1.0
 */
public enum  CommonStatus implements Serializable{
    STATUS_IN("0", "上架中"),
    STATUS_OUT("1", "已下架");

    private  CommonStatus(String code,String desc){
        this.code = code;
        this.desc = desc;
    }
    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
