package com.zzti.market.entity;

import java.util.Date;

public class Tip {
    private String tipid;

    private String userid1;

    private String userid2;

    private String tipmessage;

    private Date tiptime;

    private Integer tipstatus;

	public String getTipid() {
		return tipid;
	}

	public void setTipid(String tipid) {
		this.tipid = tipid;
	}

	public String getUserid1() {
		return userid1;
	}

	public void setUserid1(String userid1) {
		this.userid1 = userid1;
	}

	public String getUserid2() {
		return userid2;
	}

	public void setUserid2(String userid2) {
		this.userid2 = userid2;
	}

	public String getTipmessage() {
		return tipmessage;
	}

	public void setTipmessage(String tipmessage) {
		this.tipmessage = tipmessage;
	}

	public Date getTiptime() {
		return tiptime;
	}

	public void setTiptime(Date tiptime) {
		this.tiptime = tiptime;
	}

	public Integer getTipstatus() {
		return tipstatus;
	}

	public void setTipstatus(Integer tipstatus) {
		this.tipstatus = tipstatus;
	}
    
}