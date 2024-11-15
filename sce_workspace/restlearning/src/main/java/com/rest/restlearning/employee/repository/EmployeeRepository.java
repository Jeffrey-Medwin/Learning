package com.rest.restlearning.employee.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.rest.restlearning.employee.bean.Employee;
import com.rest.restlearning.employee.repository.util.DataBase;

public class EmployeeRepository {
	
	private final String tableName = "Rest_Learning";
	
	
	public boolean insertIntoEmployee(Employee employee) {

		final String insertQuery = "INSERT INTO " + tableName + " (name, salary) VALUES ('" + employee.getName() + "', '"
				+ employee.getSalary() + "')";
		boolean isInserted = false;

		try (
				Connection connection = DataBase.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			) {
			isInserted = preparedStatement.executeUpdate() > 0;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return isInserted;
	}
	
	public List<Employee> getAllEmployee() {
		
		final String selectQuery = "SELECT * FROM " + tableName;
		
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee;
		
		try (
				Connection connection = DataBase.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
				ResultSet resultSet = preparedStatement.executeQuery();
			) {
			while (resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getDouble("salary"));
				
				employees.add(employee);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} 
		
		return employees;
	}

	public Employee getEmployee(int id) {
		
		final String selectQuery = "SELECT * FROM " + tableName + " WHERE id='" + id + "'";
		
		Employee employee = null;
		
		try (
				Connection connection = DataBase.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
				ResultSet resultSet = preparedStatement.executeQuery();
			) {
			while (resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getDouble("salary"));
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return employee;
	}

	public String updateEmployee(Employee employee) {
		final String updateQuery = "UPDATE " + tableName + " SET name='" + employee.getName() + "', salary='"
				+ employee.getSalary() + "' WHERE id='" + employee.getId() + "'";
		
		boolean result = false;
		try (
				Connection connection = DataBase.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			){
			result = preparedStatement.executeUpdate() > 0;
			
			if (result) {
				return "Successfully updated " + employee.getId();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return "Cannot update " + employee.getId();
	}

	public String deleteEmployee(int id) {
		final String deleteQuery = "DELETE FROM " + tableName + " WHERE id='" + id + "'";
		
		boolean result = false;
		
		try (
				Connection connection = DataBase.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			) {
				result = preparedStatement.executeUpdate() > 0;
				
				if (result) {
					return "Successfully deleted " + id;
				}
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		
		return "Cannot update " + id;
	}
}
