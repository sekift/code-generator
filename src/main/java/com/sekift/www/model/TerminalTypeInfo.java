package com.sekift.www.model;

import java.util.Date;

public class TerminalTypeInfo {
    private Integer id;

    private Byte trmlFormId;

    private Integer prdctTypeId;

    private String trmlFormName;

    private String prdctTypeName;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getTrmlFormId() {
        return trmlFormId;
    }

    public void setTrmlFormId(Byte trmlFormId) {
        this.trmlFormId = trmlFormId;
    }

    public Integer getPrdctTypeId() {
        return prdctTypeId;
    }

    public void setPrdctTypeId(Integer prdctTypeId) {
        this.prdctTypeId = prdctTypeId;
    }

    public String getTrmlFormName() {
        return trmlFormName;
    }

    public void setTrmlFormName(String trmlFormName) {
        this.trmlFormName = trmlFormName == null ? null : trmlFormName.trim();
    }

    public String getPrdctTypeName() {
        return prdctTypeName;
    }

    public void setPrdctTypeName(String prdctTypeName) {
        this.prdctTypeName = prdctTypeName == null ? null : prdctTypeName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}