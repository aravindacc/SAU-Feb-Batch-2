package org.example.assignment1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Reactangle rect = (Reactangle) context.getBean("rect");
        System.out.println("Height of the rectangle is :" + rect.getHeight());
        System.out.println("Width of the rectangle is :" + rect.getWidth());
        System.out.println("Coordinates of the Point p1 are :" + rect.getP1().getX() + ", " + rect.getP1().getY());
        System.out.println("Coordinates of the Point p2 are :" + rect.getP2().getX() + ", " + rect.getP2().getY());
        System.out.println("Coordinates of the Point p3 are :" + rect.getP3().getX() + ", " + rect.getP3().getY());
        System.out.println("Coordinates of the Point p4 are :" + rect.getP4().getX() + ", " + rect.getP4().getY());

        List<String>quadilaterals = rect.getQuadilaterals();
        System.out.println("List of quadilaterals : ");
        for (int i = 0; i<quadilaterals.size(); i++) {
            System.out.println(quadilaterals.get(i) + " ");
        }

    }
}
