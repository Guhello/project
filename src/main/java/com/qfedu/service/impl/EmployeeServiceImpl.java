package com.qfedu.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfedu.dao.EmployeeDao;
import com.qfedu.entity.Employee;
import com.qfedu.service.EmployeeService;

// 在业务层进行事务处理
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao empDao = null;
	
	@Override
	public List<Employee> findAllEmp() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}
	
	@Override
	public void addEmp(Employee emp) {
		// TODO Auto-generated method stub
		empDao.add(emp);
	}
	
	@Override
	public void deleteEmpById(int id) {
		// TODO Auto-generated method stub
		empDao.deleteById(id);
	}
	
	@Override
	public Employee findEmpById(int id) {
		// TODO Auto-generated method stub
		return empDao.findById(id);
	}
	
	@Override
	public void udpateEmp(Employee emp) {
		// TODO Auto-generated method stub
		empDao.update(emp);
	}
	
	

}
