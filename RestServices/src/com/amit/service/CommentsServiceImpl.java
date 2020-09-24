package com.amit.service;

import java.sql.SQLException;
import java.util.List;

import com.amit.dao.CommentsDao;
import com.amit.dao.CommentsDaoImpl;
import com.amit.model.CommentResource;

public class CommentsServiceImpl implements CommentsService {

	/**
	 * Service layer to interact with DAO layer to get comments
	 * @author amit
	 * @param messageId
	 * @return comments list
	 * @throws SQLException
	 */
	@Override
	public List<CommentResource> getComments(int messageId) throws SQLException {
		CommentsDao commentsDao = new CommentsDaoImpl();
		return commentsDao.getComments(messageId);
	}

	/**
	 * @author amit
	 * @param messageId
	 * @param commentId
	 * @return comment
	 * @throws SQLException
	 */
	@Override
	public CommentResource getComment(int messageId, int commentId) throws SQLException {
		CommentsDao commentDao = new CommentsDaoImpl();
		return commentDao.getComment(messageId, commentId);
	}

	/**
	 * @author amit
	 * @param commentResource
	 */
	@Override
	public void addComment(CommentResource commentResource) throws SQLException {
		CommentsDao commentDao = new CommentsDaoImpl();
		commentDao.addComment(commentResource);
	}

	/**
	 * @author amit
	 * @param commentId
	 * @param commentResource
	 */
	@Override
	public void updateComment(int commentId, CommentResource commentResource) throws SQLException {
		CommentsDao commentDao = new CommentsDaoImpl();
		commentDao.updateComment(commentId, commentResource);
	}

	/**
	 * @author amit
	 * @param messageId
	 * @param commentId
	 */
	@Override
	public void deleteComment(int messageId, int commentId) throws SQLException {
		CommentsDao commentDao = new CommentsDaoImpl();
		commentDao.deleteComment(messageId, commentId);
	}

}
