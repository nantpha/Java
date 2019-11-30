package com.fedx.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DllCommitResponse {

	private boolean isSuccess;
	private String message;
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
