package com.naufar.demo.util;

public class ApiResponse {

	private String responseCode;
	private String message;
	private Object responseData;
	
	public ApiResponse(String responseCode) {
		super();
		this.responseCode = responseCode;
	}

	public ApiResponse(String responseCode, String message) {
		super();
		this.responseCode = responseCode;
		this.message = message;
	}

	public ApiResponse(String responseCode, String message, Object responseData) {
		super();
		this.responseCode = responseCode;
		this.message = message;
		this.responseData = responseData;
	}
	
	

	public ApiResponse(String responseCode, Object responseData) {
		super();
		this.responseCode = responseCode;
		this.responseData = responseData;
	}

	public ApiResponse() {
		super();
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Response [responseCode=").append(responseCode)
					.append(", message=").append(message).append(", responseData=").append(responseData).append("]");
		
		return sb.toString();
	}
	
	
	
}
