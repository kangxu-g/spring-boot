package springboot.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import springboot.Application;
import springboot.service.ITestService;

/**
 * 版    权:  ListSoft Technologies Co., Ltd. Copyright 2017,  All rights reserved
 * 描    述:  描述
 * 修 改 人:  kangxu
 * 修改时间:  2017/4/28
 * 修改内容:  修改内容
 */
// controller 层测试
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestControllerTest
{
    MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationConnect;

    //@Autowired
    //private ITestService testServiceImpl;

    @Before
    public void setUp() throws JsonProcessingException
    {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
    }

    @Test
    public void testFreeMarkerTest() throws Exception {
        String uri = "/test/freeMarkerTest";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.TEXT_HTML))
            .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        System.out.println(content);

    }


    @Test
    public void testGetTestsByMybatis() throws Exception{
        String uri = "/test/getTestsByMybatis";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.TEXT_HTML))
            .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        System.out.println(content);
    }

}
