package com.cognizant.truyum.dao;

public class SystemException extends Exception {
	String msg;

	public SystemException(int errorcode, String errormsg) {
		super();
		this.msg = "Error message: " + errormsg + " Errorcode: " + errorcode;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
