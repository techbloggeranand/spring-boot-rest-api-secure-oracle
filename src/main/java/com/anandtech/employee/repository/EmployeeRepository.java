package com.anandtech.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anandtech.employee.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	
}
