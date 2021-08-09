package com.model.common.demo;

import org.aspectj.lang.annotation.Pointcut;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TraceLogAnnotation {

    String name();

}