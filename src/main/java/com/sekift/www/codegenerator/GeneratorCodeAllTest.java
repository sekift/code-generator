package com.sekift.www.codegenerator;

import com.sekift.www.codegenerator.service.ControllerGenerator;
import com.sekift.www.codegenerator.service.ServiceGenerator;
import com.sekift.www.codegenerator.service.ServiceImplGenerator;
import com.sekift.www.codegenerator.service.VOGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/03 11:21
 * @description: 自动代码生成运行类
 */
public class GeneratorCodeAllTest {

    private List<Map<String, String>> tableMeta;

    @Before
    public void setUp() {
        tableMeta = JDBCOperator.printTableNames();
    }

    @Test
    public void generatorAll() {
        for(Map<String, String> map : tableMeta){
            new GeneratorConfig(map.get("tableName"), map.get("remark"));

            new VOGenerator().generateVO();
            new ServiceGenerator().generateService();
            new ServiceImplGenerator().generateServiceImpl();
            new ControllerGenerator().generateController();
        }
    }


}
