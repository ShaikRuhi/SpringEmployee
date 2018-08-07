package com.cg.service1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.Employee;

import com.cg.repo1.EmployeeRepo;
@Service
@PersistenceContext
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EntityManager em;
	@Autowired
	private EmployeeRepo repo;
	@Override
	public Employee createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		repo.save(emp);
		
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Employee employee= repo.EmployeeDetails(emp.getEid());
		employee.setEname(emp.getEname());
		employee.setProject(emp.getProject());
		employee.setSalary(emp.getSalary());
		repo.save(employee);
		return employee;
		
		
	}

	@Override
	public boolean deleteEmployee(String eid) {
	Employee e=repo.EmployeeDetails(eid);
		if(e!=null) {
			repo.deleteById(eid);
		return true;
		}
		else {
		return false;
	}
	}
	@Override
	public List<Employee> getEmployeeDetails(Employee emp) {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(String eid) {
		// TODO Auto-generated method stub
		return repo.EmployeeDetails(eid);
	}

}
