package com.zzti.market.entity;
//交易记录
import java.io.Serializable;
import java.util.Date;

public class Deal implements Serializable {
    private String goodsid;

    private String userid;

    private Date dealtime;

    private String dealdecrease;

    private Integer score;

    private String moredealdecrease;

    private Integer dealstatus;

    private String koux1;

    private String koux2;

    private Date lastlongintime;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Date getDealtime() {
        return dealtime;
    }

    public void setDealtime(Date dealtime) {
        this.dealtime = dealtime;
    }

    public String getDealdecrease() {
        return dealdecrease;
    }

    public void setDealdecrease(String dealdecrease) {
        this.dealdecrease = dealdecrease == null ? null : dealdecrease.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getMoredealdecrease() {
        return moredealdecrease;
    }

    public void setMoredealdecrease(String moredealdecrease) {
        this.moredealdecrease = moredealdecrease == null ? null : moredealdecrease.trim();
    }

    public Integer getDealstatus() {
        return dealstatus;
    }

    public void setDealstatus(Integer dealstatus) {
        this.dealstatus = dealstatus;
    }

    public String getKoux1() {
        return koux1;
    }

    public void setKoux1(String koux1) {
        this.koux1 = koux1 == null ? null : koux1.trim();
    }

    public String getKoux2() {
        return koux2;
    }

    public void setKoux2(String koux2) {
        this.koux2 = koux2 == null ? null : koux2.trim();
    }

    public Date getLastlongintime() {
        return lastlongintime;
    }

    public void setLastlongintime(Date lastlongintime) {
        this.lastlongintime = lastlongintime;
    }
}