/*
 * 文 件 名:  Application.java
 * 版    权:  ListSoft Technologies Co., Ltd. Copyright 2017,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  kangxu
 * 修改时间:  2017年4月26日
 * 修改内容:  <修改内容>
 */
package springboot;

    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
    import org.springframework.boot.builder.SpringApplicationBuilder;
    import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
    import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
    import org.springframework.boot.context.embedded.ErrorPage;
    import org.springframework.boot.context.web.SpringBootServletInitializer;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.ComponentScan;

    import org.springframework.http.HttpStatus;
    import springboot.config.WebConfig;

@EnableAutoConfiguration
@ComponentScan
public class Application extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        System.out.println("---------------Application 启动了-----------------");
        return application.sources(this.getClass());
    }

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
