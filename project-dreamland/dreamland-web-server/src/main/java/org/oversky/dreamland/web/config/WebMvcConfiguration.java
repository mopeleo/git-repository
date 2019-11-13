package org.oversky.dreamland.web.config;

import org.oversky.dreamland.web.filter.JwtAuthTokenInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Filter 统一配置管理
 * 可以通过 @WebFilter 注解来配置，但使用 @Order 指定顺序时无效
 * 在spring boot中使用Filter和HandlerIntercepter中对于相同路径匹配写法有差别,
 * 如路径/api/v1/service1,在Filter中可以使用/api/*,但在HandlerIntercepter注册时需要写成/api/** 
 * @author Blue
 *
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);   
	    config.addAllowedOrigin("http://127.0.0.1:8088");
	    config.addAllowedOrigin("http://localhost:8088");
	    config.addAllowedOrigin("http://127.0.0.1:7777");
	    config.addAllowedOrigin("http://localhost:7777");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config); // CORS 配置对所有接口都有效
	    
	    FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
	    bean.setOrder(0);
	    return bean;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(authInterceptor()).addPathPatterns("/**")
			.excludePathPatterns("/login")
			.excludePathPatterns("/logout")
			.excludePathPatterns("/validcode");
	}
	
	@Bean
	public JwtAuthTokenInterceptor authInterceptor() {
		return new JwtAuthTokenInterceptor();
	}
	
}
