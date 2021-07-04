package com.example.demo.ques1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(value = "prototype")
public class Rectangle {

    @Autowired
    @Qualifier("PointA")
    private Point p1;

    @Autowired
    @Qualifier("PointB")
    private Point p2;

    @Autowired
    @Qualifier("PointC")
    private Point p3;

    @Autowired
    @Qualifier("PointD")
    private Point p4;

    private String type;

    private List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    int height, width;

    public int getHeight() {
        return Math.abs(p1.getY() - p4.getY());
    }

    public int getWidth() {
        return Math.abs(p1.getX() - p2.getX());
    }

    public Rectangle(String type) {
        this.type = type;
    }

    public Rectangle(List<Point> points) {
        this.points = points;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public Point getP4() {
        return p4;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void draw() {
//        System.out.println("Rectangle drawn of type: " + getType());
//        System.out.println("Point A: " + getP1().getX() + " " + getP1().getY());
//        System.out.println("Point B: " + getP2().getX() + " " + getP2().getY());
//        System.out.println("Point C: " + getP3().getX() + " " + getP3().getY());
//        System.out.println("Point D: " + getP4().getX() + " " + getP4().getY());

        // Using List
        for(Point point: points) {
            System.out.println(point.getX() + " " + point.getY());
        }
    }
}
