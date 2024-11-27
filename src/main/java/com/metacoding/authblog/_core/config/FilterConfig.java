package com.metacoding.authblog._core.config;

import com.metacoding.authblog._core.filter.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean // 리턴값이 IOC에 등록됨
    public FilterRegistrationBean addAuthFilter(){
        FilterRegistrationBean rg = new FilterRegistrationBean();
        rg.setFilter(new AuthenticationFilter());
        rg.addUrlPatterns("/board/*");
        rg.addUrlPatterns("/user/*");
        rg.setOrder(1);
        return rg;
    }
}
