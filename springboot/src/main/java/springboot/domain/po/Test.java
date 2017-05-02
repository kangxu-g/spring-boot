/*
 * 文 件 名:  Test.java
 * 版    权:  ListSoft Technologies Co., Ltd. Copyright 2017,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  kangxu
 * 修改时间:  2017年4月26日
 * 修改内容:  <修改内容>
 */
package springboot.domain.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity  
@Table(name="TEST")
public class Test implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3359415082204464786L;
    
    @Id
    @GenericGenerator(name="ID",strategy="uuid")
    @GeneratedValue(generator="ID")
    @Column(name = "ID")
    private String id;
    
    @Column(name="NAME")
    private String name;
    
    public String getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Test(String id, String name)
    {
        super();
        this.id = id;
        this.name = name;
    }
    
    public Test()
    {
        super();
    }
    
    @Override
    public String toString()
    {
        return "Test [id=" + id + ", name=" + name + "]";
    }
    
}
