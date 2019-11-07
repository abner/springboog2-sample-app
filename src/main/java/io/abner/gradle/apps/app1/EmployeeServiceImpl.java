package io.abner.gradle.apps.app1;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// @Component
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Resource 
	EmployeeDAO employeeDao;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
	@Override
	public void insertEmployee(Employee emp) {
		employeeDao.insertEmployee(emp);
		
	}
	@Override
	public void updateEmployee(Employee emp) {
		employeeDao.updateEmployee(emp);
		
	}
	@Override
	public void executeUpdateEmployee(Employee emp) {
		employeeDao.executeUpdateEmployee(emp);
		
	}

	@Override
	public void deleteEmployee(Employee emp) {
		employeeDao.deleteEmployee(emp);
		
	}
}