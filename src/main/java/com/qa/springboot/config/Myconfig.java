package com.qa.springboot.config;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.druid.pool.DruidDataSource;



@Configuration
public class Myconfig {
	@Bean//将组件注册在容器
	public WebMvcConfigurer webMvcConfigurer(){
		WebMvcConfigurer configurer = new WebMvcConfigurer(){

			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/img/**").addResourceLocations("file:E:/头像/");
			}
			
		};
		
		return configurer;
	}

	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource data(){
		return new DruidDataSource();
	}
	
	private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 允许任何域名使用
        corsConfiguration.addAllowedHeader("*"); // 允许任何头
        corsConfiguration.addAllowedMethod("*"); // 允许任何方法（post、get等）
        return corsConfiguration;
}

@Bean
public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", buildConfig()); // 对接口配置跨域设置
    return new CorsFilter(source);
}

}
