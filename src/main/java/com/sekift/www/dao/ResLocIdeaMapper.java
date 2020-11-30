package com.sekift.www.dao;

import com.sekift.www.model.ResLocIdea;
import com.sekift.www.model.ResLocIdeaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResLocIdeaMapper {
    int countByExample(ResLocIdeaExample example);

    int deleteByExample(ResLocIdeaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResLocIdea record);

    int insertSelective(ResLocIdea record);

    List<ResLocIdea> selectByExample(ResLocIdeaExample example);

    ResLocIdea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResLocIdea record, @Param("example") ResLocIdeaExample example);

    int updateByExample(@Param("record") ResLocIdea record, @Param("example") ResLocIdeaExample example);

    int updateByPrimaryKeySelective(ResLocIdea record);

    int updateByPrimaryKey(ResLocIdea record);
}