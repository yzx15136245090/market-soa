package com.zzti.market.enums;

import java.io.Serializable;

/**
 * @Title:
 * @Package: com.zzti.market.enums
 * @ClassName: ResultType
 * @Description:
 * @Author: zhixiang.yang
 * @CreateDate: 2018/4/10 14:17
 * @UpdateUser: zhixiang.yang
 * @UpdateDate: 2018/4/10 14:17
 * @UpdateRemark:
 * @Version: 1.0
 */
public enum ResultType implements Serializable{
    RESULT_SUCCESS("成功", 1),
    RESULT_ERROR("参数错误", 200),
    RESULT_USER("用户权限",-1);

    private ResultType(String description,Integer status) {
        this.description = description;
        this.status = status;
    }

    private String description;
    private Integer status;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
