package com.sekift.www.service;

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
public interface ResLocPosTypeService {

    /**
     * 按主键删除数据
     * @param 
     * @return
     **/
    JsonRslt delete(String id);

    /**
     * 插入数据
     * @param resLocPosTypeVO
     * @return
     **/
    JsonRslt insert(ResLocPosTypeVO resLocPosTypeVO);

    /**
     * 按主键查询一条数据
     * @param 
     * @return
     **/
    JsonRslt select(String id);

    /**
     * 修改数据
     * @param resLocPosTypeVO
     * @return
     **/
    JsonRslt update(ResLocPosTypeVO resLocPosTypeVO);

    /**
     * 按条件查询数据
     * @param resLocPosTypeVO
     * @return
     **/
    JsonRslt search(ResLocPosTypeVO resLocPosTypeVO);

}
