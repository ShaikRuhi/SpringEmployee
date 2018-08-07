package com.cg.service1;

import java.util.List;

import com.cg.bean.Employee;

public interface IEmployeeService {

	Employee createEmployee(Employee emp);
	Employee updateEmployee(Employee emp);
	boolean deleteEmployee(String eid);
	List<Employee> getEmployeeDetails(Employee emp);
	Employee getEmployeeById(String eid);
	
}
