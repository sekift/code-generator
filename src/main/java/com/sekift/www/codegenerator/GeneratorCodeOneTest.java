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
    private String className = "c_debt_info";
    /** 填写表的注释*/
    private String noteDesc = "债务/债权人表";

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
