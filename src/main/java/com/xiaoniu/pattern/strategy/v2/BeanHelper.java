package com.xiaoniu.pattern.strategy.v2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author lhj
 * @date 2019/12/2 9:53
 */
public class BeanHelper implements ApplicationContextAware {

    @Autowired
    private static ApplicationContext applicationContext;


    /**
     * 根据类型获取bean
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanHelper.applicationContext = applicationContext;
    }
}
