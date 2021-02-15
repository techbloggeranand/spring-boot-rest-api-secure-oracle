package com.anandtech.employee.domain;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
 
public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phNumber;
    
	@JsonFormat(pattern="MM-dd-yyyy")
    private LocalDate dob;
    

    @Positive(message = "ERR003:employee id must be a number")
    @NotNull(message = "ERR001:employee id is mandatory")
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
    @NotNull(message = "ERR002:email is mandatory")
    @Email(message = "ERR004:email format must be like abc@def.com")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phNumber=" + phNumber + ", dob=" + dob + "]";
	}
    
        
}
