package com.example.demo.ques2;

import com.example.demo.ques2.models.Quadrilateral;
import com.example.demo.ques2.models.Triangle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Triangle triangle = context.getBean("triangle", Triangle.class);
        System.out.println("Triangle of type " + triangle.getType());
        double area_of_triangle = triangle.getArea();
        System.out.println("Area of triangle " + area_of_triangle);

        Quadrilateral quadrilateral = context.getBean("quadrilateral", Quadrilateral.class);
        System.out.println("Quadrilateral of type " + quadrilateral.getType());
        int area_of_quadrilateral = quadrilateral.getArea();
        System.out.println("Area of Quadrilateral " + area_of_quadrilateral);
    }
}
