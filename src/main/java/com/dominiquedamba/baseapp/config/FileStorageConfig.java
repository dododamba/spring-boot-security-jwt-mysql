/**
 * 
 */
package com.dominiquedamba.baseapp.config;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author dominique
 *
 */

@ConfigurationProperties(prefix = "storage")
public class FileStorageConfig {

	/**
	 * Folder location for storing files
	 */
	private String location = "upload-dir";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
