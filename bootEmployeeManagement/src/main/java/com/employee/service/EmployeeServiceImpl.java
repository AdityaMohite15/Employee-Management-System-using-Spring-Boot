package com.employee.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.entities.Employees;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//	List<Employees> employees = new ArrayList<>();
//	private Long nextId = 1L;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employees> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employees employee) {
		
//		employee.setEmp_Id(nextId++);
		employee.setEmp_Id(null);
		employeeRepository.save(employee);
		
	}

	@Override
	public Employees getEmployeeById(Long emp_Id) {
//		
//		for (Employees employee : employees) {
//			if(employee.getEmp_Id().equals(emp_Id)) {
//				return employee;
//			}
//		}
//		return null;
		
		
		return employeeRepository.findById(emp_Id).orElse(null);
		
	}

	@Override
	public boolean deleteEmployee(Long emp_Id) {
		
//		for (Employees employee : employees) {
//			if(employee.getEmp_Id().equals(emp_Id)) {
//				employees.remove(employee);
//				return true;
//			}
//		}
//		return false;
		
		try {
			employeeRepository.deleteById(emp_Id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateEmployee(Long emp_Id, Employees updatedEmp) {
		
		Optional<Employees> empOptional = employeeRepository.findById(emp_Id);
			if(empOptional.isPresent()) {
				Employees employee = empOptional.get();
				
				employee.setEmp_Name(updatedEmp.getEmp_Name());
				employee.setEmp_email(updatedEmp.getEmp_email());
				employee.setEmp_Designation(updatedEmp.getEmp_Designation());
				employee.setEmp_Department(updatedEmp.getEmp_Department());
				employee.setEmp_Salary(updatedEmp.getEmp_Salary());
				employeeRepository.save(employee);
				
				return true;
			}
		
		return false;
	}

}
