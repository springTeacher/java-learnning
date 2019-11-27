package com.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author lihoujing
 * @date 2019/10/21 21:14
 */
@Aspect
@Component
public class WebOperationLogAspect {

    @Autowired
    private HttpServletRequest request;




    @Pointcut("execution(public * com.web.controller.*.*(..))")
    public void pointCut(){

    }


    @Around("pointCut()")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {

        return joinPoint.proceed();
    }



}
