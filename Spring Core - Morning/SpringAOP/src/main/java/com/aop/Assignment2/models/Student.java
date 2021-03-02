package com.aop.Assignment2.models;

import org.springframework.stereotype.Component;

@Component // Makes it a bean
public class Student {

    private int employeeCode = 607;
    private String name = "Abhinav";

    public void getName() {
        System.out.println("Hello this is " + this.name);
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void getCourse(String course) {
        System.out.println("Course = " + course);
        throw new RuntimeException();
    }

    public int getPercentage(int m1, int m2) {
        return (( m1 + m2 ) / 2);
    }
}