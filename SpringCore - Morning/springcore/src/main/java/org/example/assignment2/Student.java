package org.example.assignment2;

import org.springframework.stereotype.Component;

@Component
public class Student {
    String name = "Kishan";
    int rollnumber = 3195;
    public void getName() {
        System.out.println("Hello this is Kishan");
    }

    public int getRollnumber() {
        return rollnumber;
    }

    public void getCourse(String course) {
        System.out.println("Course = " + course);
        throw new RuntimeException();

    }

    public int getPercentage(int m1, int m2) {
        return ((m1+m2)/2);
    }
}
