package com.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhj
 * @date 2019/12/16 18:34
 */
@Configuration
public class FilterConfiguration {


    @Bean
    public FilterRegistrationBean<ConfigTimeFilter> registrationBean(){

        FilterRegistrationBean<ConfigTimeFilter> registrationBean = new FilterRegistrationBean<>();
        ConfigTimeFilter configTimeFilter = new ConfigTimeFilter();
        registrationBean.setFilter(configTimeFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }
}
