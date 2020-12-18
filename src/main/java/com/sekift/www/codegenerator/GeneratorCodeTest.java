package com.sekift.www.codegenerator;

import com.sekift.www.codegenerator.service.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/03 11:21
 * @description: 自动代码生成运行类
 */
public class GeneratorCodeTest {
    // 填写表的名字
    private String className = "res_loc_pos_type";
    // 填写表的注释
    private String noteDesc = "资源位内容表";

    @Before
    public void setUp() {
        new GeneratorConfig(className, noteDesc);
    }

    @Test
    public void generatorAll() {
        VOGenerator.generateVO();
        ServiceGenerator.generateService();
        ServiceImplGenerator.generateServiceImpl();
        ControllerGenerator.generateController();
    }


}