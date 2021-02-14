package com.anandtech.employee.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anandtech.employee.domain.Employee;
import com.anandtech.employee.exceptions.EmployeeValidationException;
import com.anandtech.employee.repository.EmployeeRepository;
import com.anandtech.employee.util.Constants;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee createEmployee(Employee emp) {
		validate(emp);
		employeeRepository.save(emp);
		return emp;
	}
	
	public void validate(Employee emp) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Employee>> violations = validator.validate(emp);
		
		if(!violations.isEmpty()) {
			for (ConstraintViolation<Employee> violation : violations) {
			    String[] messageParts = violation.getMessage().split(Constants.COLON);
			    throw new EmployeeValidationException(messageParts[0], messageParts[1]);
			}
		}
	}
}
