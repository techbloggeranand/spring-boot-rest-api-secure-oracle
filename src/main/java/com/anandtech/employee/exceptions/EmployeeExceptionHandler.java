package com.anandtech.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.anandtech.employee.restrequests.ServiceResponse;
import com.anandtech.employee.util.Constants;

@ControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(value = EmployeeValidationException.class)
	protected ResponseEntity<ServiceResponse> handleEmployeeValidationException(EmployeeValidationException ex) {
		return new ResponseEntity<ServiceResponse>(
				ServiceResponse.getFailureResponse(ex.getErrorCode(), ex.getErrorMessage()),
				HttpStatus.OK);
	}

	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<ServiceResponse> handleGeneralException(Exception ex) {
		return new ResponseEntity<ServiceResponse>(
				ServiceResponse.getFailureResponse(Constants.GENERIC_ERROR_CODE, ex.getMessage()),
				HttpStatus.OK);
	}

}
