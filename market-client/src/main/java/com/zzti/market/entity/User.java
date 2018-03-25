package com.zzti.market.entity;

import java.io.Serializable;

public class User implements Serializable {


    private String userId;

    private String userName;

    private String userSchool;

    private String passWord;

    private String telphone;

    private String email;

    private String credit;

    private String inviteCode;

    private String power;

    private String photo;

    private String identCode;

    public String getUserId () {
        return userId;
    }

    public void setUserId ( String userId ) {
        this.userId = userId;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName ( String userName ) {
        this.userName = userName;
    }

    public String getUserSchool () {
        return userSchool;
    }

    public void setUserSchool ( String userSchool ) {
        this.userSchool = userSchool;
    }

    public String getPassWord () {
        return passWord;
    }

    public void setPassWord ( String passWord ) {
        this.passWord = passWord;
    }

    public String getTelphone () {
        return telphone;
    }

    public void setTelphone ( String telphone ) {
        this.telphone = telphone;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getCredit () {
        return credit;
    }

    public void setCredit ( String credit ) {
        this.credit = credit;
    }

    public String getInviteCode () {
        return inviteCode;
    }

    public void setInviteCode ( String inviteCode ) {
        this.inviteCode = inviteCode;
    }

    public String getPower () {
        return power;
    }

    public void setPower ( String power ) {
        this.power = power;
    }

    public String getPhoto () {
        return photo;
    }

    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    public String getIdentCode () {
        return identCode;
    }

    public void setIdentCode ( String identCode ) {
        this.identCode = identCode;
    }
}
