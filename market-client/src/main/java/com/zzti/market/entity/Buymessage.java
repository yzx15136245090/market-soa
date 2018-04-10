package com.zzti.market.entity;

import java.io.Serializable;
import java.util.Date;

public class Buymessage implements Serializable {
    private String buymessageid;

    private Date creatdate;

    private String buygoodsname;

    private String buygoodsdescrip;

    private Integer wantprice;

    private Integer buyindate;

    private String wantsite;

    private Integer buystatus;

    private String userid;
    private String username;

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBuymessageid() {
        return buymessageid;
    }

    public void setBuymessageid(String buymessageid) {
        this.buymessageid = buymessageid == null ? null : buymessageid.trim();
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public String getBuygoodsname() {
        return buygoodsname;
    }

    public void setBuygoodsname(String buygoodsname) {
        this.buygoodsname = buygoodsname == null ? null : buygoodsname.trim();
    }

    public String getBuygoodsdescrip() {
        return buygoodsdescrip;
    }

    public void setBuygoodsdescrip(String buygoodsdescrip) {
        this.buygoodsdescrip = buygoodsdescrip == null ? null : buygoodsdescrip.trim();
    }

    public Integer getWantprice() {
        return wantprice;
    }

    public void setWantprice(Integer wantprice) {
        this.wantprice = wantprice;
    }

    public Integer getBuyindate() {
        return buyindate;
    }

    public void setBuyindate(Integer buyindate) {
        this.buyindate = buyindate;
    }

    public String getWantsite() {
        return wantsite;
    }

    public void setWantsite(String wantsite) {
        this.wantsite = wantsite == null ? null : wantsite.trim();
    }

    public Integer getBuystatus() {
        return buystatus;
    }

    public void setBuystatus(Integer buystatus) {
        this.buystatus = buystatus;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }


}