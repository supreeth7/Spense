package com.supreeth.spense;

import com.supreeth.spense.filters.AuthFilter;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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
        filterFilterRegistrationBean.addUrlPatterns("/api/v1/transactions/*");
        return filterFilterRegistrationBean;
    }

}
