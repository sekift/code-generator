package com.sekift.www.dao;

import com.sekift.www.model.CCoupon;
import com.sekift.www.model.CCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CCouponMapper {
    int countByExample(CCouponExample example);

    int deleteByExample(CCouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CCoupon record);

    int insertSelective(CCoupon record);

    List<CCoupon> selectByExample(CCouponExample example);

    CCoupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CCoupon record, @Param("example") CCouponExample example);

    int updateByExample(@Param("record") CCoupon record, @Param("example") CCouponExample example);

    int updateByPrimaryKeySelective(CCoupon record);

    int updateByPrimaryKey(CCoupon record);
}