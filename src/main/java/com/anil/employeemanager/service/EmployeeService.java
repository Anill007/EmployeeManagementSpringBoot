package com.anil.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.employeemanager.model.Employee;
import com.anil.employeemanager.myexceptions.UserNotFoundException;
import com.anil.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository ;
	
	@Autowired
	public EmployeeService(EmployeeRepository ep) {
		this.employeeRepository = ep;
	}
	
	public Employee addEmployee(Employee emp) {
		emp.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(emp);
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	public Employee findEmployeeById(Long id) {
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User"+id+"not found"));
	}
	
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		System.out.println(id);
	}
	
	 
}
