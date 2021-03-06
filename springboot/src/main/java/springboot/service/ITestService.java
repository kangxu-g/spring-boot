/*
 * 文 件 名:  ITestService.java
 * 版    权:  ListSoft Technologies Co., Ltd. Copyright 2017,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  kangxu
 * 修改时间:  2017年4月26日
 * 修改内容:  <修改内容>
 */
package springboot.service;

import java.util.List;

import springboot.domain.po.Test;

public interface ITestService
{

    List<Test> getTests();
    
    void save(Test test);

    List<Test> getTestsByMybatis();
}
