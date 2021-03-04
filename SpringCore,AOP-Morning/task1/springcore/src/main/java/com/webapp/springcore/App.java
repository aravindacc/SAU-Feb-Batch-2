package com.webapp.springcore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) 
	{
		System.out.println("Rectangle class");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(config.class);
		Rectangle rect = ctx.getBean(Rectangle.class);
		System.out.println(rect);
		System.out.println();
		
		System.out.println("Printing items present in List:-");
		rect.printList();
		
		System.out.println();
		System.out.println("Printing items present in map:-");
		rect.printMap();
		
		System.out.println();
		System.out.println("Printing items present in set:-");
		rect.printSet();
	}
}
