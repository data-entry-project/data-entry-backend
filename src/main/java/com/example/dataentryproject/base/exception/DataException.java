package com.example.dataentryproject.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class DataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5278905422110706025L;

	/**
	 * Status Code.
	 */
	private HttpStatus httpStatus;

	/**
	 * Response message.
	 */
	private String message;

	/** Response Object. */
	private Object object;

	public DataException(HttpStatus httpStatus, String message, Object object) {
		super(message);
		this.httpStatus = httpStatus;
		this.message = message;
		this.object = object;
	}

	/**
	 * Set message.
	 * 
	 * @param message {@link String}
	 */
	public DataException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * Set statusCode, message and cause.
	 * 
	 * @param httpStatus {@link HttpStatus}
	 * @param message    {@link String}
	 */
	public DataException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
		this.message = message;
	}

	/**
	 * Return the httpStatus.
	 * 
	 * @return the httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * Return the message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set the value of httpStatus.
	 * 
	 * @param httpStatus the httpStatus to set
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	/**
	 * Set the value of message.
	 * 
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * To get.
	 * 
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * To set.
	 * 
	 * @param object the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}

}
