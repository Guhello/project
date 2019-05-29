package com.qfedu.controller;

import com.qfedu.entity.Employee;
import com.qfedu.service.EmployeeService;
import com.qfedu.vo.JsonBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	// 设置指定的权限
	@RequiresPermissions("user:list")
	@RequestMapping("/list.do")
	public String list(Model model){
		
		List<Employee> list = empService.findAllEmp();
		model.addAttribute("empList", list);
		
		return "list";
	}

	@RequiresPermissions("user:add")
	@RequestMapping("/add.do")
	public String add(Employee emp){
		empService.addEmp(emp);
		
		return "redirect:/list.do";
	}
	@RequiresPermissions("user:delete")
	@RequestMapping("/delete.do")
	public String deleteById(int id){
		empService.deleteEmpById(id);
		return "redirect:/list.do";
	}
	@RequestMapping("/query.do")
	public String findById(int id, Model model){
		Employee emp = empService.findEmpById(id);
		model.addAttribute("emp", emp);
		return "update";
	}
	
	@RequestMapping("/update.do")
	public String update(Employee emp){
		empService.udpateEmp(emp);
		return "redirect:/list.do";
	}



}







