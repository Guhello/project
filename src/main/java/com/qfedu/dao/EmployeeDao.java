package com.qfedu.dao;

import com.qfedu.entity.Employee;

import java.util.List;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	// 插入操作，sql语句的写法和xml配置中写法相同
	public void add(Employee emp);
	
	// 删除操作
	public void deleteById(int id);
	
	public Employee findById(int id);
	
	public void update(Employee emp);
	
}






