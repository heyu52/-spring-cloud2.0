package com.cnblogs.demo.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean
    public FilterRegistrationBean testFilterARegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new FilterA());
        registration.addUrlPatterns("/*");
        registration.setName("FilterA");
        registration.setOrder(1);
        return registration;
    }
}
