package com.au.ques1.util;

import com.au.ques1.Employee;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Scanner;

public class EmployeeUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static Employee getEmployee() {

        Employee employee = new Employee();

        System.out.println("Enter the Employee First Name");
        employee.setFname(scanner.nextLine());

        System.out.println("Enter the Employee Last Name");
        employee.setLname(scanner.nextLine());

        System.out.println("DOB");
        employee.setDob(scanner.nextLine());

        System.out.println("Designation");
        employee.setDesignation(scanner.nextLine());

        System.out.println("Age");
        employee.setAge(scanner.nextInt());

        System.out.println("Salary");
        employee.setSalary(scanner.nextInt());


        return employee;
    }

    public static Employee updateEmployee(Employee employee) {

        System.out.println("Do you want to update First Name (y/n)");
        String updateFName = scanner.nextLine();
        if (updateFName.equalsIgnoreCase("y")) {
            System.out.println("Enter the Employee First Name");
            employee.setFname(scanner.nextLine());
        }

        System.out.println("Do you want to update Last Name (y/n)");
        String updateLName = scanner.nextLine();
        if (updateLName.equalsIgnoreCase("y")) {
            System.out.println("Enter the Employee Last Name");
            employee.setLname(scanner.nextLine());
        }

        System.out.println("Do you want to update Age (y/n)");
        String updateAge = scanner.nextLine();
        if (updateAge.equalsIgnoreCase("y")) {
            System.out.println("Enter the Employee Age");
            employee.setAge(scanner.nextInt());
        }

        System.out.println("Do you want to update Salary (y/n)");
        String updateSalary = scanner.nextLine();
        if (updateSalary.equalsIgnoreCase("y")) {
            System.out.println("Enter the Employee Salary");
            employee.setSalary(scanner.nextInt());
        }

        System.out.println("Do you want to update DOB (y/n)");
        String updateDOB = scanner.nextLine();
        if (updateDOB.equalsIgnoreCase("y")) {
            System.out.println("Enter the Employee DOB");
            employee.setDob(scanner.nextLine());
            System.out.println("DOB Entered");
        }

        System.out.println("Do you want to update Designation (y/n)");
        String updateDesignation = scanner.nextLine();
        if (updateDesignation.equalsIgnoreCase("y")) {
            System.out.println("Enter the Employee Designation");
            employee.setDesignation(scanner.nextLine());
        }

        return employee;
    }

    public static List<Employee> getAllEmployees(Class<Employee> type, Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(type);
        criteria.from(type);
        return session.createQuery(criteria).getResultList();
    }
}
