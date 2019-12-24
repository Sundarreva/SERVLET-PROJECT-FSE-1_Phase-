package com.cognizant.moviecruiser.dao;

public class SystemException extends Exception {
	private static final long serialVersionUID = 1L;
	String msg;

	public SystemException(int errorCode, String errorMsg) {
		super();
		this.msg = "Error message: " + errorMsg + " Error code: " + errorCode;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
