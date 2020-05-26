/**
 * 
 */
package com.dominiquedamba.baseapp.exception;

/**
 * @author dominique
 *
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFoundException extends RuntimeException {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -6829576326700490381L;

	public MyFileNotFoundException(String message) {
	        super(message);
	    }

	    public MyFileNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }
 
}
