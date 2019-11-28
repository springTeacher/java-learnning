package com.spring.configuration;

import com.spring.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lhj
 * @date 2019/11/26 20:06
 */
@ComponentScan("com.spring")
@Configuration
public class AppConfig1 {




    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Person person(){
        return new Person();
    }




}
