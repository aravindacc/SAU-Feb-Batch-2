package com.webapp.Hibernate_CRUD_1;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Employee 
{
	@Id
	@GeneratedValue
	private int id;
	private String fname;
	private String laname;
	@Column(length = 2)
	private int age;
	private float salary;
	private String DOB;
	private String Designation;
	
	
	
	public Employee(int id, String fname, String laname, int age, float salary, String DOB, String designation) {
		super();
		this.id = id;
		this.fname = fname;
		this.laname = laname;
		this.age = age;
		this.salary = salary;
		this.DOB = DOB;
		this.Designation = designation;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLaname() {
		return laname;
	}
	public void setLaname(String laname) {
		this.laname = laname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String DOB) {
		this.DOB = DOB;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	
}
