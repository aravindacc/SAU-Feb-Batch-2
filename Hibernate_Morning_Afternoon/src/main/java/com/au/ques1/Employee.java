package com.au.ques1;

import javax.persistence.*;

@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "FIRST_NAME")
    private String fname;

    @Column(name = "LAST_NAME")
    private String lname;

    @Column(name = "AGE")
    private int age;

    @Column(name="SALARY")
    private int salary;

    @Column(name = "DOB")
    private String dob;

    @Column(name = "DESIGNATION")
    private String designation;

    public Employee(String fname, String lname, int age, int salary,
                    String dob, String designation) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.salary = salary;
        this.dob = dob;
        this.designation = designation;
    }

    public Employee() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
