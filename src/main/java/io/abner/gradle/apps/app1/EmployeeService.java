package io.abner.gradle.apps.app1;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeService {

	
	List<Employee> findAll();

	void insertEmployee(Employee emp);

	void updateEmployee(Employee emp);

	void executeUpdateEmployee(Employee emp);

	void deleteEmployee(Employee emp);
	
}