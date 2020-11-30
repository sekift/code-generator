package com.sekift.www.controller;

import com.sekift.www.service.ResLocIdeaService;
import com.sekift.www.tool.CommUtils;
import com.sekift.www.tool.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.sekift.www.tool.JsonRslt;
import com.sekift.www.vo.ResLocIdeaVO;
import com.sekift.www.model.ResLocIdea;
import com.sekift.www.model.ResLocIdeaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/30 14:49
 * @description: 活动创意
 **/
@RestController
@RequestMapping("/api/reslocidea")
@Api(tags = {"活动创意"})
public class ResLocIdeaController {

    @Autowired
    private ResLocIdeaService resLocIdeaService;

    /**
     * 按主键删除数据
     * @param resLocIdeaVO
     * @return
     **/
    @PostMapping("/delete")
    @ApiOperation(value = "删除活动创意数据(完成)",notes="传入对象的唯一键即可",httpMethod = "POST",hidden = false)
    public JsonRslt delete(@RequestBody ResLocIdeaVO resLocIdeaVO){
        return resLocIdeaService.delete(resLocIdeaVO.getId());
    }

    /**
     * 插入数据
     * @param resLocIdeaVO
     * @return
     **/
    @PostMapping("/insert")
    @ApiOperation(value = "插入活动创意数据(完成)",notes="传入具体内容",httpMethod = "POST",hidden = false)
    public JsonRslt insert(@RequestBody ResLocIdeaVO resLocIdeaVO){
        return resLocIdeaService.insert(resLocIdeaVO);
    }

    /**
     * 按主键查询一条数据
     * @param resLocIdeaVO
     * @return
     **/
    @PostMapping("/select")
    @ApiOperation(value = "按键查询活动创意数据(完成)",notes="传入对象的唯一键即可",httpMethod = "POST",hidden = false)
    public JsonRslt select(@RequestBody ResLocIdeaVO resLocIdeaVO){
        return resLocIdeaService.select(resLocIdeaVO.getId());
    }

    /**
     * 修改数据
     * @param resLocIdeaVO
     * @return
     **/
    @PostMapping("/update")
    @ApiOperation(value = "更新活动创意数据(完成)",notes="修改的数据与原来不改的数据需一起上传",httpMethod = "POST",hidden = false)
    public JsonRslt update(@RequestBody ResLocIdeaVO resLocIdeaVO){
        return resLocIdeaService.update(resLocIdeaVO);
    }

    /**
     * 按条件查询数据
     * @param resLocIdeaVO
     * @return
     **/
    @PostMapping("/search")
    @ApiOperation(value = "按条件查询活动创意数据(完成)",notes="传入你想过滤的字段条件",httpMethod = "POST",hidden = false)
    public JsonRslt search(@RequestBody ResLocIdeaVO resLocIdeaVO){
        return resLocIdeaService.search(resLocIdeaVO);
    }

}
