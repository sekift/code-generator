package com.sekift.www.service;

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
public interface TerminalTypeInfoService {

    /**
     * 按主键删除数据
     * @param: 
     * @return
     **/
    JsonRslt delete(Integer id);

    /**
     * 插入数据
     * @param: terminalTypeInfoVO
     * @return
     **/
    JsonRslt insert(TerminalTypeInfoVO terminalTypeInfoVO);

    /**
     * 按主键查询一条数据
     * @param: 
     * @return
     **/
    JsonRslt select(Integer id);

    /**
     * 修改数据
     * @param: terminalTypeInfoVO
     * @return
     **/
    JsonRslt update(TerminalTypeInfoVO terminalTypeInfoVO);

    /**
     * 按条件查询数据
     * @param: terminalTypeInfoVO
     * @return
     **/
    JsonRslt search(TerminalTypeInfoVO terminalTypeInfoVO);

}
