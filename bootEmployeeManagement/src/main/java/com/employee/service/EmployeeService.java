package com.employee.service;

import java.util.List;

import com.employee.entities.Employees;

public interface EmployeeService {
	
	List<Employees> getAllEmployees();
	void saveEmployee(Employees employee);
	Employees getEmployeeById(Long emp_Id);
	boolean deleteEmployee(Long emp_Id);
	boolean updateEmployee(Long emp_Id, Employees updatedEmp);

}
