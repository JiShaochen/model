package com.model.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Morning JS
 * @date 2021/4/15 18:43
 * @desc 请求Aop
 */
@Aspect
@Component
public class RequestAop {

    @Around("execution (* com.model.controller..*.*(..))")
    public Object beforeCheckToken(ProceedingJoinPoint pro) throws Throwable {


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //方法执行完成后执行的方法
        Object proceed = pro.proceed();
        return proceed;
    }

}