/*
 * 文 件 名:  TestServiceImpl.java
 * 版    权:  ListSoft Technologies Co., Ltd. Copyright 2017,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  kangxu
 * 修改时间:  2017年4月26日
 * 修改内容:  <修改内容>
 */
package springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import springboot.dao.ITestDao;
import springboot.dao.mapper.TestMapper;
import springboot.domain.po.Test;
import springboot.service.ITestService;

@Service
public class TestServiceImpl implements ITestService
{
    @Autowired
    @Qualifier("testDaoImpl")
    private ITestDao testDaoImpl;

    @Autowired
    private TestMapper testMapper;

    public List<Test> getTests()
    {
        
        return testDaoImpl.getTests();
    }

    @Transactional(value="txManager",isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public void save(Test test)
    {
        
        testDaoImpl.save(test);
    }

    public List<Test> getTestsByMybatis(){
        return testMapper.getTests();
    }

}
