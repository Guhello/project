package com.qfedu.service;

import java.util.List;

import com.qfedu.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmp();
	
	public void addEmp(Employee emp);
	
	public void deleteEmpById(int id);
	
	public Employee findEmpById(int id);
	
	public void udpateEmp(Employee emp);
}
