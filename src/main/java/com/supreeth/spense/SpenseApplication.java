package com.supreeth.spense;

import com.supreeth.spense.filters.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpenseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpenseApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<AuthFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<AuthFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        AuthFilter authFilter = new AuthFilter();
        filterFilterRegistrationBean.setFilter(authFilter);
        filterFilterRegistrationBean.addUrlPatterns("/api/v1/categories/*");
        return filterFilterRegistrationBean;
    }

}
