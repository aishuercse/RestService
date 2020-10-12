/*
 * We need to either keep these exception classes in controller package
 * or sub-package of controller. Because controller package is registered
 * with jersey, if we keep exception classes in different package then 
 * Jersey can't recognize the exception mapper classes.
 */
package com.amit.controller.exception;

/**
 * @author amit
 * Exception class to handle response if data is not found.
 */
public class DataNotFoundException extends RuntimeException {

	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException()
	{
		
	}

	public DataNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
