package com.sekift.www.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TerminalTypeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TerminalTypeInfoExample() {
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

        public Criteria andTrmlFormIdIsNull() {
            addCriterion("trml_form_id is null");
            return (Criteria) this;
        }

        public Criteria andTrmlFormIdIsNotNull() {
            addCriterion("trml_form_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrmlFormIdEqualTo(Byte value) {
            addCriterion("trml_form_id =", value, "trmlFormId");
            return (Criteria) this;
        }

        public Criteria andTrmlFormIdNotEqualTo(Byte value) {
            addCriterion("trml_form_id <>", value, "trmlFormId");
            return (Criteria) this;
        }

        public Criteria andTrmlFormIdGreaterThan(Byte value) {
            addCriterion("trml_form_id >", value, "trmlFormId");
            return (Criteria) this;
        }

        public Criteria andTrmlFormIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("trml_form_id >=", value, "trmlFormId");
            return (Criteria) this;
        }

        public Criteria andTrmlFormIdLessThan(Byte value) {
            addCriterion("trml_form_id <", value, "trmlFormId");
            return (Criteria) this;
        }

        public Criteria andTrmlFormIdLessThanOrEqualTo(Byte value) {
            addCriterion("trml_form_id <=", value, "trmlFormId");
            return (Criteria) this;
        }

        public Criteria andTrmlFormIdIn(List<Byte> values) {
            addCriterion("trml_form_id in", values, "trmlFormId");
            return (Criteria) this;
        }

        public Criteria andTrmlFormIdNotIn(List<Byte> values) {
            addCriterion("trml_form_id not in", values, "trmlFormId");
            return (Criteria) this;
        }

        public Criteria andTrmlFormIdBetween(Byte value1, Byte value2) {
            addCriterion("trml_form_id between", value1, value2, "trmlFormId");
            return (Criteria) this;
        }

        public Criteria andTrmlFormIdNotBetween(Byte value1, Byte value2) {
            addCriterion("trml_form_id not between", value1, value2, "trmlFormId");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeIdIsNull() {
            addCriterion("prdct_type_id is null");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeIdIsNotNull() {
            addCriterion("prdct_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeIdEqualTo(Integer value) {
            addCriterion("prdct_type_id =", value, "prdctTypeId");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeIdNotEqualTo(Integer value) {
            addCriterion("prdct_type_id <>", value, "prdctTypeId");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeIdGreaterThan(Integer value) {
            addCriterion("prdct_type_id >", value, "prdctTypeId");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prdct_type_id >=", value, "prdctTypeId");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeIdLessThan(Integer value) {
            addCriterion("prdct_type_id <", value, "prdctTypeId");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("prdct_type_id <=", value, "prdctTypeId");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeIdIn(List<Integer> values) {
            addCriterion("prdct_type_id in", values, "prdctTypeId");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeIdNotIn(List<Integer> values) {
            addCriterion("prdct_type_id not in", values, "prdctTypeId");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("prdct_type_id between", value1, value2, "prdctTypeId");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prdct_type_id not between", value1, value2, "prdctTypeId");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameIsNull() {
            addCriterion("trml_form_name is null");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameIsNotNull() {
            addCriterion("trml_form_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameEqualTo(String value) {
            addCriterion("trml_form_name =", value, "trmlFormName");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameNotEqualTo(String value) {
            addCriterion("trml_form_name <>", value, "trmlFormName");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameGreaterThan(String value) {
            addCriterion("trml_form_name >", value, "trmlFormName");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameGreaterThanOrEqualTo(String value) {
            addCriterion("trml_form_name >=", value, "trmlFormName");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameLessThan(String value) {
            addCriterion("trml_form_name <", value, "trmlFormName");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameLessThanOrEqualTo(String value) {
            addCriterion("trml_form_name <=", value, "trmlFormName");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameLike(String value) {
            addCriterion("trml_form_name like", value, "trmlFormName");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameNotLike(String value) {
            addCriterion("trml_form_name not like", value, "trmlFormName");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameIn(List<String> values) {
            addCriterion("trml_form_name in", values, "trmlFormName");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameNotIn(List<String> values) {
            addCriterion("trml_form_name not in", values, "trmlFormName");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameBetween(String value1, String value2) {
            addCriterion("trml_form_name between", value1, value2, "trmlFormName");
            return (Criteria) this;
        }

        public Criteria andTrmlFormNameNotBetween(String value1, String value2) {
            addCriterion("trml_form_name not between", value1, value2, "trmlFormName");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameIsNull() {
            addCriterion("prdct_type_name is null");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameIsNotNull() {
            addCriterion("prdct_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameEqualTo(String value) {
            addCriterion("prdct_type_name =", value, "prdctTypeName");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameNotEqualTo(String value) {
            addCriterion("prdct_type_name <>", value, "prdctTypeName");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameGreaterThan(String value) {
            addCriterion("prdct_type_name >", value, "prdctTypeName");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("prdct_type_name >=", value, "prdctTypeName");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameLessThan(String value) {
            addCriterion("prdct_type_name <", value, "prdctTypeName");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameLessThanOrEqualTo(String value) {
            addCriterion("prdct_type_name <=", value, "prdctTypeName");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameLike(String value) {
            addCriterion("prdct_type_name like", value, "prdctTypeName");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameNotLike(String value) {
            addCriterion("prdct_type_name not like", value, "prdctTypeName");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameIn(List<String> values) {
            addCriterion("prdct_type_name in", values, "prdctTypeName");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameNotIn(List<String> values) {
            addCriterion("prdct_type_name not in", values, "prdctTypeName");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameBetween(String value1, String value2) {
            addCriterion("prdct_type_name between", value1, value2, "prdctTypeName");
            return (Criteria) this;
        }

        public Criteria andPrdctTypeNameNotBetween(String value1, String value2) {
            addCriterion("prdct_type_name not between", value1, value2, "prdctTypeName");
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