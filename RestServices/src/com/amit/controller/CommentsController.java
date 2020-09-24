package com.amit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/messages")
public class CommentsController {

	@Path("/{messageId}/comments")
	@GET
	public String getComments()
	{
		return "comments rest end point invoked";
	}
}
