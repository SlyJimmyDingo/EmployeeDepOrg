package com.tcs.EmployeeDepOrg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.tcs.EmployeeDepOrg.model.Department;
import com.tcs.EmployeeDepOrg.model.Employee;
import com.tcs.EmployeeDepOrg.model.Organization;
import com.tcs.EmployeeDepOrg.utils.DBUtils;

public class OrganizationDAOImpl implements OrganizationDAO {
	
	private OrganizationDAOImpl() {
	}

	private static OrganizationDAO dao;

	public static OrganizationDAO getInstance() {
		
		if(dao==null) {
			dao = new OrganizationDAOImpl();
			return dao;
		}
		return dao;	
	}

	@Override
	public String addOrganization(Organization organization) {
		
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String query = "insert into ORGANIZATION (id,name,address) values(?,?,?)";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1, organization.getId());
			 preparedStatement.setString(2, organization.getName());
			 preparedStatement.setString(3, organization.getAddress());
			 result = preparedStatement.executeUpdate();
			 
			 if(result>0)
			 {
				 connection.commit();
				 return "success";
				 
			 }
			 else {
				 return "fail";
			 }
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
	}
	
	@Override
	public String updateOrganization(Organization organization, long id) {
		
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String query = "UPDATE ORGANIZATION organizationId=?, name=?, address=? WHERE organizationId=" + id;
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1, organization.getId());
			 preparedStatement.setString(2, organization.getName());
			 preparedStatement.setString(3, organization.getAddress());
			 result = preparedStatement.executeUpdate();
			 
			 if(result>0)
			 {
				 connection.commit();
				 return "success";
				 
			 }
			 else {
				 return "fail";
			 }
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
	}
	
	@Override
	public String deleteOrganization(Organization organization, long id) {
		
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String query = "DELETE FROM ORGANIZATION WHERE organizationId=" + id;
		try {
			 preparedStatement = connection.prepareStatement(query);
			 result = preparedStatement.executeUpdate();
			 
			 if(result>0)
			 {
				 connection.commit();
				 return "success";
				 
			 }
			 else {
				 return "fail";
			 }
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
	}
	
	@Override
	public Optional<Organization> findById(long id) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Organization organization = null;
		String query = "select * from ORGANIZATION where organizationId=" + id;
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1,id);
			
			resultSet =  preparedStatement.executeQuery();
			 
			if(resultSet.next()) {
				
				organization = new Organization();
				organization.setId(resultSet.getLong("organizationId"));
				organization.setName(resultSet.getString("name"));
				organization.setAddress(resultSet.getString("address"));				 
			}
			 
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Optional.empty();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return Optional.of(organization);
	}
	
	@Override
	public Optional<List<Employee>> getEmployees(long id)
	{
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		List<Employee> empList = new ArrayList<>();
		String query = "select * from EMPLOYEE order where organizationid=" + id;
		try {
			 preparedStatement = connection.prepareStatement(query);
			
			resultSet =  preparedStatement.executeQuery();
			 
			while(resultSet.next()) 
			{
				employee = new Employee();
				employee.setId(resultSet.getLong("id"));
				employee.setOrganizationId(resultSet.getLong("organizationId"));
				employee.setDepartmentId(resultSet.getLong("departmentId"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("price"));
				employee.setPosition(resultSet.getString("position"));
				empList.add(employee);
			}
			 
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Optional.empty();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return Optional.of(empList);
	}
	
	@Override
	public Optional<List<Department>> getDepartments(long id)
	{
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Department department = null;
		List<Department> depList = new ArrayList<>();
		String query = "select * from DEPARTMENT where organizationid=" + id;
		try {
			 preparedStatement = connection.prepareStatement(query);
			
			resultSet =  preparedStatement.executeQuery();
			 
			while(resultSet.next()) 
			{
				department = new Department();
				department.setId(resultSet.getLong("departmentId"));
				department.setOrganizationId(resultSet.getLong("organizationId"));
				department.setName(resultSet.getString("name"));
				depList.add(department);
			}
			 
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Optional.empty();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return Optional.of(depList);
	}
	
	@Override
	public Optional<List<Organization>> getOrganizations()
	{
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Organization organization = null;
		List<Organization> orgList = new ArrayList<>();
		String query = "select * from ORGANIZATION order by organizationId";
		try {
			 preparedStatement = connection.prepareStatement(query);
			
			resultSet =  preparedStatement.executeQuery();
			 
			while(resultSet.next()) 
			{
				organization = new Organization();
				organization.setId(resultSet.getLong("organizationId"));
				organization.setName(resultSet.getString("name"));
				organization.setAddress(resultSet.getString("address"));
				orgList.add(organization);
			}
			 
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Optional.empty();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return Optional.of(orgList);
	}
	
	
	
}


/*	public String addOrganization(Organization organization);
	public String updateOrganization(Organization organization, long id);
	public String deleteOrganization(Organization organization, long id);
	public Optional<Organization> findById(long id);
	public Optional<List<Employee>> getEmployees();
	public Optional<List<Department>> getDepartments();
	public Optional<List<Organization>> getOrganizations();*/

