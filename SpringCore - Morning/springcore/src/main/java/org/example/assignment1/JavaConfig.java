package org.example.assignment1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.ArrayList;
import java.util.List;

@Configuration
public class JavaConfig {

    // MissSpelled Rectangle intentionally.
    @Bean(name="rect")
    public Reactangle createReactangleobject() {
        List<String> quadilaterals = new ArrayList<>();
        quadilaterals.add("Square");
        quadilaterals.add("Rectangle");
        quadilaterals.add("Rhombus");
        quadilaterals.add("Parallelogram");
        quadilaterals.add("Trapezium");
        return new Reactangle(getPointP1(), getPointP2(), getPointP3(), getPointP4(), quadilaterals);
    }

    @Bean(name="Point 1")
    public Point getPointP1() {
        return new Point(0,5);
    }

    @Bean(name="Point 2")
    public Point getPointP2() {
        return new Point(10,5);
    }

    @Bean(name="Point 3")
    public Point getPointP3() {
        return new Point(10,0);
    }

    @Bean(name="Point 4")
    public Point getPointP4() {
        return new Point(0,0);
    }

}