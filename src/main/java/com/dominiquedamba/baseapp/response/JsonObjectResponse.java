/**
 * 
 */
package com.dominiquedamba.baseapp.response;

/**
 * @author dominiquedamba
 *
 */
public class JsonObjectResponse {
	private boolean status;
	private String message;
	private Object _embeded;

	/**
	 * @param status
	 * @param message
	 * @param _embeded
	 */
	public JsonObjectResponse(boolean status, String message, Object _embeded) {
		this.setStatus(status);
		this.setMessage(message);
		this.set_embeded(_embeded);
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
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
	 * @return the _embeded
	 */
	public Object get_embeded() {
		return _embeded;
	}

	/**
	 * @param _embeded the _embeded to set
	 */
	public void set_embeded(Object _embeded) {
		this._embeded = _embeded;
	}

}
