package com.yffd.jecap.admin.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
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
 * 1.验证Springfox是否正常工作
 *  http://localhost:8080/v2/api-docs
 *  结果是带有大量键值对的JSON响应
 * 2.swagger ui地址
 *  http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
@ConditionalOnExpression("${swagger.enable:true}")
public class Swagger2Config {

    @Value("${swagger2.enable:false}")
    private boolean enable = true;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("jecap-admin")
                .description("admin测试 | TIPS技术团队")
                .version("v1.1.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("模块-admin")
                .apiInfo(apiInfo())
                .enable(enable)//是否开启
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yffd.jecap.admin.interfaces.controller"))
                .paths(PathSelectors.any()) // and by paths
                .build()
                .useDefaultResponseMessages(false);
    }

}
