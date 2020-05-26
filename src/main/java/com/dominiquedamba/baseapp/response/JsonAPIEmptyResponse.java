/**
 * 
 */
package com.dominiquedamba.baseapp.response;

/**
 * @author dominiquedamba
 *
 */
public class JsonAPIEmptyResponse {

	private String message;
	private boolean status;

	public JsonAPIEmptyResponse(String message) {
		this.setMessage(message);
		this.setStatus(true);
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

}
