package com.cognizant.moviecruiser.dao;

@SuppressWarnings("serial")
public class FavoriteEmptyException extends Exception {
	String message;

	public FavoriteEmptyException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
