package com.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

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
    public void before(ProceedingJoinPoint joinPoint){

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method method = signature.getMethod();

        ActionLogger annotation = method.getAnnotation(ActionLogger.class);
        if(annotation != null){
            String moduleName = annotation.moduleName();
            String actionType = annotation.actionType();
        }



    }



}
