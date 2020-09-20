package com.amit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.amit.model.MessageResource;

/**
 * @author amit
 * Rest controller for message services
 */
@Path("/messages")
public class MessageController {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<MessageResource> getMessages()
	{
		MessageResource messageResource1= new MessageResource(1, "first message", "author1"); 
		MessageResource messageResource2= new MessageResource(2, "second message", "author2"); 
		List<MessageResource> messagesList= new ArrayList<>(); 
		messagesList.add(messageResource1);
		messagesList.add(messageResource2); 
		return messagesList;
	}
}
