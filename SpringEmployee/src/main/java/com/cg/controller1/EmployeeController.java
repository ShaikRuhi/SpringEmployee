package com.cg.controller1;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Employee;
import com.cg.service1.IEmployeeService;

@RestController
@Transactional

public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	@RequestMapping(value="/createEmployee",method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee emp) {
		service.createEmployee(emp);
		return emp;
		
	}
	@RequestMapping(value="/updateEmployee",method=RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee emp) {
		Employee emp1=service.updateEmployee(emp);
		return emp1;
		
	}
	@RequestMapping(value="/deleteEmployee",method=RequestMethod.DELETE)
	public boolean deleteEmployee(String eid) {
	boolean b=service.deleteEmployee(eid);
		return b;
		
	}
	@RequestMapping(value="/getEmployee",method=RequestMethod.GET)
	public Employee getEmployeeById(String eid) {
		Employee emp=service.getEmployeeById(eid);
		return emp;
		
	}
	@RequestMapping(value="/employee",method=RequestMethod.GET)
	public List<Employee> getEmployeeDetails(Employee emp) {
		
		return service.getEmployeeDetails(emp);
		
	}
	
}
