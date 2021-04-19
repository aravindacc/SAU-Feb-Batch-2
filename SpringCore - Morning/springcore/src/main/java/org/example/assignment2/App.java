package org.example.assignment2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class App {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Student student = context.getBean("student", Student.class);
        student.getName();
        int rollnumber = student.getRollnumber();


        Organization org = context.getBean("organization", Organization.class);
        String company_name = org.getCompany();
        int percentage = student.getPercentage(78, 96);
        // This is a after throw advice, therefore using it at last
        student.getCourse("CSE");
    }
}
