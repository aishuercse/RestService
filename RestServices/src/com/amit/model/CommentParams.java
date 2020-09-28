package com.amit.model;

import javax.ws.rs.QueryParam;

/**
 * @author amit
 * Bean param class for comments
 */
public class CommentParams {

	private @QueryParam("commentId") int commentId;
	private @QueryParam("author") String author;
	/**
	 * @return the commentId
	 */
	public int getCommentId() {
		return commentId;
	}
	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
