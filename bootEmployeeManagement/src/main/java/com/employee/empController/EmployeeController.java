package com.employee.empController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.entities.Employees;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employees>> getAllEmployees(){
		return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
		
	}
	
	@GetMapping("{emp_Id}")
	public ResponseEntity<Employees> getEmployeeById(@PathVariable Long emp_Id) {
		Employees employee =  employeeService.getEmployeeById(emp_Id);
		if(employee != null) {			
			return new ResponseEntity<>(employee,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<String> saveEmployee(@RequestBody Employees employee) {
		
		employeeService.saveEmployee(employee);
		return new ResponseEntity<>("Employee Added Successfully", HttpStatus.CREATED);	
		
	}
	
	@DeleteMapping("/{emp_Id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long emp_Id){
		
		boolean isDeleted = employeeService.deleteEmployee(emp_Id);
		if(isDeleted) {
			return new ResponseEntity<>("Deleted Employee Successfully",HttpStatus.OK);	
		}
		
		return new ResponseEntity<>("Employee Not Available",HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/{emp_Id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long emp_Id, 
												@RequestBody Employees updatedEmp){
		
		boolean isUpdated = employeeService.updateEmployee(emp_Id,updatedEmp);
		if(isUpdated) {
			return new ResponseEntity<>("Updated the Employee",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Employee Not Found",HttpStatus.NOT_FOUND);
		
	}  

}
