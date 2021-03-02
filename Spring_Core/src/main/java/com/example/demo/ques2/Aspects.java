package com.example.demo.ques2;

import org.aspectj.lang.annotation.*;

@Aspect
public class Aspects {
    @Before("execution (public * get*())")
    public static void beforeAnnotation() {
        System.out.println("Before Annotation Called");
    }

    @After("execution (public * get*())")
    public static void afterAnnotation() {
        System.out.println("After Annotation Called");
    }

    @AfterReturning(pointcut = "execution(String getType())", returning = "type")
    public void afterReturningAnnotation(String type) {
        System.out.println("After returning Annotation. Returned type = " + type);
    }

    @AfterThrowing("args(type)")
    public void exceptionAnnotation(String type) {
        System.out.println("Exception thrown for type " + type);
    }
}
