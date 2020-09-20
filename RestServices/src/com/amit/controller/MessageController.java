package com.amit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author amit
 * Rest controller for message services
 */
@Path("/messages")
public class MessageController {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage()
	{
		return "Hello world";
	}
}
