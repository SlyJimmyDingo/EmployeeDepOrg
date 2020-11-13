package com.tcs.EmployeeDepOrg.service;

import java.util.*;

import com.tcs.EmployeeDepOrg.dao.EmployeeDAO;
import com.tcs.EmployeeDepOrg.dao.EmployeeDAOImpl;
import com.tcs.EmployeeDepOrg.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeService dao;

	private EmployeeServiceImpl() {}
	
	public static EmployeeService getInstance() {
		
		if(dao==null) {
			dao = new EmployeeServiceImpl();
			return dao;
		}
		return dao;
		
		
	}
	EmployeeDAO EmployeeDao = EmployeeDAOImpl.getInstance();
	
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return EmployeeDao.addEmployee(employee);
	}
	
	@Override
	public String updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		return EmployeeDao.updateEmployee(employee, id);
	}
	
	@Override
	public String deleteEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		return EmployeeDao.deleteEmployee(employee, id);
	}	

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return EmployeeDao.findById(id);
	}
	
	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return EmployeeDao.getEmployees();
	}
	
	@Override
	public Optional<List<Employee>> findByOrganizationId(long id) {
		// TODO Auto-generated method stub
		return EmployeeDao.findByOrganizationId(id);
	}

}
