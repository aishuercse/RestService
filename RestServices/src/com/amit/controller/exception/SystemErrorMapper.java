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
 * Exception mapper for system errors.
 */
@Provider
public class SystemErrorMapper implements ExceptionMapper<SystemError> {

	@Override
	public Response toResponse(SystemError exception) {
		ErrorMessage errorMessage = new ErrorMessage(805, exception.getMessage());
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

}