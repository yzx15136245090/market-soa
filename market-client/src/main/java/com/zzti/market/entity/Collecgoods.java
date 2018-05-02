package com.zzti.market.entity;
//收藏商品
import java.io.Serializable;
import java.util.Date;

public class Collecgoods implements Serializable {
    private String userid;

    private Date collectdate;

    private String goodsid;

    private String type;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Date getCollectdate() {
        return collectdate;
    }

    public void setCollectdate(Date collectdate) {
        this.collectdate = collectdate;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}