package com.dominiquedamba.baseapp.request;

import javax.validation.constraints.NotBlank;

public class GetConnectedUserRequest {

	@NotBlank
	private String slug;

	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

}
