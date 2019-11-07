package io.abner.gradle.apps.app1;

import java.util.List;

public interface EmployeeService {

	
	List<Employee> findAll();

	void insertEmployee(Employee emp);

bootRun {

    if (project.hasProperty('args')) {

        args project.args.split(',')
    }
}}