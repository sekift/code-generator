package com.sekift.www.codegenerator;

import com.sekift.www.codegenerator.service.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/03 11:21
 * @description: 自动代码生成运行类
 */
public class GeneratorCodeOneTest {
    /** 填写表的名字*/
    private String className = "sys_part_role";
    /** 填写表的注释*/
    private String noteDesc = "运营系统部门角色表";

    @Before
    public void setUp() {
        new GeneratorConfig(className, noteDesc);
    }

    @Test
    public void generatorOne() {
        new VOGenerator().generateVO();
        new ServiceGenerator().generateService();
        new ServiceImplGenerator().generateServiceImpl();
        new ControllerGenerator().generateController();
    }


}
