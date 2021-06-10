package com.cts.training.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * This is ApiError Response for formatting the error to a certain format.
 */
public class ApiErrorResponse {

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLocalizedMessage() {
		return localizedMessage;
	}

	public void setLocalizedMessage(String localizedMessage) {
		this.localizedMessage = localizedMessage;
	}

	private HttpStatus httpStatus;

	private String message;

	private String localizedMessage;

	/**
	 * This is ApiErrorResponse constructor
	 */
	public ApiErrorResponse() {
	}

	/**
	 * This is ApiErrorResponse constructor 
	 * @param httpStatus
	 */
	public ApiErrorResponse(HttpStatus httpStatus) {
		this();
		this.httpStatus = httpStatus;
	}

	/**
	 * This is ApiErrorResponse constructor
	 * @param httpStatus
	 * @param throwable
	 */
	public ApiErrorResponse(HttpStatus httpStatus, Throwable throwable) {
		this();
		this.httpStatus = httpStatus;
		this.message = "Unexpected error in the request";
		this.localizedMessage = throwable.getLocalizedMessage();
	}

	/**
	 * This is ApiErrorResponse constructor
	 * @param httpStatus
	 * @param message
	 * @param throwable
	 */
	public ApiErrorResponse(HttpStatus httpStatus, String message, Throwable throwable) {
		this();
		this.httpStatus = httpStatus;
		this.message = message;
		this.localizedMessage = throwable.getLocalizedMessage();
	}
}