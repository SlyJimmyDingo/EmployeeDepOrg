package com.tcs.EmployeeDepOrg.service;

import java.util.List;
import java.util.Optional;

import com.tcs.EmployeeDepOrg.model.Department;
import com.tcs.EmployeeDepOrg.model.Employee;

public interface DepartmentService {
	
	public String addDepartment(Department department);
	public String updateDepartment(Department department, long id);
	public String deleteDepartment(Department department, long id);
	public Optional<Department> findById(long id);
	public Optional<List<Department>> getDepartments();
	public Optional<List<Department>> findByOrganizationId(long id);
	public Optional<List<Employee>> getEmployees(long id);
	
}
