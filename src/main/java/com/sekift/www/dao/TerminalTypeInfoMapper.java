package com.sekift.www.dao;

import com.sekift.www.model.TerminalTypeInfo;
import com.sekift.www.model.TerminalTypeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TerminalTypeInfoMapper {
    int countByExample(TerminalTypeInfoExample example);

    int deleteByExample(TerminalTypeInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TerminalTypeInfo record);

    int insertSelective(TerminalTypeInfo record);

    List<TerminalTypeInfo> selectByExample(TerminalTypeInfoExample example);

    TerminalTypeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TerminalTypeInfo record, @Param("example") TerminalTypeInfoExample example);

    int updateByExample(@Param("record") TerminalTypeInfo record, @Param("example") TerminalTypeInfoExample example);

    int updateByPrimaryKeySelective(TerminalTypeInfo record);

    int updateByPrimaryKey(TerminalTypeInfo record);
}