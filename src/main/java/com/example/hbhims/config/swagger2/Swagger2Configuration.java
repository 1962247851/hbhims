package com.example.hbhims.config.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    /**
     * api接口包扫描路径
     */
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.example.hbhims";
    public static final String VERSION = "1.1.0-SNAPSHOT";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                /*
                 * 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                 */
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("人体基本健康信息管理系统（hbhims）")
                // 设置文档的描述
                .description("人体基本健康信息管理系统API接口文档\n" +
                        "注意：所有新增接口均不需要传id，id是数据库自动生成的，即使传入也不起作用，如果想获取id的话，请留意返回的数据，新增成功后都会返回自动生成好的id对应实体的json字符串，可以自行选择是否使用。\n" +
                        "但是更新一般都是要传入id的，有些接口不用，视实际情况而定\n\n" +
                        "登录新增验证码\n" +
                        "新增医疗意见和建议模块API\n" +
                        "20200426，运动记录查询API优化\n" +
                        "20200427，睡眠质量接口优化\n" +
                        "20200430，运动记录接口优化\n" +
                        "20200501，身高、体重接口优化\n" +
                        "20200202，三血接口优化\n" +
                        "20200509，医疗意见和建议接口优化\n" +
                        "20200510，新增医疗意见和建议请求接口，并增加消息推送功能\n" +
                        "20200512，新增文件上传接口，建议请求新增健康截图字段")
                // 设置文档的版本信息-> 1.0.0 Version information
                .version(VERSION)
                // 设置文档的License信息->1.3 License information
//                .termsOfServiceUrl("http://www.baidu.com")
                .build();
    }
}