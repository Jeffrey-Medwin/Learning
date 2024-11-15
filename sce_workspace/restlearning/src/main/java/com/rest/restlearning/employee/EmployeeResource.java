package com.rest.restlearning.employee;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.rest.restlearning.employee.bean.Employee;
import com.rest.restlearning.employee.repository.EmployeeRepository;

@Path("employee")
public class EmployeeResource {
	EmployeeRepository employeeRepository = new EmployeeRepository();
	
	
	// This method only creates new records and not for update any records
	@POST
	@Path("add")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String insert(Employee employee) {
		boolean result = employeeRepository.insertIntoEmployee(employee);
		return (result == true) ? "Successfully Inserted " + employee.getName() : "Cannot insert " + employee.getName();
	}
	
	
	// This method gets all the records
	@GET
	@Path("getall")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Employee> get() {

		List<Employee> employees = employeeRepository.getAllEmployee();

		if (employees.isEmpty()) {
			System.out.println("empty");
		}

		return employees;
	}
	
	
	// This method gets only the required record
	@GET
	@Path("get{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Employee get(@PathParam("id") int id) {
		
		Employee employee = employeeRepository.getEmployee(id);
				
		return employee;
	}
	
	
	// This method is only used to update the existing records
	@PUT
	@Path("update")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String update(Employee employee) {
		
		String result = employeeRepository.updateEmployee(employee);
		
		return result;
	}
	
	
	// This method is used to delete the record
	@DELETE
	@Path("delete{id}")
	@Produces("text/plain")
	public String delete(@PathParam("id") int id) {
		String result = "ID not found";
		
		if (employeeRepository.getEmployee(id) != null)
			result = employeeRepository.deleteEmployee(id);
		
		return result;
	}
}
