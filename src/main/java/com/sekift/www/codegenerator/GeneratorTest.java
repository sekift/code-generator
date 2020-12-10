package com.sekift.www.codegenerator;

import com.sekift.www.codegenerator.service.ControllerGenerator;
import com.sekift.www.codegenerator.service.ServiceGenerator;
import com.sekift.www.codegenerator.service.ServiceImplGenerator;
import com.sekift.www.codegenerator.service.VOGenerator;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/03 11:21
 * @description: 自动代码生成运行类
 */
public class GeneratorTest {
    private String className = "res_loc_info";
    private String noteDesc = "资源位信息表";

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
