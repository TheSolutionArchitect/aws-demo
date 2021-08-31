package com.awstechguide.cms.s3fileuploader;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.awstechguide.cms.s3fileuploader.config.ClientInterceptor;

import feign.RequestInterceptor;

//@EnableOAuth2Sso
@SpringBootApplication
public class S3fileuploaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3fileuploaderApplication.class, args);
	}
	
	/*
	 * @Bean public RequestInterceptor getClientInterceptor() { return new
	 * ClientInterceptor(); }
	 * 
	 * @Bean public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); CorsConfiguration config = new
	 * CorsConfiguration(); config.setAllowCredentials(true);
	 * config.setAllowedOrigins(Collections.singletonList("*"));
	 * config.setAllowedMethods(Collections.singletonList("*"));
	 * config.setAllowedHeaders(Collections.singletonList("*"));
	 * source.registerCorsConfiguration("/**", config);
	 * FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new
	 * CorsFilter(source)); bean.setOrder(Ordered.HIGHEST_PRECEDENCE); return bean;
	 * }
	 */

}
