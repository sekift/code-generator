package com.sekift.www.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CCouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CCouponExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCouponCodeIsNull() {
            addCriterion("coupon_code is null");
            return (Criteria) this;
        }

        public Criteria andCouponCodeIsNotNull() {
            addCriterion("coupon_code is not null");
            return (Criteria) this;
        }

        public Criteria andCouponCodeEqualTo(String value) {
            addCriterion("coupon_code =", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotEqualTo(String value) {
            addCriterion("coupon_code <>", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeGreaterThan(String value) {
            addCriterion("coupon_code >", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_code >=", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeLessThan(String value) {
            addCriterion("coupon_code <", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeLessThanOrEqualTo(String value) {
            addCriterion("coupon_code <=", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeLike(String value) {
            addCriterion("coupon_code like", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotLike(String value) {
            addCriterion("coupon_code not like", value, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeIn(List<String> values) {
            addCriterion("coupon_code in", values, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotIn(List<String> values) {
            addCriterion("coupon_code not in", values, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeBetween(String value1, String value2) {
            addCriterion("coupon_code between", value1, value2, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotBetween(String value1, String value2) {
            addCriterion("coupon_code not between", value1, value2, "couponCode");
            return (Criteria) this;
        }

        public Criteria andCouponNameIsNull() {
            addCriterion("coupon_name is null");
            return (Criteria) this;
        }

        public Criteria andCouponNameIsNotNull() {
            addCriterion("coupon_name is not null");
            return (Criteria) this;
        }

        public Criteria andCouponNameEqualTo(String value) {
            addCriterion("coupon_name =", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotEqualTo(String value) {
            addCriterion("coupon_name <>", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThan(String value) {
            addCriterion("coupon_name >", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_name >=", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThan(String value) {
            addCriterion("coupon_name <", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThanOrEqualTo(String value) {
            addCriterion("coupon_name <=", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLike(String value) {
            addCriterion("coupon_name like", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotLike(String value) {
            addCriterion("coupon_name not like", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameIn(List<String> values) {
            addCriterion("coupon_name in", values, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotIn(List<String> values) {
            addCriterion("coupon_name not in", values, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameBetween(String value1, String value2) {
            addCriterion("coupon_name between", value1, value2, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotBetween(String value1, String value2) {
            addCriterion("coupon_name not between", value1, value2, "couponName");
            return (Criteria) this;
        }

        public Criteria andHeaderImgIsNull() {
            addCriterion("header_img is null");
            return (Criteria) this;
        }

        public Criteria andHeaderImgIsNotNull() {
            addCriterion("header_img is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderImgEqualTo(String value) {
            addCriterion("header_img =", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgNotEqualTo(String value) {
            addCriterion("header_img <>", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgGreaterThan(String value) {
            addCriterion("header_img >", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgGreaterThanOrEqualTo(String value) {
            addCriterion("header_img >=", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgLessThan(String value) {
            addCriterion("header_img <", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgLessThanOrEqualTo(String value) {
            addCriterion("header_img <=", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgLike(String value) {
            addCriterion("header_img like", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgNotLike(String value) {
            addCriterion("header_img not like", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgIn(List<String> values) {
            addCriterion("header_img in", values, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgNotIn(List<String> values) {
            addCriterion("header_img not in", values, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgBetween(String value1, String value2) {
            addCriterion("header_img between", value1, value2, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgNotBetween(String value1, String value2) {
            addCriterion("header_img not between", value1, value2, "headerImg");
            return (Criteria) this;
        }

        public Criteria andFooterColorIsNull() {
            addCriterion("footer_color is null");
            return (Criteria) this;
        }

        public Criteria andFooterColorIsNotNull() {
            addCriterion("footer_color is not null");
            return (Criteria) this;
        }

        public Criteria andFooterColorEqualTo(String value) {
            addCriterion("footer_color =", value, "footerColor");
            return (Criteria) this;
        }

        public Criteria andFooterColorNotEqualTo(String value) {
            addCriterion("footer_color <>", value, "footerColor");
            return (Criteria) this;
        }

        public Criteria andFooterColorGreaterThan(String value) {
            addCriterion("footer_color >", value, "footerColor");
            return (Criteria) this;
        }

        public Criteria andFooterColorGreaterThanOrEqualTo(String value) {
            addCriterion("footer_color >=", value, "footerColor");
            return (Criteria) this;
        }

        public Criteria andFooterColorLessThan(String value) {
            addCriterion("footer_color <", value, "footerColor");
            return (Criteria) this;
        }

        public Criteria andFooterColorLessThanOrEqualTo(String value) {
            addCriterion("footer_color <=", value, "footerColor");
            return (Criteria) this;
        }

        public Criteria andFooterColorLike(String value) {
            addCriterion("footer_color like", value, "footerColor");
            return (Criteria) this;
        }

        public Criteria andFooterColorNotLike(String value) {
            addCriterion("footer_color not like", value, "footerColor");
            return (Criteria) this;
        }

        public Criteria andFooterColorIn(List<String> values) {
            addCriterion("footer_color in", values, "footerColor");
            return (Criteria) this;
        }

        public Criteria andFooterColorNotIn(List<String> values) {
            addCriterion("footer_color not in", values, "footerColor");
            return (Criteria) this;
        }

        public Criteria andFooterColorBetween(String value1, String value2) {
            addCriterion("footer_color between", value1, value2, "footerColor");
            return (Criteria) this;
        }

        public Criteria andFooterColorNotBetween(String value1, String value2) {
            addCriterion("footer_color not between", value1, value2, "footerColor");
            return (Criteria) this;
        }

        public Criteria andCouponTotalIsNull() {
            addCriterion("coupon_total is null");
            return (Criteria) this;
        }

        public Criteria andCouponTotalIsNotNull() {
            addCriterion("coupon_total is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTotalEqualTo(Integer value) {
            addCriterion("coupon_total =", value, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalNotEqualTo(Integer value) {
            addCriterion("coupon_total <>", value, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalGreaterThan(Integer value) {
            addCriterion("coupon_total >", value, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_total >=", value, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalLessThan(Integer value) {
            addCriterion("coupon_total <", value, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_total <=", value, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalIn(List<Integer> values) {
            addCriterion("coupon_total in", values, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalNotIn(List<Integer> values) {
            addCriterion("coupon_total not in", values, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalBetween(Integer value1, Integer value2) {
            addCriterion("coupon_total between", value1, value2, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_total not between", value1, value2, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andCanUseUserIsNull() {
            addCriterion("can_use_user is null");
            return (Criteria) this;
        }

        public Criteria andCanUseUserIsNotNull() {
            addCriterion("can_use_user is not null");
            return (Criteria) this;
        }

        public Criteria andCanUseUserEqualTo(Byte value) {
            addCriterion("can_use_user =", value, "canUseUser");
            return (Criteria) this;
        }

        public Criteria andCanUseUserNotEqualTo(Byte value) {
            addCriterion("can_use_user <>", value, "canUseUser");
            return (Criteria) this;
        }

        public Criteria andCanUseUserGreaterThan(Byte value) {
            addCriterion("can_use_user >", value, "canUseUser");
            return (Criteria) this;
        }

        public Criteria andCanUseUserGreaterThanOrEqualTo(Byte value) {
            addCriterion("can_use_user >=", value, "canUseUser");
            return (Criteria) this;
        }

        public Criteria andCanUseUserLessThan(Byte value) {
            addCriterion("can_use_user <", value, "canUseUser");
            return (Criteria) this;
        }

        public Criteria andCanUseUserLessThanOrEqualTo(Byte value) {
            addCriterion("can_use_user <=", value, "canUseUser");
            return (Criteria) this;
        }

        public Criteria andCanUseUserIn(List<Byte> values) {
            addCriterion("can_use_user in", values, "canUseUser");
            return (Criteria) this;
        }

        public Criteria andCanUseUserNotIn(List<Byte> values) {
            addCriterion("can_use_user not in", values, "canUseUser");
            return (Criteria) this;
        }

        public Criteria andCanUseUserBetween(Byte value1, Byte value2) {
            addCriterion("can_use_user between", value1, value2, "canUseUser");
            return (Criteria) this;
        }

        public Criteria andCanUseUserNotBetween(Byte value1, Byte value2) {
            addCriterion("can_use_user not between", value1, value2, "canUseUser");
            return (Criteria) this;
        }

        public Criteria andUserPerIsNull() {
            addCriterion("user_per is null");
            return (Criteria) this;
        }

        public Criteria andUserPerIsNotNull() {
            addCriterion("user_per is not null");
            return (Criteria) this;
        }

        public Criteria andUserPerEqualTo(Integer value) {
            addCriterion("user_per =", value, "userPer");
            return (Criteria) this;
        }

        public Criteria andUserPerNotEqualTo(Integer value) {
            addCriterion("user_per <>", value, "userPer");
            return (Criteria) this;
        }

        public Criteria andUserPerGreaterThan(Integer value) {
            addCriterion("user_per >", value, "userPer");
            return (Criteria) this;
        }

        public Criteria andUserPerGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_per >=", value, "userPer");
            return (Criteria) this;
        }

        public Criteria andUserPerLessThan(Integer value) {
            addCriterion("user_per <", value, "userPer");
            return (Criteria) this;
        }

        public Criteria andUserPerLessThanOrEqualTo(Integer value) {
            addCriterion("user_per <=", value, "userPer");
            return (Criteria) this;
        }

        public Criteria andUserPerIn(List<Integer> values) {
            addCriterion("user_per in", values, "userPer");
            return (Criteria) this;
        }

        public Criteria andUserPerNotIn(List<Integer> values) {
            addCriterion("user_per not in", values, "userPer");
            return (Criteria) this;
        }

        public Criteria andUserPerBetween(Integer value1, Integer value2) {
            addCriterion("user_per between", value1, value2, "userPer");
            return (Criteria) this;
        }

        public Criteria andUserPerNotBetween(Integer value1, Integer value2) {
            addCriterion("user_per not between", value1, value2, "userPer");
            return (Criteria) this;
        }

        public Criteria andUseThresholdIsNull() {
            addCriterion("use_threshold is null");
            return (Criteria) this;
        }

        public Criteria andUseThresholdIsNotNull() {
            addCriterion("use_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andUseThresholdEqualTo(BigDecimal value) {
            addCriterion("use_threshold =", value, "useThreshold");
            return (Criteria) this;
        }

        public Criteria andUseThresholdNotEqualTo(BigDecimal value) {
            addCriterion("use_threshold <>", value, "useThreshold");
            return (Criteria) this;
        }

        public Criteria andUseThresholdGreaterThan(BigDecimal value) {
            addCriterion("use_threshold >", value, "useThreshold");
            return (Criteria) this;
        }

        public Criteria andUseThresholdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("use_threshold >=", value, "useThreshold");
            return (Criteria) this;
        }

        public Criteria andUseThresholdLessThan(BigDecimal value) {
            addCriterion("use_threshold <", value, "useThreshold");
            return (Criteria) this;
        }

        public Criteria andUseThresholdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("use_threshold <=", value, "useThreshold");
            return (Criteria) this;
        }

        public Criteria andUseThresholdIn(List<BigDecimal> values) {
            addCriterion("use_threshold in", values, "useThreshold");
            return (Criteria) this;
        }

        public Criteria andUseThresholdNotIn(List<BigDecimal> values) {
            addCriterion("use_threshold not in", values, "useThreshold");
            return (Criteria) this;
        }

        public Criteria andUseThresholdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("use_threshold between", value1, value2, "useThreshold");
            return (Criteria) this;
        }

        public Criteria andUseThresholdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("use_threshold not between", value1, value2, "useThreshold");
            return (Criteria) this;
        }

        public Criteria andFaceValueIsNull() {
            addCriterion("face_value is null");
            return (Criteria) this;
        }

        public Criteria andFaceValueIsNotNull() {
            addCriterion("face_value is not null");
            return (Criteria) this;
        }

        public Criteria andFaceValueEqualTo(BigDecimal value) {
            addCriterion("face_value =", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueNotEqualTo(BigDecimal value) {
            addCriterion("face_value <>", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueGreaterThan(BigDecimal value) {
            addCriterion("face_value >", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("face_value >=", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueLessThan(BigDecimal value) {
            addCriterion("face_value <", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("face_value <=", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueIn(List<BigDecimal> values) {
            addCriterion("face_value in", values, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueNotIn(List<BigDecimal> values) {
            addCriterion("face_value not in", values, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("face_value between", value1, value2, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("face_value not between", value1, value2, "faceValue");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsIsNull() {
            addCriterion("can_use_goods is null");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsIsNotNull() {
            addCriterion("can_use_goods is not null");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsEqualTo(String value) {
            addCriterion("can_use_goods =", value, "canUseGoods");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsNotEqualTo(String value) {
            addCriterion("can_use_goods <>", value, "canUseGoods");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsGreaterThan(String value) {
            addCriterion("can_use_goods >", value, "canUseGoods");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsGreaterThanOrEqualTo(String value) {
            addCriterion("can_use_goods >=", value, "canUseGoods");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsLessThan(String value) {
            addCriterion("can_use_goods <", value, "canUseGoods");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsLessThanOrEqualTo(String value) {
            addCriterion("can_use_goods <=", value, "canUseGoods");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsLike(String value) {
            addCriterion("can_use_goods like", value, "canUseGoods");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsNotLike(String value) {
            addCriterion("can_use_goods not like", value, "canUseGoods");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsIn(List<String> values) {
            addCriterion("can_use_goods in", values, "canUseGoods");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsNotIn(List<String> values) {
            addCriterion("can_use_goods not in", values, "canUseGoods");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsBetween(String value1, String value2) {
            addCriterion("can_use_goods between", value1, value2, "canUseGoods");
            return (Criteria) this;
        }

        public Criteria andCanUseGoodsNotBetween(String value1, String value2) {
            addCriterion("can_use_goods not between", value1, value2, "canUseGoods");
            return (Criteria) this;
        }

        public Criteria andGetModeIsNull() {
            addCriterion("get_mode is null");
            return (Criteria) this;
        }

        public Criteria andGetModeIsNotNull() {
            addCriterion("get_mode is not null");
            return (Criteria) this;
        }

        public Criteria andGetModeEqualTo(Byte value) {
            addCriterion("get_mode =", value, "getMode");
            return (Criteria) this;
        }

        public Criteria andGetModeNotEqualTo(Byte value) {
            addCriterion("get_mode <>", value, "getMode");
            return (Criteria) this;
        }

        public Criteria andGetModeGreaterThan(Byte value) {
            addCriterion("get_mode >", value, "getMode");
            return (Criteria) this;
        }

        public Criteria andGetModeGreaterThanOrEqualTo(Byte value) {
            addCriterion("get_mode >=", value, "getMode");
            return (Criteria) this;
        }

        public Criteria andGetModeLessThan(Byte value) {
            addCriterion("get_mode <", value, "getMode");
            return (Criteria) this;
        }

        public Criteria andGetModeLessThanOrEqualTo(Byte value) {
            addCriterion("get_mode <=", value, "getMode");
            return (Criteria) this;
        }

        public Criteria andGetModeIn(List<Byte> values) {
            addCriterion("get_mode in", values, "getMode");
            return (Criteria) this;
        }

        public Criteria andGetModeNotIn(List<Byte> values) {
            addCriterion("get_mode not in", values, "getMode");
            return (Criteria) this;
        }

        public Criteria andGetModeBetween(Byte value1, Byte value2) {
            addCriterion("get_mode between", value1, value2, "getMode");
            return (Criteria) this;
        }

        public Criteria andGetModeNotBetween(Byte value1, Byte value2) {
            addCriterion("get_mode not between", value1, value2, "getMode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}