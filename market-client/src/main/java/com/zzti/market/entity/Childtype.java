package com.zzti.market.entity;
//子类
public class Childtype {
    private String childtypeid;

    private String childtypename;

    private String typeid;

    public String getChildtypeid() {
        return childtypeid;
    }

    public void setChildtypeid(String childtypeid) {
        this.childtypeid = childtypeid == null ? null : childtypeid.trim();
    }

    public String getChildtypename() {
        return childtypename;
    }

    public void setChildtypename(String childtypename) {
        this.childtypename = childtypename == null ? null : childtypename.trim();
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }
}