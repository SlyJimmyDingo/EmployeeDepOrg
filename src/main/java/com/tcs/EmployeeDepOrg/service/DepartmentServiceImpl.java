package com.tcs.EmployeeDepOrg.service;

import java.util.*;

import com.tcs.EmployeeDepOrg.dao.DepartmentDAO;
import com.tcs.EmployeeDepOrg.dao.DepartmentDAOImpl;
import com.tcs.EmployeeDepOrg.model.Department;
import com.tcs.EmployeeDepOrg.model.Employee;

public class DepartmentServiceImpl implements DepartmentService {

	private static DepartmentService dao;

	private DepartmentServiceImpl() {}
	
	public static DepartmentService getInstance() {
		
		if(dao==null) {
			dao = new DepartmentServiceImpl();
			return dao;
		}
		return dao;
		
		
	}
	DepartmentDAO departmentDao = DepartmentDAOImpl.getInstance();
	
	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentDao.addDepartment(department);
	}
	
	@Override
	public String updateDepartment(Department department, long id) {
		// TODO Auto-generated method stub
		return departmentDao.updateDepartment(department, id);
	}
	
	@Override
	public String deleteDepartment(Department department, long id){
		// TODO Auto-generated method stub
		return departmentDao.updateDepartment(department, id);
	}	

	@Override
	public Optional<Department> findById(long id){
		// TODO Auto-generated method stub
		return departmentDao.findById(id);
	}
	
	@Override
	public Optional<List<Department>> getDepartments(){
		// TODO Auto-generated method stub
		return departmentDao.getDepartments();
	}
	
	@Override
	public Optional<List<Department>> findByOrganizationId(long id) {
		// TODO Auto-generated method stub
		return departmentDao.findByOrganizationId(id);
	}
	
	@Override
	public Optional<List<Employee>> getEmployees(long id) {
		// TODO Auto-generated method stub
		return departmentDao.getEmployees(id);
	}

}
