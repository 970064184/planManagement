package com.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.filter.MyFilter;

@Configuration
//@Component
public class MyConfig {

	@Bean
	public FilterRegistrationBean<MyFilter> testFilterRegistration() {
		FilterRegistrationBean<MyFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(new MyFilter());// 添加过滤器
		registration.addUrlPatterns("/*");// 设置过滤路径，/*所有路径
		//registration.addInitParameter("name", "alue");// 添加默认参数
		registration.setName("MyFilter");// 设置优先级
		registration.setOrder(1);// 设置优先级
		return registration;
	}

}
