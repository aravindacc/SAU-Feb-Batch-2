package com.example.demo.ques2.models;

import org.springframework.stereotype.Component;

@Component
public class Triangle {
    private String type = "equilateral";
    private int base = 10;
    private int height = 5;

    public String getType() {
        return type;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getArea() {
        return 0.5*base*height;
    }
}
