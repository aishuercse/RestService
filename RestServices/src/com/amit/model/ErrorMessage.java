
package com.amit.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author amit
 * Class to create error message in case of exception
 */
@XmlRootElement
public class ErrorMessage {

	private int errorCode;
	private String errorMessage;
	
	public ErrorMessage()
	{
		
	}
	/**
	 * @author amit
	 * @param errorCode
	 * @param errorMessage
	 */
	public ErrorMessage(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
