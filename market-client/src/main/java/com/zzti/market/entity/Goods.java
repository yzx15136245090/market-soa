package com.zzti.market.entity;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
    private String goodsid;

	private String goodsname;

    private String description;

    private String userid;

    private Integer price;

    private Date reatedate;

    private String goodstype;

    private Integer bargain;

    private String old;

    private Integer indate;

    private String status;

    private Integer publishtimes;

    private Integer seetimes;

    private String goodschildtype;

    private String place;

	public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getReatedate() {
        return reatedate;
    }

    public void setReatedate(Date reatedate) {
        this.reatedate = reatedate;
    }

    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype == null ? null : goodstype.trim();
    }

    public Integer getBargain() {
        return bargain;
    }

    public void setBargain(Integer bargain) {
        this.bargain = bargain;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old == null ? null : old.trim();
    }

    public Integer getIndate() {
        return indate;
    }

    public void setIndate(Integer indate) {
        this.indate = indate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getPublishtimes() {
        return publishtimes;
    }

    public void setPublishtimes(Integer publishtimes) {
        this.publishtimes = publishtimes;
    }

    public Integer getSeetimes() {
        return seetimes;
    }

    public void setSeetimes(Integer seetimes) {
        this.seetimes = seetimes;
    }

    public String getGoodschildtype() {
        return goodschildtype;
    }

    public void setGoodschildtype(String goodschildtype) {
        this.goodschildtype = goodschildtype == null ? null : goodschildtype.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

	
}