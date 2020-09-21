package com.amit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.amit.dao.MessageDao;
import com.amit.dao.MessageDaoImpl;
import com.amit.model.MessageResource;

/**
 * @author amit
 * Implementation class for message service.
 */
public class MessageServiceImpl implements MessageService {
	
	private static Log logger = LogFactory.getLog(MessageService.class);

	/**
	 * Interact with DB and retrieve all messages.
	 * @author amit
	 * @return message resources
	 * @throws SQLException 
	 */
	@Override
	public List<MessageResource> getMessages() throws SQLException {
		MessageDao messageDao = new MessageDaoImpl();
		List<MessageResource> messageList = messageDao.getMessages();
		logger.info("Retrieved total messages: " + messageList.size());
		return messageList;
	}

	/**
	 * Interact with DB and get message based on message id.
	 * @author amit
	 * @param id
	 * @return message
	 * @throws SQLException 
	 */
	@Override
	public MessageResource getMessage(int id) throws SQLException {
		MessageDao messageDao = new MessageDaoImpl();
		MessageResource messageResource = messageDao.getMessage(id);
		return messageResource;
	}

}
