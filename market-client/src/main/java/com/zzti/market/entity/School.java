package com.zzti.market.entity;

public class School {
    private Integer schoolid;
    private String userid;
    public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	private String schoolname;

    private String college;

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

	@Override
	public String toString() {
		return "School [schoolid=" + schoolid + ", userid=" + userid
				+ ", schoolname=" + schoolname + ", college=" + college + "]";
	}

	
	
    
}