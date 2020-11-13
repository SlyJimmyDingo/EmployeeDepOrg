package com.tcs.EmployeeDepOrg.service;

import java.util.*;

import com.tcs.EmployeeDepOrg.dao.OrganizationDAO;
import com.tcs.EmployeeDepOrg.dao.OrganizationDAOImpl;
import com.tcs.EmployeeDepOrg.model.Department;
import com.tcs.EmployeeDepOrg.model.Employee;
import com.tcs.EmployeeDepOrg.model.Organization;

public class OrganizationServiceImpl implements OrganizationService {

	private static OrganizationService dao;

	private OrganizationServiceImpl() {}
	
	public static OrganizationService getInstance() {
		
		if(dao==null) {
			dao = new OrganizationServiceImpl();
			return dao;
		}
		return dao;
		
		
	}
	OrganizationDAO organizationDao = OrganizationDAOImpl.getInstance();
	
	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		return organizationDao.addOrganization(organization);
	}
	
	@Override
	public String updateOrganization(Organization organization, long id) {
		// TODO Auto-generated method stub
		return organizationDao.updateOrganization(organization, id);
	}
	
	@Override
	public String deleteOrganization(Organization organization, long id){
		// TODO Auto-generated method stub
		return organizationDao.updateOrganization(organization, id);
	}	

	@Override
	public Optional<Organization> findById(long id){
		// TODO Auto-generated method stub
		return organizationDao.findById(id);
	}
	
	@Override
	public Optional<List<Employee>> getEmployees(long id) {
		// TODO Auto-generated method stub
		return organizationDao.getEmployees(id);
	}
	
	@Override
	public Optional<List<Department>> getDepartments(long id){
		// TODO Auto-generated method stub
		return organizationDao.getDepartments(id);
	}
	
	
	@Override
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		return organizationDao.getOrganizations();
	}

}
