package com.amit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
	
	/**
	 * Create a new message using rest service.
	 * @param messageResource
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createMessage(MessageResource messageResource) {
		String message = "";
		try {
			MessageService messageService = new MessageServiceImpl();
			messageService.addMessage(messageResource);
			message = "Message added successfully";
		} catch (Exception e) {
			logger.error("error occurred while creating a new message: " + e.getMessage());
			message = "Error occurred while adding message";
		}
		return message;
	}
	
	/**
	 * Add new message using xml type request
	 * @param messageResource
	 * @return
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_XML)
	public String createMessageByXML(MessageResource messageResource) {
		String message = "";
		try {
			MessageService messageService = new MessageServiceImpl();
			messageService.addMessage(messageResource);
			message = "Message added successfully";
		} catch (Exception e) {
			logger.error("error occurred while creating a new message: " + e.getMessage());
			message = "Error occurred while adding message";
		}
		return message;
	}
	
	/**
	 * Update message in DB and return the updated message to the user.
	 * @param messageId
	 * @param messageResource
	 * @return MessageResource
	 */
	@Path("/{messageId}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MessageResource updateMessage(@PathParam("messageId") int messageId, MessageResource messageResource) {
		MessageResource updatedMessageResource = null;
		try {
			MessageService messageService = new MessageServiceImpl();
			messageService.updateMessage(messageId, messageResource);
			updatedMessageResource = messageService.getMessage(messageId);
		} catch (Exception e) {
			logger.error("error occurred while updating message in DB");
		}
		return updatedMessageResource;
	}
	
	/**
	 * Delete message based on message id
	 * @param messageId
	 * @return
	 */
	@Path("/{messageId}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMessage(@PathParam("messageId") int messageId) {
		String response = "";
		try {
			MessageService messageService = new MessageServiceImpl();
			messageService.deleteMessage(messageId);
			response = "Message deleted successfully";
		} catch (Exception e) {
			logger.error("error occurred while deleting record");
			response = "Error occurred while deleting message";
		}
		return response;
	}
}
