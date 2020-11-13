package com.tcs.EmployeeDepOrg.model;

import java.util.*;

public class Department {
	
	private long departmentId;
	private long organizationId;
	private String name;
	private List<Employee> employees;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Department(long departmentId, long organizationId, String name, List<Employee> employees) {
		super();
		this.departmentId = departmentId;
		this.organizationId = organizationId;
		this.name = name;
		this.employees = employees;
	}
	
	
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", organizationId=" + organizationId + ", name=" + name + "]";
	}

	public long getId() {
		return departmentId;
	}
	public void setId(long departmentId) {
		this.departmentId = departmentId;
	}
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
