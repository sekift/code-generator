package com.sekift.www.service.impl;

import com.sekift.www.dao.ResLocIdeaMapper;
import com.sekift.www.service.ResLocIdeaService;
import com.sekift.www.tool.CommUtils;
import com.sekift.www.tool.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class ResLocIdeaServiceImpl implements ResLocIdeaService {

    @Autowired
    private ResLocIdeaMapper resLocIdeaMapper;

    /**
     * 按主键删除数据
     * @param id
     * @return
     **/
    @Override
    public JsonRslt delete(Integer id){
        try {
            int rows = resLocIdeaMapper.deleteByPrimaryKey(id);
            if (rows > 0) {
                return JsonRslt.putSuccessMsg("活动创意删除成功");
            }
         } catch (Exception e) {
                LogUtils.logError(CommUtils.getException(e));
         }
         return JsonRslt.putErrorCode(1,  "活动创意删除失败");
    }

    /**
     * 插入数据
     * @param resLocIdeaVO
     * @return
     **/
    @Override
    public JsonRslt insert(ResLocIdeaVO resLocIdeaVO){
        try {
            ResLocIdea resLocIdea = new ResLocIdea();
            CommUtils.copyProperties(resLocIdea, resLocIdeaVO);
            int rows = resLocIdeaMapper.insert(resLocIdea);
            if(rows > 0){
                return JsonRslt.putSuccessMsg("活动创意插入成功");
            }
         } catch (Exception e) {
                LogUtils.logError(CommUtils.getException(e));
         }
         return JsonRslt.putErrorCode(1,  "活动创意插入失败");
    }

    /**
     * 按主键查询一条数据
     * @param id
     * @return
     **/
    @Override
    public JsonRslt select(Integer id){
        ResLocIdea resLocIdea = resLocIdeaMapper.selectByPrimaryKey(id);
        if (null != resLocIdea) {
             return JsonRslt.putSuccess(resLocIdea);
         }
         return JsonRslt.putSuccessMsg("id=" + id + "的活动创意数据不存在");
    }

    /**
     * 修改数据
     * @param resLocIdeaVO
     * @return
     **/
    @Override
    public JsonRslt update(ResLocIdeaVO resLocIdeaVO){
        try {
            ResLocIdea resLocIdea = new ResLocIdea();
            CommUtils.copyProperties(resLocIdea, resLocIdeaVO);
            int rows = resLocIdeaMapper.updateByPrimaryKey(resLocIdea);
            if (rows > 0) {
                return this.select(resLocIdea.getId());
            }
         } catch (Exception e) {
                LogUtils.logError(CommUtils.getException(e));
         }
         return JsonRslt.putErrorCode(1,  "活动创意修改失败");
    }

    /**
     * 按条件查询数据
     * @param resLocIdeaVO
     * @return
     **/
    @Override
    public JsonRslt search(ResLocIdeaVO resLocIdeaVO){
        try {
             ResLocIdeaExample example = new ResLocIdeaExample();
             ResLocIdeaExample.Criteria criteria = example.createCriteria();
             List<ResLocIdea> list = resLocIdeaMapper.selectByExample(example);
             return JsonRslt.putSuccess(list);
         } catch (Exception e) {
                LogUtils.logError(CommUtils.getException(e));
         }
         return JsonRslt.putErrorCode(1,  "活动创意查询失败");
    }

}
