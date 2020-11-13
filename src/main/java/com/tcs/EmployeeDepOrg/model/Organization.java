package com.tcs.EmployeeDepOrg.model;
import java.util.*;

public class Organization {
	
	private long organizationId;
	private String name;
	private String address;
	private List<Department> departments = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();
	
	public Organization() {
		super();
		}
	
	public Organization(long id, String name, String address, List<Department> departments, List<Employee> employees) 
	{
		super();
		this.organizationId = id;
		this.name = name;
		this.address = address;
		this.departments = departments;
		this.employees = employees;
	}
	
	@Override
	public String toString() {
		return "Organization [organizationId=" + organizationId + ", name=" + name + ", address=" + address
				+ ", departments=" + departments + ", employees=" + employees + "]";
	}

	public long getId() {
		return organizationId;
	}
	public void setId(long id) {
		this.organizationId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
