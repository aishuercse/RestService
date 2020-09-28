package com.amit.service;

import java.sql.SQLException;
import java.util.List;

import com.amit.model.CommentResource;

public interface CommentsService {

	public List<CommentResource> getComments(int messageId) throws SQLException;

	public CommentResource getComment(int messageId, int commentId) throws SQLException;

	public void addComment(CommentResource commentResource) throws SQLException;

	public void updateComment(int commentId, CommentResource commentResource) throws SQLException;

	public void deleteComment(int messageId, int commentId) throws SQLException;
	
	public CommentResource getComment(int commentId, String author) throws SQLException;
}
