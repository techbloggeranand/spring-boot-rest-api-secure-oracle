package com.anandtech.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anandtech.employee.domain.Employee;
import com.anandtech.employee.restrequests.ServiceResponse;
import com.anandtech.employee.service.IEmployeeService;

@RestController
@RequestMapping("employee-service/api/v1")
public class EmployeeController {
	
	@Autowired
	IEmployeeService service;

	@PostMapping(value="/journal/employees", consumes = "application/json", produces = "application/json")
	public ServiceResponse createEmployee(@RequestBody Employee employee) {
		service.createEmployee(employee);
		return ServiceResponse.getSuccessResponse();
	}
}
