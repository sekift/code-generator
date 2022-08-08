package com.sekift.www.codegenerator;

import com.sekift.www.codegenerator.service.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sekift
 * @date 2020/11/03 11:21
 * @description 自动代码生成运行类
 */
public class GeneratorCodeOneTest {
    /** 填写表的名字*/
    private final String className = "admin";
    /** 填写表的注释*/
    private final String noteDesc = "测试";

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
