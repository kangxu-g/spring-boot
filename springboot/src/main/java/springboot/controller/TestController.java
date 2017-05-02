/*
 * 文 件 名:  TestController.java
 * 版    权:  ListSoft Technologies Co., Ltd. Copyright 2017,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  kangxu
 * 修改时间:  2017年4月26日
 * 修改内容:  <修改内容>
 */
package springboot.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.*;

import springboot.domain.po.Test;
import springboot.service.ITestService;

@Controller
@Api(value = "测试",description = "测试swagger bootstrap ui 文档生成")
@RequestMapping(value={"/test"})
public class TestController
{

    @Autowired
    @Qualifier("testServiceImpl")
    private ITestService testServiceImpl;

    @Autowired
    private Configuration configuration; //freeMarker configuration

    @RequestMapping(value={"hello-world"},method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET",value = "测试HelloWorld")
    @ResponseBody
    public String helloWorld(){
        return "Hello World!!!";
    }

    @RequestMapping(value={"getTests"},method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET",value = "getTests")
    @ResponseBody
    public String getTests(){

        return JSON.toJSON(testServiceImpl.getTests()).toString();
    }

    @RequestMapping(value={"save"},method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST",value = "save")
    @ResponseBody
    public String save(@ModelAttribute Test test){
        testServiceImpl.save(test);
        return "dfdf";
    }

    @RequestMapping(value={"/testJsp"},method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET",value = "jsp")
    public String jsp(){
        return "jsp";
    }

    /*freeMarker模板测试*/
    @RequestMapping(value={"freeMarkerTest"},method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    @ApiOperation(httpMethod = "GET",value = "freeMarkerTest")
    @ResponseBody
    public String freeMarkerTest(){
        Map<String, Object> model = null;
        String content = null;

        try
        {
            model = new HashMap<String, Object>();
            model.put("time", new Date());
            model.put("message", "这是测试的内容。。。");
            model.put("toUserName", "张三");
            model.put("fromUserName", "老许");

            Template t = configuration.getTemplate("freemarker/test.ftl");
            content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (TemplateException e)
        {
            e.printStackTrace();
        }

        return content;
    }


    @RequestMapping(value={"getTestsByMybatis"},method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET",value = "getTestsByMybatis")
    @ResponseBody
    public String getTestsByMybatis(){

        return JSON.toJSON(testServiceImpl.getTestsByMybatis()).toString();
    }

}
