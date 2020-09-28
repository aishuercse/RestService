package com.amit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
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

import com.amit.model.CommentParams;
import com.amit.model.CommentResource;
import com.amit.service.CommentsService;
import com.amit.service.CommentsServiceImpl;

@Path("/messages")
public class CommentsController {
	
	private static Log logger = LogFactory.getLog(CommentsController.class);

	/**
	 * Rest end point to get list of comments for a message
	 * @author amit
	 * @param messageId comments list
	 * @return
	 */
	@Path("/{messageId}/comments")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CommentResource> getComments(@PathParam("messageId") int messageId, @BeanParam CommentParams params) {
		List<CommentResource> commentsList = new ArrayList<CommentResource>();
		try {
			CommentsService commentsService = new CommentsServiceImpl();
			// By default bean param will have default values of parameters.
			if (params != null && params.getAuthor() != null) {
				CommentResource commentResource = commentsService.getComment(params.getCommentId(), params.getAuthor());
				commentsList.add(commentResource);
			} else {
				commentsList = commentsService.getComments(messageId);
			}
		} catch (Exception e) {
			logger.error("Error occurred while retrieving comments");
		}
		return commentsList;
	}
	
	/**
	 * Rest end point to get comment based on message id and comment id
	 * @author amit
	 * @param messageId
	 * @param commentId
	 * @return comment
	 */
	@Path("/{messageId}/comments/{commentId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CommentResource getComments(@PathParam("messageId") int messageId, @PathParam("commentId") int commentId) {
		CommentResource commentResource = new CommentResource();
		try {
			CommentsService commentsService = new CommentsServiceImpl();
			commentResource = commentsService.getComment(messageId, commentId);
		} catch (Exception e) {
			logger.error("Error occurred while retrieving comments");
		}
		return commentResource;
	}
	
	/**
	 * Rest end point to create new comment
	 * @param commentResource
	 * @return response
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{messageId}/comments")
	public String addComment(CommentResource commentResource) {
		String response = null;
		try {
			CommentsService commentService = new CommentsServiceImpl();
			commentService.addComment(commentResource);
			response = "Comment added successfully";
		} catch (Exception e) {
			logger.error("error occurred while adding new comment");
			response = "error occurred while adding new comment";
		}
		return response;
	}
	
	/**
	 * Rest endpoint to update comment
	 * @author amit
	 * @param commentId
	 * @param commentResource
	 * @return comment resource
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{messageId}/comments/{commentId}")
	public CommentResource updateComment(@PathParam("messageId") int messageId, @PathParam("commentId") int commentId, CommentResource commentResource) {
		CommentResource updatedcommentResource = new CommentResource();
		try {
			CommentsService commentService = new CommentsServiceImpl();
			commentService.updateComment(commentId, commentResource);
			updatedcommentResource = commentService.getComment(messageId, commentId);
		} catch (Exception e) {
			logger.error("error occurred while updating the comment");
		}
		return updatedcommentResource;
	}
	
	/**
	 * Rest end point to delete comment
	 * @param messageId
	 * @param commentId
	 * @return response
	 */
	@Produces(MediaType.TEXT_PLAIN)
	@DELETE
	@Path("/{messageId}/comments/{commentId}")
	public String deleteComment(@PathParam("messageId") int messageId, @PathParam("commentId") int commentId) {
		String response = null;
		try {
			CommentsService commentService = new CommentsServiceImpl();
			commentService.deleteComment(messageId, commentId);
			response = "comment deleted successfully";
		} catch (Exception e) {
			logger.error("error occurred while deleting record");
			response = "error occurred while deleting record";
		}
		return response;
	}
}
