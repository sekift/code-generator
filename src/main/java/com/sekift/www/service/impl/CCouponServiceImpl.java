package com.sekift.www.service.impl;

import com.sekift.www.dao.CCouponMapper;
import com.sekift.www.model.CCoupon;
import com.sekift.www.model.CCouponExample;
import com.sekift.www.service.CCouponService;
import com.sekift.www.tool.CommUtils;
import com.sekift.www.tool.ErrorCodeEnum;
import com.sekift.www.tool.JsonRslt;
import com.sekift.www.vo.CCouponVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: sekift
 * @date: 2021/04/25 16:31
 * @description: 满减劵
 **/
@Slf4j
@Service
public class CCouponServiceImpl implements CCouponService {

    @Autowired
    private CCouponMapper cCouponMapper;

    /**
     * 按主键删除数据
     * @param id
     * @return
     **/
    @Override
    public JsonRslt delete(Integer id){
        try {
            int rows = cCouponMapper.deleteByPrimaryKey(id);
            if (rows > 0) {
                return JsonRslt.putSuccessMessage("满减劵删除成功");
            }
        } catch (Exception e) {
            log.error(CommUtils.getException(e));
        }
        return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), "满减劵删除失败");
    }

    /**
     * 插入数据
     * @param cCouponVO
     * @return
     **/
    @Override
    public JsonRslt insert(CCouponVO cCouponVO){
        try {
            CCoupon cCoupon = new CCoupon();
            CommUtils.copyProperties(cCoupon, cCouponVO);
            int rows = cCouponMapper.insert(cCoupon);
            if(rows > 0){
                return JsonRslt.putSuccessMessage("满减劵插入成功");
            }
        } catch (Exception e) {
            log.error(CommUtils.getException(e));
        }
        return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), "满减劵插入失败");
    }

    /**
     * 按主键查询一条数据
     * @param id
     * @return
     **/
    @Override
    public JsonRslt select(Integer id){
        CCoupon cCoupon = cCouponMapper.selectByPrimaryKey(id);
        if (null != cCoupon) {
             return JsonRslt.putSuccess(cCoupon);
         }
         return JsonRslt.putSuccessMessage("id=" + id + "的满减劵数据不存在");
    }

    /**
     * 修改数据
     * @param cCouponVO
     * @return
     **/
    @Override
    public JsonRslt update(CCouponVO cCouponVO){
        try {
            CCoupon cCoupon = new CCoupon();
            CommUtils.copyProperties(cCoupon, cCouponVO);
            int rows = cCouponMapper.updateByPrimaryKey(cCoupon);
            if (rows > 0) {
                return this.select(cCoupon.getId());
            }
        } catch (Exception e) {
            log.error(CommUtils.getException(e));
        }
        return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), "满减劵修改失败");
    }

    /**
     * 按条件查询数据
     * @param cCouponVO
     * @return
     **/
    @Override
    public JsonRslt search(CCouponVO cCouponVO){
        try {
             CCouponExample example = new CCouponExample();
             CCouponExample.Criteria criteria = example.createCriteria();
             List<CCoupon> list = cCouponMapper.selectByExample(example);
             return JsonRslt.putSuccess(list);
        } catch (Exception e) {
            log.error(CommUtils.getException(e));
        }
        return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), "满减劵查询失败");
    }

}