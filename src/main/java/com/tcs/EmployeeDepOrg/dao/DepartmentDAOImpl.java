package com.tcs.EmployeeDepOrg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.tcs.EmployeeDepOrg.model.Department;
import com.tcs.EmployeeDepOrg.model.Employee;
import com.tcs.EmployeeDepOrg.utils.DBUtils;

public class DepartmentDAOImpl implements DepartmentDAO {
	
	private DepartmentDAOImpl() {
	}

	private static DepartmentDAO dao;

	public static DepartmentDAO getInstance() {
		
		if(dao==null) {
			dao = new DepartmentDAOImpl();
			return dao;
		}
		return dao;	
	}

	@Override
	public String addDepartment(Department department) {
		
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String query = "insert into DEPARTMENT (departmentid,organizationId,name) values(?,?,?)";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1, department.getId());
			 preparedStatement.setLong(2, department.getOrganizationId());
			 preparedStatement.setString(3, department.getName());
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
	public String updateDepartment(Department department, long id) {
		
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String query = "UPDATE DEPARTMENT set departmentId=?, organizationId=?, name=? WHERE departmentId=" + id;
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1, department.getId());
			 preparedStatement.setLong(2, department.getOrganizationId());
			 preparedStatement.setString(3, department.getName());
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
	public String deleteDepartment(Department department, long id) {
		
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String query = "DELETE FROM DEPARTMENT WHERE departmentId=" + id;
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
	public Optional<Department> findById(long id) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Department department = null;
		String query = "select * from DEPARTMENT where departmentId=" + id;
		try {
			 preparedStatement = connection.prepareStatement(query);
			
			resultSet =  preparedStatement.executeQuery();
			 
			if(resultSet.next()) {
				department = new Department();
				department.setId(resultSet.getLong("departmentId"));
				department.setOrganizationId(resultSet.getLong("organizationId"));
				department.setName(resultSet.getString("name"));				 
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
		return Optional.of(department);
	}
	
	@Override
	public Optional<List<Department>> getDepartments()
	{
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Department department = null;
		List<Department> depList = new ArrayList<>();
		String query = "select * from DEPARTMENT order by departmentid";
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
	public Optional<List<Department>> findByOrganizationId(long id)
	{
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Department department = null;
		List<Department> depList = new ArrayList<>();
		String query = "select * from DEPARTMENT where organizationId=" + id;
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
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return Optional.of(depList);
	}
	
	@Override
	public Optional<List<Employee>> getEmployees(long id)
	{
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		List<Employee> empList = new ArrayList<>();
		String query = "select * from EMPLOYEE where departmentid=" + id;
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
				employee.setAge(resultSet.getInt("age"));
				employee.setPosition(resultSet.getString("position"));
				empList.add(employee);
			}
			 
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return Optional.of(empList);
	}
	
}
