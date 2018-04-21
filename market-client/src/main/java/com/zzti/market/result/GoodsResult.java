package com.zzti.market.result;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title:
 * @Package: com.zzti.market.result
 * @ClassName: GoodsResult
 * @Description:
 * @Author: zhixiang.yang
 * @CreateDate: 2018/4/19 17:56
 * @UpdateUser: zhixiang.yang
 * @UpdateDate: 2018/4/19 17:56
 * @UpdateRemark:
 * @Version: 1.0
 */
public class GoodsResult implements Serializable{

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

    private String username;

    private String credit;

    private Object goodspicture;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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
        this.goodstype = goodstype;
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
        this.old = old;
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
        this.status = status;
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
        this.goodschildtype = goodschildtype;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public Object getGoodspicture() {
        return goodspicture;
    }

    public void setGoodspicture(Object goodspicture) {
        this.goodspicture = goodspicture;
    }
}
