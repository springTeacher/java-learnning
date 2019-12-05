package com.xiaoniu.pattern.strategy.v2;

import java.util.Map;

/**
 * 处理上下文
 *
 * @author lhj
 * @date 2019/12/2 9:42
 */
public class HandleContext {



    private Map<String, Class<?>> handleMap;


    public HandleContext(Map<String, Class<?>> handleMap) {
        this.handleMap = handleMap;
    }


    /**
     * 根据不同的类型，获取不同的处理类
     *
     * @param type
     * @return
     */
    public AbstractHandle getInstance(String type){
        Class clazz = handleMap.get(type);
        if(clazz == null){
            throw new IllegalArgumentException("类不能为空");
        }
        return (AbstractHandle) BeanHelper.getBean(clazz);
    }



}
