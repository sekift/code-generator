package com.sekift.www.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResLocIdeaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResLocIdeaExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andResLocIdIsNull() {
            addCriterion("res_loc_id is null");
            return (Criteria) this;
        }

        public Criteria andResLocIdIsNotNull() {
            addCriterion("res_loc_id is not null");
            return (Criteria) this;
        }

        public Criteria andResLocIdEqualTo(Integer value) {
            addCriterion("res_loc_id =", value, "resLocId");
            return (Criteria) this;
        }

        public Criteria andResLocIdNotEqualTo(Integer value) {
            addCriterion("res_loc_id <>", value, "resLocId");
            return (Criteria) this;
        }

        public Criteria andResLocIdGreaterThan(Integer value) {
            addCriterion("res_loc_id >", value, "resLocId");
            return (Criteria) this;
        }

        public Criteria andResLocIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_loc_id >=", value, "resLocId");
            return (Criteria) this;
        }

        public Criteria andResLocIdLessThan(Integer value) {
            addCriterion("res_loc_id <", value, "resLocId");
            return (Criteria) this;
        }

        public Criteria andResLocIdLessThanOrEqualTo(Integer value) {
            addCriterion("res_loc_id <=", value, "resLocId");
            return (Criteria) this;
        }

        public Criteria andResLocIdIn(List<Integer> values) {
            addCriterion("res_loc_id in", values, "resLocId");
            return (Criteria) this;
        }

        public Criteria andResLocIdNotIn(List<Integer> values) {
            addCriterion("res_loc_id not in", values, "resLocId");
            return (Criteria) this;
        }

        public Criteria andResLocIdBetween(Integer value1, Integer value2) {
            addCriterion("res_loc_id between", value1, value2, "resLocId");
            return (Criteria) this;
        }

        public Criteria andResLocIdNotBetween(Integer value1, Integer value2) {
            addCriterion("res_loc_id not between", value1, value2, "resLocId");
            return (Criteria) this;
        }

        public Criteria andIdeaNameIsNull() {
            addCriterion("idea_name is null");
            return (Criteria) this;
        }

        public Criteria andIdeaNameIsNotNull() {
            addCriterion("idea_name is not null");
            return (Criteria) this;
        }

        public Criteria andIdeaNameEqualTo(String value) {
            addCriterion("idea_name =", value, "ideaName");
            return (Criteria) this;
        }

        public Criteria andIdeaNameNotEqualTo(String value) {
            addCriterion("idea_name <>", value, "ideaName");
            return (Criteria) this;
        }

        public Criteria andIdeaNameGreaterThan(String value) {
            addCriterion("idea_name >", value, "ideaName");
            return (Criteria) this;
        }

        public Criteria andIdeaNameGreaterThanOrEqualTo(String value) {
            addCriterion("idea_name >=", value, "ideaName");
            return (Criteria) this;
        }

        public Criteria andIdeaNameLessThan(String value) {
            addCriterion("idea_name <", value, "ideaName");
            return (Criteria) this;
        }

        public Criteria andIdeaNameLessThanOrEqualTo(String value) {
            addCriterion("idea_name <=", value, "ideaName");
            return (Criteria) this;
        }

        public Criteria andIdeaNameLike(String value) {
            addCriterion("idea_name like", value, "ideaName");
            return (Criteria) this;
        }

        public Criteria andIdeaNameNotLike(String value) {
            addCriterion("idea_name not like", value, "ideaName");
            return (Criteria) this;
        }

        public Criteria andIdeaNameIn(List<String> values) {
            addCriterion("idea_name in", values, "ideaName");
            return (Criteria) this;
        }

        public Criteria andIdeaNameNotIn(List<String> values) {
            addCriterion("idea_name not in", values, "ideaName");
            return (Criteria) this;
        }

        public Criteria andIdeaNameBetween(String value1, String value2) {
            addCriterion("idea_name between", value1, value2, "ideaName");
            return (Criteria) this;
        }

        public Criteria andIdeaNameNotBetween(String value1, String value2) {
            addCriterion("idea_name not between", value1, value2, "ideaName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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