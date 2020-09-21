package com.amit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amit.model.MessageResource;
import com.amit.service.MessageService;
import com.amit.service.MessageServiceImpl;

/**
 * @author amit
 * Rest controller for message service application.
 */
@Path("/messages")
public class MessageController {
	
	private static Log logger = LogFactory.getLog(MessageController.class);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MessageResource> getMessages() {
		List<MessageResource> messagesList = new ArrayList<MessageResource>();
		try {
			MessageService messageService = new MessageServiceImpl();
			messagesList = messageService.getMessages();
		} catch (Exception e) {
			logger.error("error occurred while trying to access message list: " + e.getMessage());
		}
		logger.debug("Returning message list from controller");
		return messagesList;
	}
	
	/**
	 * Get and return message based on message id
	 * @param id
	 * @return
	 */
	@Path("/{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public MessageResource getMessage(@PathParam("messageId") int id) {
		MessageResource messageResource = null;
		try {
			MessageService messageService = new MessageServiceImpl();
			messageResource = messageService.getMessage(id);
		} catch (Exception e) {
			logger.info("Error while retrieved message based on message id: " + e.getMessage());
		}
		return messageResource;
	}
}
