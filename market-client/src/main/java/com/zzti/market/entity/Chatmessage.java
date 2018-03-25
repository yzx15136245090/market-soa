package com.zzti.market.entity;

import java.util.Date;

public class Chatmessage {
    private String chatid;

    private String userid1;

    private String userid2;

    private String replymessage;

    private Date sendtime;

    private Integer weathersee;

    public String getChatid() {
        return chatid;
    }

    public void setChatid(String chatid) {
        this.chatid = chatid == null ? null : chatid.trim();
    }

    public String getUserid1() {
        return userid1;
    }

    public void setUserid1(String userid1) {
        this.userid1 = userid1 == null ? null : userid1.trim();
    }

    public String getUserid2() {
        return userid2;
    }

    public void setUserid2(String userid2) {
        this.userid2 = userid2 == null ? null : userid2.trim();
    }

    public String getReplymessage() {
        return replymessage;
    }

    public void setReplymessage(String replymessage) {
        this.replymessage = replymessage == null ? null : replymessage.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getWeathersee() {
        return weathersee;
    }

    public void setWeathersee(Integer weathersee) {
        this.weathersee = weathersee;
    }
}