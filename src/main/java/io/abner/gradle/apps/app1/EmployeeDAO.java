package io.abner.gradle.apps.app1;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeDAO {
    
    List<Employee> findAll();

    void insertEmployee(Employee emp);

    void updateEmployee(Employee emp);

    void executeUpdateEmployee(Employee emp);

    public void deleteEmployee(Employee emp);
}