package io.abner.gradle.apps.app1;

import java.util.List;

public interface EmployeeDAO {
    
    List<Employee> findAll();

    void insertEmployee(Employee emp);

    void updateEmployee(Employee emp);

    void executeUpdateEmployee(Employee emp);

    public void deleteEmployee(Employee emp);
}