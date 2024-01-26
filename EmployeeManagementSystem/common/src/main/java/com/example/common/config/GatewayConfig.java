//package com.example.common.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//@ComponentScan(basePackages = {"com.example"})
//public class GatewayConfig {
//
//    @Bean
//    public RouteLocator customRouteLocater(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route("employees", r -> r.path("/employees/**").uri("http://localhost:8081"))
//                .route("attendances", r -> r.path("/attendances/**").uri("http://localhost:8082"))
//                .route("salary", r -> r.path("/salary/**").uri("http://localhost:8083"))
//                .route("calculations", r -> r.path("/calculations/**").uri("http://localhost:8084"))
//                .build();
//    }
//
//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.data.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//}
