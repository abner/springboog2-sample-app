package io.abner.gradle.apps.app1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Employee {

	@Id
	@Column(name = "employeeid")
	String employeeId;
	@Column(name = "employeename")
	String employeeName;
	@Column(name = "employeeemail")
	String employeeEmail;
	@Column(name = "employeeaddress")
	String employeeAddress;
	
	
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	
}