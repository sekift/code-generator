package com.sekift.www.service.impl;

import com.sekift.www.dao.ResLocPosTypeMapper;
import com.sekift.www.service.ResLocPosTypeService;
import com.sekift.www.tool.CommUtils;
import com.sekift.www.tool.ErrorCodeEnum;
import com.sekift.www.tool.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class ResLocPosTypeServiceImpl implements ResLocPosTypeService {

    @Autowired
    private ResLocPosTypeMapper resLocPosTypeMapper;

    /**
     * 按主键删除数据
     * @param id
     * @return
     **/
    @Override
    public JsonRslt delete(String id){
        try {
            int rows = resLocPosTypeMapper.deleteByPrimaryKey(id);
            if (rows > 0) {
                return JsonRslt.putSuccessMessage("资源位内容表删除成功");
            }
         } catch (Exception e) {
                LogUtils.logError(CommUtils.getException(e));
         }
         return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), "资源位内容表删除失败");
    }

    /**
     * 插入数据
     * @param resLocPosTypeVO
     * @return
     **/
    @Override
    public JsonRslt insert(ResLocPosTypeVO resLocPosTypeVO){
        try {
            ResLocPosType resLocPosType = new ResLocPosType();
            CommUtils.copyProperties(resLocPosType, resLocPosTypeVO);
            int rows = resLocPosTypeMapper.insert(resLocPosType);
            if(rows > 0){
                return JsonRslt.putSuccessMessage("资源位内容表插入成功");
            }
         } catch (Exception e) {
                LogUtils.logError(CommUtils.getException(e));
         }
         return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), "资源位内容表插入失败");
    }

    /**
     * 按主键查询一条数据
     * @param id
     * @return
     **/
    @Override
    public JsonRslt select(String id){
        ResLocPosType resLocPosType = resLocPosTypeMapper.selectByPrimaryKey(id);
        if (null != resLocPosType) {
             return JsonRslt.putSuccess(resLocPosType);
         }
         return JsonRslt.putSuccessMessage("id=" + id + "的资源位内容表数据不存在");
    }

    /**
     * 修改数据
     * @param resLocPosTypeVO
     * @return
     **/
    @Override
    public JsonRslt update(ResLocPosTypeVO resLocPosTypeVO){
        try {
            ResLocPosType resLocPosType = new ResLocPosType();
            CommUtils.copyProperties(resLocPosType, resLocPosTypeVO);
            int rows = resLocPosTypeMapper.updateByPrimaryKey(resLocPosType);
            if (rows > 0) {
                return this.select(resLocPosType.getId());
            }
         } catch (Exception e) {
                LogUtils.logError(CommUtils.getException(e));
         }
         return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), "资源位内容表修改失败");
    }

    /**
     * 按条件查询数据
     * @param resLocPosTypeVO
     * @return
     **/
    @Override
    public JsonRslt search(ResLocPosTypeVO resLocPosTypeVO){
        try {
             ResLocPosTypeExample example = new ResLocPosTypeExample();
             ResLocPosTypeExample.Criteria criteria = example.createCriteria();
             List<ResLocPosType> list = resLocPosTypeMapper.selectByExample(example);
             return JsonRslt.putSuccess(list);
         } catch (Exception e) {
                LogUtils.logError(CommUtils.getException(e));
         }
         return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), "资源位内容表查询失败");
    }

}
