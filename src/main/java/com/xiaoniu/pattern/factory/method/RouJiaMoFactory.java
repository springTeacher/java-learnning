package com.xiaoniu.pattern.factory.method;

/**
 * 肉夹馍工厂
 *
 * @author lihoujing
 * @date 2019/9/11 18:26
 */
public interface RouJiaMoFactory {

    /**
     * 根据类型生产肉夹馍
     * @param type
     * @return
     */
    RouJiaMo createRouJiaMo(String type);
}
