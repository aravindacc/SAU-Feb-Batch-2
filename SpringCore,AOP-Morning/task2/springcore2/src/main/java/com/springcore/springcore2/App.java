package com.springcore.springcore2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.springcore.springcore2.Model.Circle;
import com.springcore.springcore2.Model.Triangle;
import com.springcore.springcore2.Service.ShapeService;

/**
 * Hello world!
 *
 */
public class App {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		System.out.println("Hello World!");
		ctx = new FileSystemXmlApplicationContext("springcode.xml");

		ShapeService shapeService = ctx.getBean("shapeservice", ShapeService.class);
		Circle circle = ctx.getBean("circle", Circle.class);
		Triangle triangle = ctx.getBean("triangle", Triangle.class);

		System.out.println("************************calling shapeservice class************************");
		System.out.println(shapeService.getCircle().getName());
		System.out.println(shapeService.getTriangle().getName());
		
		
		System.out.println("************************calling shapeservice getters************************");
		try {
			System.out.println(shapeService.throwException());
			}
		catch (Exception e){}
		
		//System.out.println(shapeService.sayGreetings("hey user"));
		
		System.out.println("*****************************calling circle********************************");
		System.out.println(circle.getInfo());
		System.out.println(circle.getName());
		
		System.out.println("*****************************calling triangle getters*****************************");
		System.out.println(triangle.getName());
	}
}
