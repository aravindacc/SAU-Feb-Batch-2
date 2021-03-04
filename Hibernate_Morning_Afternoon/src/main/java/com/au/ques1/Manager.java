package com.au.ques1;

import com.au.ques1.util.EmployeeUtil;
import com.au.ques1.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class Manager {
    public static void main(String[] args) {
        Session session = SessionUtil.getSession();
        Scanner scanner = new Scanner(System.in);
        int choice = 7;
        Transaction tx;
        do {
            System.out.println("1. Create employee\n" +
                    "2. Update employee by id\n" +
                    "3. Update all employees record\n"+
                    "4. Delete employee \n" +
                    "5. Get all employee\n" +
                    "6. Get Employee by id\n" +
                    "7. exit\n" +
                    "Enter your choice (1-7)");

                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            tx = session.beginTransaction();
                            Employee employee = EmployeeUtil.getEmployee();
                            session.save(employee);
                            tx.commit();

                            System.out.println("Employee Created Successfully");
                            break;

                        case 2:

                            System.out.println("Enter Employee ID: ");
                            int empID = scanner.nextInt();

                            Employee employeeTobeUpdated = session.get(Employee.class, empID);
                            if (employeeTobeUpdated == null) {
                                System.out.println("No Employee Found");
                            } else {
                                tx = session.beginTransaction();
                                employee = EmployeeUtil.updateEmployee(employeeTobeUpdated);
                                session.update(employee);
                                tx.commit();
                                System.out.println("Employee Successfully Updated");
                            }
                            break;

                        case 3:
                            tx = session.beginTransaction();
                            System.out.println("Updating the Designation of all Employees");
                            String query = "Update Employee SET Designation = 'Software Engineer' where Designation = 'Intern'";
                            try {
                                session.createSQLQuery(query).executeUpdate();
                                System.out.println("All Records Updated");
                                tx.commit();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 4:
                            System.out.println("Enter Employee ID to be deleted");
                            int eID = scanner.nextInt();
                            Employee employeeToBeDeleted = session.get(Employee.class, eID);
                            if (employeeToBeDeleted == null) {
                                System.out.println("No Employee Found");
                            } else {
                                tx = session.beginTransaction();
                                session.delete(employeeToBeDeleted);
                                tx.commit();
                                System.out.println("Employee Deleted Successfully");
                            }
                            break;
                        case 5:
                            List<Employee> allEmployees = EmployeeUtil.getAllEmployees(Employee.class, session);
                            System.out.println("--------------------------------------------------------------------------");
                            System.out.println("Id \t First Name \t Last Name \t Age \t Salary \t DOB \t Designation");
                            System.out.println("--------------------------------------------------------------------------");
                            for(Employee emp: allEmployees) {
                                System.out.println(emp.getId() + "\t" + emp.getFname() + "\t" + emp.getLname()
                                + "\t" + emp.getAge() + "\t" + emp.getSalary() + "\t" + emp.getDob()
                                + "\t" + emp.getDesignation());
                            }
                            System.out.println();
                            break;
                        case 6:
                            System.out.println("Enter Employee ID");
                            int emID = scanner.nextInt();
                            Employee getEmployee = session.get(Employee.class, emID);
                            if (getEmployee == null) {
                                System.out.println("No Employee Found");
                            } else {
                                System.out.println("-------------------------------------------------------------------------");
                                System.out.println("Id \t First Name \t Last Name \t Age \t Salary \t DOB \t Designation");
                                System.out.println("-------------------------------------------------------------------------");
                                System.out.println(getEmployee.getId() + "\t" + getEmployee.getFname() + "\t" +
                                        getEmployee.getLname()  + "\t" + getEmployee.getAge() + "\t" +
                                        getEmployee.getSalary() + "\t" + getEmployee.getDob()
                                        + "\t" + getEmployee.getDesignation());
                                System.out.println();
                            }
                    }
        } while( choice != 7);

//        Employee e = new Employee();
//        e.setFname("Kunal");
//        e.setLname("Sharma");
//        e.setAge(22);
//        e.setSalary(20000.00);
//        e.setDob("07/12/1998");
//        e.setDesignation("SDE Intern");
//
//        session.save(e);
//
//        tx.commit();
//        session.close();
//
//        System.out.println("Done");
    }
}
