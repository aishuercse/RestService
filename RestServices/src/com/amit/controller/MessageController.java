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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

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
	
	/**
	 * Invoke get request to retrieve all messages and based on author name.
	 * This method also accepts query param also. Because we can't keep two
	 * get requests for same resource URI and query param does not play any
	 * role in URI construction.
	 * @param authorName
	 * @param uriInfo
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MessageResource> getMessages(@QueryParam("author") String authorName, @Context UriInfo uriInfo) {
		List<MessageResource> messagesList = new ArrayList<MessageResource>();
		String urlPath = uriInfo.getAbsolutePath().toString();
		try {
			MessageService messageService = new MessageServiceImpl();
			if (authorName != null) {
				messagesList = messageService.getMessages(authorName, urlPath);
			} else {
				messagesList = messageService.getMessages(urlPath);
			}
		} catch (Exception e) {
			logger.error("error occurred while trying to access message list: " + e.getMessage());
		}
		logger.debug("Returning message list from controller");
		return messagesList;
	}
	
	/**
	 * Get and return message based on message id
	 * @param id
	 * @param uriInfo
	 * @return
	 */
	@Path("/{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getMessage(@PathParam("messageId") int id, @Context UriInfo uriInfo) {
		MessageResource messageResource = null;
		try {
			MessageService messageService = new MessageServiceImpl();
			messageResource = messageService.getMessage(id);
			String url= uriInfo.getAbsolutePath().toString();
			messageResource.addLink(url, "self");
		} catch (Exception e) {
			logger.info("Error while retrieved message based on message id: " + e.getMessage());
		}
		return Response.status(Status.CREATED).entity(messageResource).build();
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
	 * @param uriInfo
	 * @return MessageResource
	 */
	@Path("/{messageId}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMessage(@PathParam("messageId") int messageId, MessageResource messageResource,
			@Context UriInfo uriInfo) {
		MessageResource updatedMessageResource = null;
		String url = uriInfo.getAbsolutePath().toString();
		try {
			MessageService messageService = new MessageServiceImpl();
			messageService.updateMessage(messageId, messageResource);
			updatedMessageResource = messageService.getMessage(messageId);
			updatedMessageResource.addLink(url, "self");
		} catch (Exception e) {
			logger.error("error occurred while updating message in DB: " + e.getMessage());
		}
		return Response.status(Status.CREATED).entity(updatedMessageResource).build();
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
			logger.error("error occurred while deleting record: "+e.getMessage());
			response = "Error occurred while deleting message";
		}
		return response;
	}
	
	/**
	 * Getting URI info using context
	 * @param uriInfo
	 * @return
	 */
	@GET
	@Path("/context")
	public String getParamUsingContext(@Context UriInfo uriInfo)
	{
		String path= uriInfo.getAbsolutePath().toString();
		return path;
	}
}
