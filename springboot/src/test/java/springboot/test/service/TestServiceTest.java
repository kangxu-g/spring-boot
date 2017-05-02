package springboot.test.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import springboot.Application;
import springboot.domain.po.Test;
import springboot.service.ITestService;

import java.util.List;

/**
 * 版    权:  ListSoft Technologies Co., Ltd. Copyright 2017,  All rights reserved
 * 描    述:  描述
 * 修 改 人:  kangxu
 * 修改时间:  2017/4/28
 * 修改内容:  修改内容
 */
// service 层测试
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestServiceTest
{
    @Autowired
    private ITestService testServiceImpl;

    @org.junit.Test
    public void testGetTests(){
        List<Test> tests = testServiceImpl.getTests();
        System.out.println(tests);
    }

}
