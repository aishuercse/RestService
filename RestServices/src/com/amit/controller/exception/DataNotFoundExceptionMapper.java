/*
 * We need to either keep these exception classes in controller package
 * or sub-package of controller. Because controller package is registered
 * with jersey, if we keep exception classes in different package then 
 * Jersey can't recognize the exception mapper classes.
 */
package com.amit.controller.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.amit.model.ErrorMessage;

/**
 * @author amit
 * Exception mapper class for data not found exception. 
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	/**
	 * Return response with status code and error message.
	 * @author amit
	 * @param exception
	 * @return response
	 */
	@Override
	public Response toResponse(DataNotFoundException exception) {
		/* Since this is our custom class so creating custom messages
		 * with status code - 8**, to avoid confusion with HTTP status codes.
		 */
		ErrorMessage errorMessage= new ErrorMessage(804, exception.getMessage());
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
