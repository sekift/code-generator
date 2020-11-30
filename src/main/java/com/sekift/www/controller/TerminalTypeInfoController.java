package com.sekift.www.controller;

import com.sekift.www.service.TerminalTypeInfoService;
import com.sekift.www.tool.CommUtils;
import com.sekift.www.tool.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.sekift.www.tool.JsonRslt;
import com.sekift.www.vo.TerminalTypeInfoVO;
import com.sekift.www.model.TerminalTypeInfo;
import com.sekift.www.model.TerminalTypeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/09 16:21
 * @description: 终端类型标息
 **/
@RestController
@RequestMapping("/api/terminaltypeinfo")
@Api(tags = {"终端类型标息"})
public class TerminalTypeInfoController {

    @Autowired
    private TerminalTypeInfoService terminalTypeInfoService;

    /**
     * 按主键删除数据
     * @param: id
     * @return
     **/
    @PostMapping("/delete")
    @ApiOperation(value = "删除终端类型标息数据(完成)",notes="传入对象的唯一键即可",httpMethod = "POST",hidden = false)
    public JsonRslt delete(@RequestBody TerminalTypeInfoVO terminalTypeInfoVO){
        return terminalTypeInfoService.delete(terminalTypeInfoVO.getId());
    }

    /**
     * 插入数据
     * @param: terminalTypeInfoVO
     * @return
     **/
    @PostMapping("/insert")
    @ApiOperation(value = "插入终端类型标息数据(完成)",notes="传入具体内容",httpMethod = "POST",hidden = false)
    public JsonRslt insert(@RequestBody TerminalTypeInfoVO terminalTypeInfoVO){
        return terminalTypeInfoService.insert(terminalTypeInfoVO);
    }

    /**
     * 按主键查询一条数据
     * @param: id
     * @return
     **/
    @PostMapping("/select")
    @ApiOperation(value = "按键查询终端类型标息数据(完成)",notes="传入对象的唯一键即可",httpMethod = "POST",hidden = false)
    public JsonRslt select(@RequestBody TerminalTypeInfoVO terminalTypeInfoVO){
        return terminalTypeInfoService.select(terminalTypeInfoVO.getId());
    }

    /**
     * 修改数据
     * @param: terminalTypeInfoVO
     * @return
     **/
    @PostMapping("/update")
    @ApiOperation(value = "更新终端类型标息数据(完成)",notes="修改的数据与原来不改的数据需一起上传",httpMethod = "POST",hidden = false)
    public JsonRslt update(@RequestBody TerminalTypeInfoVO terminalTypeInfoVO){
        return terminalTypeInfoService.update(terminalTypeInfoVO);
    }

    /**
     * 按条件查询数据
     * @param: terminalTypeInfoVO
     * @return
     **/
    @PostMapping("/search")
    @ApiOperation(value = "按条件查询终端类型标息数据(完成)",notes="传入你想过滤的字段条件",httpMethod = "POST",hidden = false)
    public JsonRslt search(@RequestBody TerminalTypeInfoVO terminalTypeInfoVO){
        return terminalTypeInfoService.search(terminalTypeInfoVO);
    }

}
