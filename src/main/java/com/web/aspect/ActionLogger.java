package com.web.aspect;

import java.lang.annotation.*;

/**
 * 模块日志
 *
 * @author lihoujing
 * @date 2019/10/21 21:11
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ActionLogger {

    /**
     * 模块名称
     *
     * @return
     */
    String moduleName() default "";

    /**
     * 操作类型
     *
     * @return
     */
    String actionType() default "";
}
