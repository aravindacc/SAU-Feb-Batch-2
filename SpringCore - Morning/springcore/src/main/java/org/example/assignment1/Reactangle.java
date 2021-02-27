package org.example.assignment1;

import org.example.assignment1.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

//       (0,5)                     (10,5)
//        p1 ---------------------- p2
//        |                         |
//        |                         |
//        |                         |
//        p4 ---------------------- p3
//      (0,0)                      (10,0)
//

@Component
public class Reactangle {
    @Autowired
    @Qualifier("Point 1")
    private Point p1;

    @Autowired
    @Qualifier("Point 2")
    private Point p2;

    @Autowired
    @Qualifier("Point 3")
    private Point p3;

    public List<String> getQuadilaterals() {
        return quadilaterals;
    }

    @Autowired
    @Qualifier("Point 4")
    private Point p4;

    // Passing a list as well
    private List<String> quadilaterals;
    public Reactangle(Point p1, Point p2, Point p3, Point p4, List<String> quadilaterals) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.quadilaterals = quadilaterals;
    }

    int height, width;

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public Point getP4() {
        return p4;
    }

    public int getHeight() {
        this.height = p1.getY() - p4.getY();
        return this.height;
    }

    public int getWidth() {
        this.width = p2.getX() - p1.getX();
        return this.width;
    }


}
