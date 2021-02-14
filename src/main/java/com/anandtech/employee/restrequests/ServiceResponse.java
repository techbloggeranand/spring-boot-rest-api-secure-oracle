package com.anandtech.employee.restrequests;

import com.anandtech.employee.util.Constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse {

	private String status;
	private String errorCode;
	private String errorMessage;
	
	public static ServiceResponse getSuccessResponse() {
		return new ServiceResponse(Constants.STATUS_SUCCESS, null, null);
	}
	
	public static ServiceResponse getFailureResponse(String errorCode, String errorMessage) {
		return new ServiceResponse(null, errorCode, errorMessage);
	}
}
