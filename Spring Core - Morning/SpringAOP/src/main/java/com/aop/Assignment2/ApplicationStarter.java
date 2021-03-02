package com.aop.Assignment2;

import com.aop.Assignment2.models.Organization;
import com.aop.Assignment2.models.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ApplicationStarter {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        Student student = context.getBean("student", Student.class);
        student.getName();
        int employeeCode = student.getEmployeeCode();
        int percentage = student.getPercentage(100, 99);

        // This is a after throw advice, therefore using it at last
        try{
            student.getCourse("CSE");
        }
        catch (Exception e){
            System.out.println("Runtime Exception Occurred");
        }

        Organization org = context.getBean("organization", Organization.class);
        String company_name = org.getCompany();
    }
}