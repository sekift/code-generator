package com.sekift.www.service.impl;

import com.sekift.www.dao.TerminalTypeInfoMapper;
import com.sekift.www.service.TerminalTypeInfoService;
import com.sekift.www.tool.CommUtils;
import com.sekift.www.tool.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class TerminalTypeInfoServiceImpl implements TerminalTypeInfoService {

    @Autowired
    private TerminalTypeInfoMapper terminalTypeInfoMapper;

    /**
     * 按主键删除数据
     * @param: id
     * @return
     **/
    @Override
    public JsonRslt delete(Integer id){
        try{
            int rows = terminalTypeInfoMapper.deleteByPrimaryKey(id);
            if(rows > 0){
                return JsonRslt.putSuccessMsg("终端类型标息删除成功");
            }
         }catch(Exception e){
                LogUtils.logError(CommUtils.getException(e));
         }
         return JsonRslt.putErrorCode(1,  "终端类型标息删除失败");
    }

    /**
     * 插入数据
     * @param: terminalTypeInfoVO
     * @return
     **/
    @Override
    public JsonRslt insert(TerminalTypeInfoVO terminalTypeInfoVO){
        try{
            TerminalTypeInfo terminalTypeInfo = new TerminalTypeInfo();
            CommUtils.copyProperties(terminalTypeInfo, terminalTypeInfoVO);
            int rows = terminalTypeInfoMapper.insert(terminalTypeInfo);
            if(rows > 0){
                return JsonRslt.putSuccessMsg("终端类型标息插入成功");
            }
         }catch(Exception e){
                LogUtils.logError(CommUtils.getException(e));
         }
         return JsonRslt.putErrorCode(1,  "终端类型标息插入失败");
    }

    /**
     * 按主键查询一条数据
     * @param: id
     * @return
     **/
    @Override
    public JsonRslt select(Integer id){
        TerminalTypeInfo terminalTypeInfo = terminalTypeInfoMapper.selectByPrimaryKey(id);
        if (null != terminalTypeInfo) {
             return JsonRslt.putSuccess(terminalTypeInfo);
         }
         return JsonRslt.putSuccessMsg("id=" + id + "的终端类型标息数据不存在");
    }

    /**
     * 修改数据
     * @param: terminalTypeInfoVO
     * @return
     **/
    @Override
    public JsonRslt update(TerminalTypeInfoVO terminalTypeInfoVO){
        try{
            TerminalTypeInfo terminalTypeInfo = new TerminalTypeInfo();
            CommUtils.copyProperties(terminalTypeInfo, terminalTypeInfoVO);
            int rows = terminalTypeInfoMapper.updateByPrimaryKey(terminalTypeInfo);
            if(rows > 0){
                return this.select(terminalTypeInfo.getId());
            }
         }catch(Exception e){
                LogUtils.logError(CommUtils.getException(e));
         }
         return JsonRslt.putErrorCode(1,  "终端类型标息修改失败");
    }

    /**
     * 按条件查询数据
     * @param: terminalTypeInfoVO
     * @return
     **/
    @Override
    public JsonRslt search(TerminalTypeInfoVO terminalTypeInfoVO){
        try{
             TerminalTypeInfoExample example = new TerminalTypeInfoExample();
             TerminalTypeInfoExample.Criteria criteria = example.createCriteria();
             List<TerminalTypeInfo> list = terminalTypeInfoMapper.selectByExample(example);
             return JsonRslt.putSuccess(list);
         }catch(Exception e){
                LogUtils.logError(CommUtils.getException(e));
         }
         return JsonRslt.putErrorCode(1,  "终端类型标息查询失败");
    }

}
