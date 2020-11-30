package com.sekift.www.service;

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
public interface ResLocIdeaService {

    /**
     * 按主键删除数据
     * @param 
     * @return
     **/
    JsonRslt delete(Integer id);

    /**
     * 插入数据
     * @param resLocIdeaVO
     * @return
     **/
    JsonRslt insert(ResLocIdeaVO resLocIdeaVO);

    /**
     * 按主键查询一条数据
     * @param 
     * @return
     **/
    JsonRslt select(Integer id);

    /**
     * 修改数据
     * @param resLocIdeaVO
     * @return
     **/
    JsonRslt update(ResLocIdeaVO resLocIdeaVO);

    /**
     * 按条件查询数据
     * @param resLocIdeaVO
     * @return
     **/
    JsonRslt search(ResLocIdeaVO resLocIdeaVO);

}
