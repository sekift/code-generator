package com.sekift.www.controller;

import com.sekift.www.service.CCouponService;
import com.sekift.www.tool.CommUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.sekift.www.tool.JsonRslt;
import com.sekift.www.vo.CCouponVO;
import com.sekift.www.model.CCoupon;
import com.sekift.www.model.CCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author: yinzhang.lu
 * @date: 2021/04/25 16:32
 * @description: 满减劵
 **/
@RestController
@RequestMapping("/api/ccoupon")
@Api(tags = {"满减劵"})
public class CCouponController {

    @Autowired
    private CCouponService cCouponService;

    /**
     * 按主键删除数据
     * @param cCouponVO
     * @return
     **/
    @PostMapping("/delete")
    @ApiOperation(value = "删除满减劵数据(完成)",notes="传入对象的唯一键即可",httpMethod = "POST",hidden = false)
    public JsonRslt delete(@RequestBody CCouponVO cCouponVO){
        return cCouponService.delete(cCouponVO.getId());
    }

    /**
     * 插入数据
     * @param cCouponVO
     * @return
     **/
    @PostMapping("/insert")
    @ApiOperation(value = "插入满减劵数据(完成)",notes="传入具体内容",httpMethod = "POST",hidden = false)
    public JsonRslt insert(@RequestBody CCouponVO cCouponVO){
        return cCouponService.insert(cCouponVO);
    }

    /**
     * 按主键查询一条数据
     * @param cCouponVO
     * @return
     **/
    @PostMapping("/select")
    @ApiOperation(value = "按键查询满减劵数据(完成)",notes="传入对象的唯一键即可",httpMethod = "POST",hidden = false)
    public JsonRslt select(@RequestBody CCouponVO cCouponVO){
        return cCouponService.select(cCouponVO.getId());
    }

    /**
     * 修改数据
     * @param cCouponVO
     * @return
     **/
    @PostMapping("/update")
    @ApiOperation(value = "更新满减劵数据(完成)",notes="修改的数据与原来不改的数据需一起上传",httpMethod = "POST",hidden = false)
    public JsonRslt update(@RequestBody CCouponVO cCouponVO){
        return cCouponService.update(cCouponVO);
    }

    /**
     * 按条件查询数据
     * @param cCouponVO
     * @return
     **/
    @PostMapping("/search")
    @ApiOperation(value = "按条件查询满减劵数据(完成)",notes="传入你想过滤的字段条件",httpMethod = "POST",hidden = false)
    public JsonRslt search(@RequestBody CCouponVO cCouponVO){
        return cCouponService.search(cCouponVO);
    }

}