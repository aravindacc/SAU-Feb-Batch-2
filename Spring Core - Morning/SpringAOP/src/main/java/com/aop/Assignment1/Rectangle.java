package com.aop.Assignment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

//       (1,6)                     (11,6)
//        p1 ---------------------- p2
//        |                         |
//        |                         |
//        |                         |
//        p4 ---------------------- p3
//      (5,5)                      (12,2)
//

@Component
public class Rectangle {
    // List Of Quadrilaterals
    private List<String> quadrilaterals;

    @Autowired
    @Qualifier("Point 1")
    private Point point1;

    @Autowired
    @Qualifier("Point 2")
    private Point point2;

    @Autowired
    @Qualifier("Point 3")
    private Point point3;

    @Autowired
    @Qualifier("Point 4")
    private Point point4;

    public List<String> getAllQuadrilaterals() {
        return this.quadrilaterals;
    }


    public Rectangle(Point point1, Point point2, Point point3, Point point4, List<String> quadrilaterals) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
        this.quadrilaterals = quadrilaterals;
    }

    private int height, width;


    public List<String> getQuadrilaterals() {
        return quadrilaterals;
    }

    public void setQuadrilaterals(List<String> quadrilaterals) {
        this.quadrilaterals = quadrilaterals;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
    }

    public int getHeight() {
        this.height = point1.getY_axis() - point4.getY_axis();
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        this.width = point2.getX_axis() - point1.getX_axis();
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}