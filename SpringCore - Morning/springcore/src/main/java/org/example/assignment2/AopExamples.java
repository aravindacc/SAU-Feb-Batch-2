package org.example.assignment2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import java.io.StringReader;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AopExamples {

    // We want to call this method before the getName method of student class is called
    // Using the execution pointcut

    @Before("customPointcut()")
    public static void beforeannotation() {
        System.out.println("Using before execute pointcut annotation");
    }

    @After("customPointcut()")
    public static void afterannotation() {
        System.out.println("Using After execute pointcut annotation");
    }

    @Pointcut("execution (public void getName())")
    public void customPointcut() {

    }

    @AfterReturning(pointcut = "execution(int getRollnumber())", returning = "roll")
    public void afterreturningannotation(int roll) {
        System.out.println("After returning annotation. Returned roll number = " + roll);
    }

    @AfterThrowing("args(course)")
    public void exceptionAdviceAnnotation(String course) {
        System.out.println("Exception is thrown. Course obtained before throwing exception = " + course);
    }


    @Around("execution (int getPercentage(int,int))")
    public Object aroundAdvices(ProceedingJoinPoint pt) {
        Object result = null;
        try{
            result = pt.proceed();
            System.out.println("Actual Percentage Before Around Advice = " + result);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println(result);
        result = 98;
        System.out.println("Returned overridden percentage after around advice = " + result);
        return result;
    }
    @Pointcut("within(org.example.assignment2.Organization)")
    public void withinpointcut() {
        System.out.println("Within pointcut applied to all methods inside Organization class");
    }

}
