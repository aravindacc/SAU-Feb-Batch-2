package com.example.demo.ques1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean(name="rectangleObj")
    public Rectangle getRectangle() {
        return new Rectangle("Rectangle");
    }

    @Bean(name="rectangleObjUsingList")
    public Rectangle getRectangleUsingList() {
        return new Rectangle(Arrays.asList(getPointA(), getPointB(), getPointC(), getPointD()));
    }

    @Bean(name="PointA")
    public Point getPointA() {
        return new Point(0, 0);
    }

    @Bean(name="PointB")
    public Point getPointB() {
        return new Point(10, 0);
    }

    @Bean(name="PointC")
    public Point getPointC() {
        return new Point(10, 5);
    }

    @Bean(name="PointD")
    public Point getPointD() {
        return new Point(0, 5);
    }
}
