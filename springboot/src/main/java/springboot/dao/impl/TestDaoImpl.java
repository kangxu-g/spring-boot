/*
 * 文 件 名:  TestDaoImpl.java
 * 版    权:  ListSoft Technologies Co., Ltd. Copyright 2017,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  kangxu
 * 修改时间:  2017年4月26日
 * 修改内容:  <修改内容>
 */
package springboot.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import springboot.dao.ITestDao;
import springboot.domain.po.Test;

@Repository
public class TestDaoImpl implements ITestDao
{
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * 获取session
     * 
     * @return
     */
    public Session getSession()
        throws Exception
    {
        Session session;
        try
        {
            session = sessionFactory.getCurrentSession();
            if (session == null)
            {
                session = sessionFactory.openSession();
            }
        }
        catch (Exception e)
        {
            
            throw new Exception("hibernate open session error");
        }
        return session;
    }
    
    /**
     * 关闭session
     */
    public void closeSession()
        throws Exception
    {
        try
        {
            Session session = sessionFactory.getCurrentSession();
            if (session != null)
            {
                session.close();
            }
        }
        catch (Exception e)
        {
            
            throw new Exception("hibernate close session error");
        }
    }
    
    @Autowired
    @Qualifier("jdbcTemplate")
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Test> getTests()
    {
        String sql = "select id,name from test";
        
        List<Test> tests = jdbcTemplate.query(sql, new Object[]{}, BeanPropertyRowMapper.newInstance(Test.class));
        return tests;
    }

    public void save(Test test)
    {
        
        try
        {
            getSession().save(test);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
}
