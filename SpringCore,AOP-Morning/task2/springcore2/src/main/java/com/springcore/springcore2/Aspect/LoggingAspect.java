package com.springcore.springcore2.Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect 
{

	@AfterReturning("allGetters()")
	public void LoggingAdviceGetters1() 
	{
		System.out.println("Logging Advice after returning from all the getters");
	}

	@After("allGetters()")
	public void LoggingAfter() 
	{
		System.out.println("Logging Advice after all the getters run completely");
	}
	
	@Around("execution(public * com.springcore.springcore2.Service.*.say*(..))")
	public void LoggingAround() 
	{
		System.out.println("Logging Advice around method of shape service");
	}
	
	@AfterThrowing("execution(public int com.springcore.springcore2.Service.*.throw*(..))")
	public void LoggingAdvice() 
	{
		System.out.println("Logging Advice after throwing exception");
	}
		
	@AfterReturning("allShapeServiceMethods() && allStringArgs()")
	public void LoggingAdviceGetters() 
	{
		System.out.println("Logging Advice after returning from the methods inside shapeService taking String as a parameter");
	}
	
	@Pointcut("execution(public * get*(..))")
	public void allGetters() {}
	
	@Pointcut("execution(public * set*(..))")
	public void allSetters() {}
	
	@Pointcut("within(com.springcore.springcore2.Model.*)")
	public void allModel() {}
	
	@Pointcut("within(com.springcore.springcore2.Model.Circle)")
	public void allCircle() {}
	
	@Pointcut("within(com.springcore.springcore2.Service.ShapeService)")
	public void allShapeServiceMethods() {}
	
	@Pointcut("(args(String))")
	public void allStringArgs() {}
}