package com.spring.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

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





    private void initMethod(){
        System.err.println("person initMethod....");
    }

    private void destroyMethod(){
        System.err.println("person destroyMethod....");
    }




}
