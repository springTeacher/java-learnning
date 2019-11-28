package com.spring.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lhj
 * @date 2019/11/26 20:08
 */
public class Person implements InitializingBean, DisposableBean {





    @Override
    public void destroy() throws Exception {
        System.err.println("person destroy.........");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("person InitializingBean.........");
    }



    @PostConstruct
    public void postConstruct(){
        System.err.println("person postConstruct.........");
    }

    @PreDestroy
    public void preDestroy(){
        System.err.println("person preDestroy.........");
    }


    private void initMethod(){
        System.err.println("person initMethod....");
    }

    private void destroyMethod(){
        System.err.println("person destroyMethod....");
    }




}
