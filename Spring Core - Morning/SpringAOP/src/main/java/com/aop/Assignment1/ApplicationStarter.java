package com.aop.Assignment1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ApplicationStarter {

    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        Rectangle rect = (Rectangle) context.getBean("Rectangle");

        System.out.println("Height of the Rectangle Is: " + rect.getHeight());
        System.out.println("Width of the Rectangle Is: " + rect.getWidth());
        System.out.println("Coordinates of the Point point1 are: " + rect.getPoint1().getX_axis() + " , " + rect.getPoint1().getY_axis());
        System.out.println("Coordinates of the Point point2 are: " + rect.getPoint2().getX_axis() + " , " + rect.getPoint2().getY_axis());
        System.out.println("Coordinates of the Point point3 are: " + rect.getPoint3().getX_axis() + " , " + rect.getPoint3().getY_axis());
        System.out.println("Coordinates of the Point point4 are: " + rect.getPoint4().getX_axis() + " , " + rect.getPoint4().getY_axis());

        List<String> quadrilaterals = rect.getAllQuadrilaterals();
        System.out.println("List of All Quadrilaterals is: ");

        for (int i = 0; i < quadrilaterals.size() ; i++) {
            System.out.println(quadrilaterals.get(i));
        }
    }
}