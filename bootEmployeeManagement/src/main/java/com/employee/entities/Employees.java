package com.employee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emp_Id;
	
	private String emp_Name;
	private String emp_email;
	private String emp_Designation;
	private String emp_Department;
	private double emp_Salary;
	
	public Employees() {
		super();
	}
	public Employees(Long emp_Id, String emp_Name, String emp_email, String emp_Designation, String emp_Department,
			double emp_Salary) {
		super();
		this.emp_Id = emp_Id;
		this.emp_Name = emp_Name;
		this.emp_email = emp_email;
		this.emp_Designation = emp_Designation;
		this.emp_Department = emp_Department;
		this.emp_Salary = emp_Salary;
	}
	public Long getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(Long emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getEmp_Name() {
		return emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_Designation() {
		return emp_Designation;
	}
	public void setEmp_Designation(String emp_Designation) {
		this.emp_Designation = emp_Designation;
	}
	public String getEmp_Department() {
		return emp_Department;
	}
	public void setEmp_Department(String emp_Department) {
		this.emp_Department = emp_Department;
	}
	public double getEmp_Salary() {
		return emp_Salary;
	}
	public void setEmp_Salary(double emp_Salary) {
		this.emp_Salary = emp_Salary;
	}
	
	

}
