package com.dsns.config;

import com.dsns.security.BaseInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.MappedInterceptor;

/**
 * Created by mtustanovskyy on 11/14/16.
 */
@Configuration
@EnableWebMvc
@Slf4j
@Import(RepositoryRestMvcConfiguration.class)
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "HEAD", "PUT", "DELETE", "OPTIONS").allowedHeaders("*");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("add interceptor: /api/**");
        registry.addInterceptor(new BaseInterceptor()).addPathPatterns("/api/**");
    }


    @Bean
    public MappedInterceptor myMappedInterceptor() {
        return new MappedInterceptor(new String[]{"/api/**"}, new BaseInterceptor());
    }

}