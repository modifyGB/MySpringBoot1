/*
* @Description: swagger配置类
* @Version: 1.0
* @Autor: Renhetian
* @Date: 2021-12-16 15:12:58
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-16 22:21:22
*/
package springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    public static final String SWAGGER_SCAN_BASE_PACKAGE = "springboot";

    public static final String VERSION = "1.0.0";
    
    @Bean //配置docket以配置Swagger具体参数
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("MySpringBoot")   //设置文档的标题
                .description("MySpringBoot API 接口文档")   // 设置文档的描述
                .version(VERSION)   // 设置文档的版本
                .contact(new Contact("rht", "https://github.com/modifyGB", "2782299413@qq.com"))
                .termsOfServiceUrl("")   // 配置服务网站，
                .build();
    }
}