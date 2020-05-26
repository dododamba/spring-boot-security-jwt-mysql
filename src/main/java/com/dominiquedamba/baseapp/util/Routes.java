/**
 * 
 */
package com.dominiquedamba.baseapp.util;

/**
 * @author dominiquedamba
 *
 */

public interface Routes {

	public static final String CONTACT = "/api/contacts";
	public static final String CONNECTED_USER_CONTACT = "/connected";
	public static final String CONTACT_LIST = "/api/contactlists";
	public static final String ROLE_MAPPING = "/api/role";
	public static final String USER_MAPPING = "/api/user";
	public static final String LOGIN_MAPPING = "/api/contacts";
	public static final String REGISTER_MAPPING = "/api/contacts";
	public static final String LOGOUT_MAPPING = "/api/contacts";
	public static final String CONNECTED_USER_MAPPING = "/api/connect-user/{slug}";

	public static final String SEND_MESSAGE_MAPPING = "/send-message";
	public static final String TOPIC_MAPPING = "/api/topic-public";

	public static final String CREATE_MAPPING = "/create";
	public static final String SHOW_MAPPING = "/show{slug}";
	public static final String UPDATE_MAPPING = "/update/{slug}";
	public static final String DELETE_MAPPING = "/delete{slug}";
	public static final String SEARCH_MAPPING = "/search{name}";
	public static final String ADD_FRIEND_TO_MY_CONTACT_LIST = "/add-friend";

}
