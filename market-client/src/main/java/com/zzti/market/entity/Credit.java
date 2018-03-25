package com.zzti.market.entity;
//积分规则
public class Credit {
    private String creditid;

    private String action;

    private Integer creditchange;

    private String userid;

    public String getCreditid() {
        return creditid;
    }

    public void setCreditid(String creditid) {
        this.creditid = creditid == null ? null : creditid.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public Integer getCreditchange() {
        return creditchange;
    }

    public void setCreditchange(Integer creditchange) {
        this.creditchange = creditchange;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}