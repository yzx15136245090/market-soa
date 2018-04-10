package com.zzti.market.entity;

import java.io.Serializable;
import java.util.Date;

public class Ident implements Serializable {
    private String identid;

    private String userid;

    private String identphoto;

    private String studentnum;

    private Integer identstatus;

    private Date identtime;
    private String pictureurl;
    private String requesturl;
    
    
    
    public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public String getRequesturl() {
		return requesturl;
	}

	public void setRequesturl(String requesturl) {
		this.requesturl = requesturl;
	}

	public String getIdentid() {
        return identid;
    }

    public void setIdentid(String identid) {
        this.identid = identid == null ? null : identid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getIdentphoto() {
        return identphoto;
    }

    public void setIdentphoto(String identphoto) {
        this.identphoto = identphoto == null ? null : identphoto.trim();
    }

    public String getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(String studentnum) {
        this.studentnum = studentnum == null ? null : studentnum.trim();
    }

    public Integer getIdentstatus() {
        return identstatus;
    }

    public void setIdentstatus(Integer identstatus) {
        this.identstatus = identstatus;
    }

    public Date getIdenttime() {
        return identtime;
    }

    public void setIdenttime(Date identtime) {
        this.identtime = identtime;
    }

	@Override
	public String toString() {
		return "Ident [identid=" + identid + ", userid=" + userid
				+ ", identphoto=" + identphoto + ", studentnum=" + studentnum
				+ ", identstatus=" + identstatus + ", identtime=" + identtime
				+ "]";
	}
    
}