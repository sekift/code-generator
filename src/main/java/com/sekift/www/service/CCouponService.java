package com.sekift.www.service;

import com.sekift.www.tool.JsonRslt;
import com.sekift.www.vo.CCouponVO;

/**
 * @author: sekift
 * @date: 2021/04/25 16:31
 * @description: 满减劵
 **/
public interface CCouponService {

    /**
     * 按主键删除数据
     * @param id
     * @return
     **/
    JsonRslt delete(Integer id);

    /**
     * 插入数据
     * @param cCouponVO
     * @return
     **/
    JsonRslt insert(CCouponVO cCouponVO);

    /**
     * 按主键查询一条数据
     * @param id
     * @return
     **/
    JsonRslt select(Integer id);

    /**
     * 修改数据
     * @param cCouponVO
     * @return
     **/
    JsonRslt update(CCouponVO cCouponVO);

    /**
     * 按条件查询数据
     * @param cCouponVO
     * @return
     **/
    JsonRslt search(CCouponVO cCouponVO);

}