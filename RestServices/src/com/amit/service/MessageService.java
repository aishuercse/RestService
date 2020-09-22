package com.amit.service;

import java.sql.SQLException;
import java.util.List;

import com.amit.model.MessageResource;

/**
 * @author amit
 * Service interface for message related business operations.
 */
public interface MessageService {

	public List<MessageResource> getMessages() throws SQLException;

	public MessageResource getMessage(int id) throws SQLException;
	
	public void addMessage(MessageResource messageResource) throws SQLException;
	
	public void updateMessage(int id, MessageResource messageResource) throws SQLException;
}
