package com.sekift.www.model;

import java.math.BigDecimal;
import java.util.Date;

public class CCoupon {
    private Integer id;

    private String couponCode;

    private String couponName;

    private String headerImg;

    private String footerColor;

    private Integer couponTotal;

    private Date beginTime;

    private Date endTime;

    private Byte canUseUser;

    private Integer userPer;

    private BigDecimal useThreshold;

    private BigDecimal faceValue;

    private String canUseGoods;

    private Byte getMode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode == null ? null : couponCode.trim();
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg == null ? null : headerImg.trim();
    }

    public String getFooterColor() {
        return footerColor;
    }

    public void setFooterColor(String footerColor) {
        this.footerColor = footerColor == null ? null : footerColor.trim();
    }

    public Integer getCouponTotal() {
        return couponTotal;
    }

    public void setCouponTotal(Integer couponTotal) {
        this.couponTotal = couponTotal;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getCanUseUser() {
        return canUseUser;
    }

    public void setCanUseUser(Byte canUseUser) {
        this.canUseUser = canUseUser;
    }

    public Integer getUserPer() {
        return userPer;
    }

    public void setUserPer(Integer userPer) {
        this.userPer = userPer;
    }

    public BigDecimal getUseThreshold() {
        return useThreshold;
    }

    public void setUseThreshold(BigDecimal useThreshold) {
        this.useThreshold = useThreshold;
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }

    public String getCanUseGoods() {
        return canUseGoods;
    }

    public void setCanUseGoods(String canUseGoods) {
        this.canUseGoods = canUseGoods == null ? null : canUseGoods.trim();
    }

    public Byte getGetMode() {
        return getMode;
    }

    public void setGetMode(Byte getMode) {
        this.getMode = getMode;
    }
}