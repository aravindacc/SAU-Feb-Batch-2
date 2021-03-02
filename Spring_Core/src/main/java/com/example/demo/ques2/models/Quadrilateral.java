package com.example.demo.ques2.models;

import org.springframework.stereotype.Component;

@Component
public class Quadrilateral {
    private String type = "rectangle";
    private int length = 10;
    private int breadth = 10;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getArea() {
        return length*breadth;
    }
}
