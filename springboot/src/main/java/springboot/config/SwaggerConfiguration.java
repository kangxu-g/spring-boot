package springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 版    权:  ListSoft Technologies Co., Ltd. Copyright 2017,  All rights reserved
 * 描    述:  描述
 * 修 改 人:  kangxu
 * 修改时间:  2017/5/2
 * 修改内容:  修改内容
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    public SwaggerConfiguration(){
        System.out.println("==================================SwaggerConfiguration 配置开始生效了==================================");
    }
    /*调用方式  http://localhost:8021/doc.html */

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("springboot.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("swagger-bootstrap-ui RESTful APIs")
            .description("swagger-bootstrap-ui")
            .termsOfServiceUrl("http://api.test.com/")
            .contact("developer@mail.com")
            .version("1.0")
            .build();

    }
}