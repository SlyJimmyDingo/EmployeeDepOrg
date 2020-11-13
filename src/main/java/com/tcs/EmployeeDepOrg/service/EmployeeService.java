package com.tcs.EmployeeDepOrg.service;

import java.util.*;

import com.tcs.EmployeeDepOrg.model.Employee;

public interface EmployeeService {
	
	public String addEmployee(Employee employee);
	public String updateEmployee(Employee employee, long id);
	public String deleteEmployee(Employee employee, long id);
	public Optional<Employee> findById(long id);
	public Optional<List<Employee>> getEmployees();
	public Optional<List<Employee>> findByOrganizationId(long id);
	
}
