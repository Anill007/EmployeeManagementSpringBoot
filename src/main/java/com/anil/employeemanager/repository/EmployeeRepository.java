package com.anil.employeemanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anil.employeemanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	void deleteById(Long id);

	Optional<Employee> findEmployeeById(Long id);

}
