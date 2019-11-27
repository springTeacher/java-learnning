package com.spring.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author lhj
 * @date 2019/11/26 22:20
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if("person".equals(beanName)){
            System.err.println("MyBeanPostProcessor postProcessBeforeInitialization person.....");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if("person".equals(beanName)){
            System.err.println("MyBeanPostProcessor postProcessAfterInitialization person.....");
        }


        return bean;
    }
}
