package com.example.demo.ques1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DrawingApp {
    public static void main(String[] args) {
        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
//        Rectangle rectangle = (Rectangle) factory.getBean("rectangleObj");
        Rectangle rectangle = (Rectangle) factory.getBean("rectangleObjUsingList");
        rectangle.draw();

//        System.out.println("Height of the rectangle is :" + rectangle.getHeight());
//        System.out.println("Width of the rectangle is :" + rectangle.getWidth());
//        System.out.println("Coordinates of the Point p1 are :" + rectangle.getP1().getX() + ", " + rectangle.getP1().getY());
//        System.out.println("Coordinates of the Point p2 are :" + rectangle.getP2().getX() + ", " + rectangle.getP2().getY());
//        System.out.println("Coordinates of the Point p3 are :" + rectangle.getP3().getX() + ", " + rectangle.getP3().getY());
//        System.out.println("Coordinates of the Point p4 are :" + rectangle.getP4().getX() + ", " + rectangle.getP4().getY());
    }
}
