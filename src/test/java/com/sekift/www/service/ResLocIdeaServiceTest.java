package com.sekift.www.service;

import com.sekift.www.conf.CommonTestConf;
import com.sekift.www.service.impl.TerminalTypeInfoServiceImpl;
import com.sekift.www.util.MyBatisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: yinzhang.lu
 * @date: 2020/10/29 11:17
 * @description: TerminalTypeInfoService类的测试
 */
@RunWith(SpringRunner.class)
@Import({MyBatisUtil.class, TerminalTypeInfoServiceImpl.class})
public class ResLocIdeaServiceTest {

    @TestConfiguration
    static class ResLocIdeaServiceTestConf extends CommonTestConf {}

    @Autowired
    private TerminalTypeInfoService terminalTypeInfoService;

    @Test
    public void deleteTest(){
        terminalTypeInfoService.delete(7);
    }
}