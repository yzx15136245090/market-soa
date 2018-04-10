package com.zzti.market.entity;

import java.io.Serializable;

//父类
public class Fathertype implements Serializable{
    private String typeid;

    private String typename;

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }
}