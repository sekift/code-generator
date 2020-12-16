package com.sekift.www.controller;

import com.sekift.www.service.ResLocPosTypeService;
import com.sekift.www.tool.CommUtils;
import com.sekift.www.tool.ErrorCodeEnum;
import com.sekift.www.tool.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.sekift.www.tool.JsonRslt;
import com.sekift.www.vo.ResLocPosTypeVO;
import com.sekift.www.model.ResLocPosType;
import com.sekift.www.model.ResLocPosTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author: yinzhang.lu
 * @date: 2020/12/16 17:30
 * @description: 资源位内容表
 **/
@RestController
@RequestMapping("/api/reslocpostype")
@Api(tags = {"资源位编码内容表"})
public class ResLocPosTypeController {

    @Autowired
    private ResLocPosTypeService resLocPosTypeService;

    /**
     * 按主键删除数据
     * @param resLocPosTypeVO
     * @return
     **/
    @PostMapping("/delete")
    @ApiOperation(value = "删除资源位内容表数据(完成)",notes="传入对象的唯一键即可",httpMethod = "POST",hidden = false)
    public JsonRslt delete(@RequestBody ResLocPosTypeVO resLocPosTypeVO){
        return resLocPosTypeService.delete(resLocPosTypeVO.getId());
    }

    /**
     * 插入数据
     * @param resLocPosTypeVO
     * @return
     **/
    @PostMapping("/insert")
    @ApiOperation(value = "插入资源位内容表数据(完成)",notes="传入具体内容",httpMethod = "POST",hidden = false)
    public JsonRslt insert(@RequestBody ResLocPosTypeVO resLocPosTypeVO){
        return resLocPosTypeService.insert(resLocPosTypeVO);
    }

    /**
     * 按主键查询一条数据
     * @param resLocPosTypeVO
     * @return
     **/
    @PostMapping("/select")
    @ApiOperation(value = "按键查询资源位内容表数据(完成)",notes="传入对象的唯一键即可",httpMethod = "POST",hidden = false)
    public JsonRslt select(@RequestBody ResLocPosTypeVO resLocPosTypeVO){
        if(resLocPosTypeVO == null || resLocPosTypeVO.getId() == null){
            return JsonRslt.putErrorCode(ErrorCodeEnum.USER_ERROR_A0410.getCode(), "id不能为空");
        }
        return resLocPosTypeService.select(resLocPosTypeVO.getId());
    }

    /**
     * 修改数据
     * @param resLocPosTypeVO
     * @return
     **/
    @PostMapping("/update")
    @ApiOperation(value = "更新资源位内容表数据(完成)",notes="修改的数据与原来不改的数据需一起上传",httpMethod = "POST",hidden = false)
    public JsonRslt update(@RequestBody ResLocPosTypeVO resLocPosTypeVO){
        return resLocPosTypeService.update(resLocPosTypeVO);
    }

    /**
     * 按条件查询数据
     * @param resLocPosTypeVO
     * @return
     **/
    @PostMapping("/search")
    @ApiOperation(value = "按条件查询资源位内容表数据(完成)",notes="传入你想过滤的字段条件",httpMethod = "POST",hidden = false)
    public JsonRslt search(@RequestBody ResLocPosTypeVO resLocPosTypeVO){
        return resLocPosTypeService.search(resLocPosTypeVO);
    }

}
