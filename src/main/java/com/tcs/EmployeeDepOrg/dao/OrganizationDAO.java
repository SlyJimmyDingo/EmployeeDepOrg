package com.tcs.EmployeeDepOrg.dao;

import java.util.List;
import java.util.Optional;
import com.tcs.EmployeeDepOrg.model.Department;
import com.tcs.EmployeeDepOrg.model.Employee;
import com.tcs.EmployeeDepOrg.model.Organization;

public interface OrganizationDAO {
	
	public String addOrganization(Organization organization);
	public String updateOrganization(Organization organization, long id);
	public String deleteOrganization(Organization organization, long id);
	public Optional<Organization> findById(long id);
	public Optional<List<Employee>> getEmployees(long id);
	public Optional<List<Department>> getDepartments(long id);
	public Optional<List<Organization>> getOrganizations();
	
}