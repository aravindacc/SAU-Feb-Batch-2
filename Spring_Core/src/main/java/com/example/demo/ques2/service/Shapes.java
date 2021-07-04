package com.example.demo.ques2.service;

import com.example.demo.ques2.models.Triangle;
import javafx.scene.shape.Circle;

public class Shapes {
    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    private Circle circle;
    private Triangle triangle;


}
