package com.sekift.www.model;

import java.util.Date;

public class ResLocIdea {
    private Integer id;

    private Integer resLocId;

    private String ideaName;

    private Integer userId;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResLocId() {
        return resLocId;
    }

    public void setResLocId(Integer resLocId) {
        this.resLocId = resLocId;
    }

    public String getIdeaName() {
        return ideaName;
    }

    public void setIdeaName(String ideaName) {
        this.ideaName = ideaName == null ? null : ideaName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}