package org.oversky.gurms.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")	//设置允许跨域的路径
                          .allowedOrigins("*")  //设置允许跨域请求的域名
                          .allowCredentials(true)	//是否允许证书 不再默认开启
                          .allowedMethods("*")	//设置允许的方法"GET", "POST", "DELETE", "PUT","PATCH"
                          .maxAge(3600);  //跨域允许时间
            }
        };
    }
}
