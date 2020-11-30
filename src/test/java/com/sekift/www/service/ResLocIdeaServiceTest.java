package com.sekift.www.service;

import com.sekift.www.conf.CommonTestConf;
import com.sekift.www.service.impl.ResLocIdeaServiceImpl;
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
 * @description: TerminalLableDetailService类的测试
 */
@RunWith(SpringRunner.class)
@Import({MyBatisUtil.class, ResLocIdeaServiceImpl.class})
public class ResLocIdeaServiceTest {

    @TestConfiguration
    static class ResLocIdeaServiceTestConf extends CommonTestConf {}

    @Autowired
    private ResLocIdeaService resLocIdeaService;

    @Test
    public void selectWithDetailTest(){
        resLocIdeaService.delete(7);
    }
}