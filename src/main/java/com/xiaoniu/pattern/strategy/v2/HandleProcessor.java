package com.xiaoniu.pattern.strategy.v2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lhj
 * @date 2019/12/2 10:18
 */
@Component
public class HandleProcessor implements BeanFactoryPostProcessor {

    private static final String SCAN_PACKAGE = "com.xiaoniu.pattern.strategy.v2.handle";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        Map<String,Class<?>> handleMap = new HashMap<>(16);





        //初始化handleContext，注册到spring容器中
        HandleContext handleContext = new HandleContext(handleMap);
        beanFactory.registerSingleton(HandleContext.class.getName(), handleContext);
    }
}
