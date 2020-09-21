package com.amit.dao;

import java.sql.SQLException;
import java.util.List;

import com.amit.model.MessageResource;

/**
 * @author amit
 * Dao interface for message.
 */
public interface MessageDao {

	public List<MessageResource> getMessages() throws SQLException;

	public MessageResource getMessage(int id) throws SQLException;
	
	public void addMessage(MessageResource messageResource);

}
