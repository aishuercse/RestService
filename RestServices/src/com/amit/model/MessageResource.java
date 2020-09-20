package com.amit.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author amit
 * Bean class to maintain all messages details.
 */
@XmlRootElement
public class MessageResource {

	private int id;
	private String Message;
	private String author;
	private Date postedDate;
	/**
	 * Default constructor
	 */
	public MessageResource() {
		super();
	}
	
	/**
	 * Constructor using fields
	 * @param id
	 * @param message
	 */
	public MessageResource(int id, String message, String author)
	{
		this.id= id;
		this.Message= message;
		this.author= author;
		this.postedDate= new Date();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return Message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		Message = message;
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

	/**
	 * @return the postedDate
	 */
	public Date getPostedDate() {
		return postedDate;
	}

	/**
	 * @param postedDate the postedDate to set
	 */
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
}
