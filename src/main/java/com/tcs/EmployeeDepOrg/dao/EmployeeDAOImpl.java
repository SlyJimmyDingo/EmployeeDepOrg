package com.tcs.EmployeeDepOrg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.tcs.EmployeeDepOrg.model.Employee;
import com.tcs.EmployeeDepOrg.utils.DBUtils;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private EmployeeDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	private static EmployeeDAO dao;

	public static EmployeeDAO getInstance() {
		
		if(dao==null) {
			dao = new EmployeeDAOImpl();
			return dao;
		}
		return dao;	
	}

	@Override
	public String addEmployee(Employee employee) {
		
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String query = "insert into EMPLOYEE (id,organizationId,departmentId,name,age,position) values(?,?,?,?,?,?)";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1, employee.getId());
			 preparedStatement.setLong(2, employee.getOrganizationId());
			 preparedStatement.setLong(3, employee.getDepartmentId());
			 preparedStatement.setString(4, employee.getName());
			 preparedStatement.setInt(5, employee.getAge());
			 preparedStatement.setString(6, employee.getPosition());
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
	public String updateEmployee(Employee employee, long id) {
		
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String query = "UPDATE EMPLOYEE SET organizationId=?, departmentId=?, name=?, age=?, position=? WHERE id=" + id;
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1, employee.getOrganizationId());
			 preparedStatement.setLong(2, employee.getDepartmentId());
			 preparedStatement.setString(3, employee.getName());
			 preparedStatement.setInt(4, employee.getAge());
			 preparedStatement.setString(5, employee.getPosition());
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
	public String deleteEmployee(Employee employee, long id) {
		
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String query = "DELETE FROM EMPLOYEE WHERE id=" + id;
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
	public Optional<Employee> findById(long id) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Employee employee = null;
		String query = "select * from EMPLOYEE where id=" + id;
		try {
			 preparedStatement = connection.prepareStatement(query);
			
			resultSet =  preparedStatement.executeQuery();
			 
			if(resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getLong("id"));
				employee.setOrganizationId(resultSet.getLong("organizationId"));
				employee.setDepartmentId(resultSet.getLong("departmentId"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setPosition(resultSet.getString("position"));				 
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
		return Optional.of(employee);
	}
	
	@Override
	public Optional<List<Employee>> getEmployees()
	{
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		List<Employee> empList = new ArrayList<>();
		String query = "select * from EMPLOYEE order by id";
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
	public Optional<List<Employee>> findByOrganizationId(long id)
	{
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		List<Employee> empList = new ArrayList<>();
		String query = "select * from EMPLOYEE where organizationId=" + id;
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
	
}


/*public String addEmployee(Employee employee);
public String updateEmployee(long id);
public String deleteEmployee(long id);
public Optional<Employee> findById(long id);
public Optional<List<Employee>> getEmployees();
public Optional<List<Employee>> findByOrganizationId(long id);*/
