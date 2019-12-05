package com.xiaoniu.pattern.strategy.v2;

import java.lang.annotation.*;

/**
 * 处理类型注解
 *
 * @author lhj
 * @date 2019/12/2 10:10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandleType {


    String value();
}
