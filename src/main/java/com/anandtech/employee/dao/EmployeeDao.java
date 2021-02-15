package com.anandtech.employee.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.anandtech.employee.domain.Employee;

@Component
public class EmployeeDao {

	private final String SAVE_EMPLOYEE = "INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PH_NUMBER, DOB) "
										+ "VALUES (:EMPLOYEE_ID, :FIRST_NAME, :LAST_NAME, :EMAIL, :PH_NUMBER, :DOB)";
	
	@Autowired
	private NamedParameterJdbcTemplate oracleJdbcTemplate;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void saveEmployee(Employee employee) {
		
		Map employeeParams = new HashMap();
		employeeParams.put("EMPLOYEE_ID", Integer.valueOf(employee.getEmployeeId()));
		employeeParams.put("FIRST_NAME", employee.getFirstName());
		employeeParams.put("LAST_NAME", employee.getLastName());
		employeeParams.put("EMAIL", employee.getEmail());
		employeeParams.put("PH_NUMBER", employee.getPhNumber());
		employeeParams.put("DOB", employee.getDob());

		oracleJdbcTemplate. update(SAVE_EMPLOYEE, employeeParams);
	}
}
