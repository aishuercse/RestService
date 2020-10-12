/*
 * We need to either keep these exception classes in controller package
 * or sub-package of controller. Because controller package is registered
 * with jersey, if we keep exception classes in different package then 
 * Jersey can't recognize the exception mapper classes.
 */
package com.amit.controller.exception;

/**
 * @author amit
 * Exception class to handle all kind of unknown errors. Like 
 * error occurred while connecting to database. 
 */
public class SystemError extends RuntimeException {

	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = 1L;

	public SystemError()
	{
		
	}
	
	public SystemError(String message)
	{
		super(message);
	}
}
