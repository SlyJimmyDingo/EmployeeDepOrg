package com.tcs.EmployeeDepOrg.dao;

import java.util.List;
import java.util.Optional;
import com.tcs.EmployeeDepOrg.model.Employee;

public interface EmployeeDAO {
	
	public String addEmployee(Employee employee);
	public String updateEmployee(Employee employee, long id);
	public String deleteEmployee(Employee employee, long id);
	public Optional<Employee> findById(long id);
	public Optional<List<Employee>> getEmployees();
	public Optional<List<Employee>> findByOrganizationId(long id);
	
}

