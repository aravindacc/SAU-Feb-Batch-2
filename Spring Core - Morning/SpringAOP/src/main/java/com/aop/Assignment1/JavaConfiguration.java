package com.aop.Assignment1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class JavaConfiguration {
    @Bean(name="Point 1")
    public Point getPointP1() {
        return new Point(1,6);
    }

    @Bean(name="Point 2")
    public Point getPointP2() {
        return new Point(11,6);
    }

    @Bean(name="Point 3")
    public Point getPointP3() {
        return new Point(12,2);
    }

    @Bean(name="Point 4")
    public Point getPointP4() {
        return new Point(2,2);
    }

    @Bean(name="Rectangle")
    public Rectangle buildRectangle() {
        List<String> quadrilaterals = new ArrayList<>();
        quadrilaterals.add("Square");
        quadrilaterals.add("Rectangle");
        quadrilaterals.add("Rhombus");
        quadrilaterals.add("Parallelogram");
        quadrilaterals.add("Trapezium");
        return new Rectangle(this.getPointP1(), this.getPointP2(), this.getPointP3(), this.getPointP4(), quadrilaterals);
    }
}