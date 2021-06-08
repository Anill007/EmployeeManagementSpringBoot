package com.anil.employeemanager;

import java.util.List;

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

import com.anil.employeemanager.model.Employee;
import com.anil.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	
	public final EmployeeService empService;
	
	public EmployeeResource(EmployeeService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		Employee emp = empService.findEmployeeById(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> emps = empService.findAllEmployees();
		return new ResponseEntity<>(emps, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		Employee newEmp = empService.addEmployee(emp);
		return new ResponseEntity<>(newEmp, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		Employee newEmp = empService.updateEmployee(emp);
		return new ResponseEntity<>(newEmp, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id){
		empService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
