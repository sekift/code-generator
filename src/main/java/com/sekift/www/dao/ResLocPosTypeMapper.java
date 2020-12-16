package com.sekift.www.dao;

import com.sekift.www.model.ResLocPosType;
import com.sekift.www.model.ResLocPosTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResLocPosTypeMapper {
    int countByExample(ResLocPosTypeExample example);

    int deleteByExample(ResLocPosTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(ResLocPosType record);

    int insertSelective(ResLocPosType record);

    List<ResLocPosType> selectByExample(ResLocPosTypeExample example);

    ResLocPosType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ResLocPosType record, @Param("example") ResLocPosTypeExample example);

    int updateByExample(@Param("record") ResLocPosType record, @Param("example") ResLocPosTypeExample example);

    int updateByPrimaryKeySelective(ResLocPosType record);

    int updateByPrimaryKey(ResLocPosType record);
}