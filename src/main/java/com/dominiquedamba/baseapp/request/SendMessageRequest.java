/**
 * 
 */
package com.dominiquedamba.baseapp.request;

/**
 * @author dominiquedamba
 *
 */
public class SendMessageRequest {
	private String senderSlug;
	private String receiverSlug;
	private String contentMessage;

	/**
	 * @return the senderSlug
	 */
	public String getSenderSlug() {
		return senderSlug;
	}

	/**
	 * @param senderSlug the senderSlug to set
	 */
	public void setSenderSlug(String senderSlug) {
		this.senderSlug = senderSlug;
	}

	/**
	 * @return the receiverSlug
	 */
	public String getReceiverSlug() {
		return receiverSlug;
	}

	/**
	 * @param receiverSlug the receiverSlug to set
	 */
	public void setReceiverSlug(String receiverSlug) {
		this.receiverSlug = receiverSlug;
	}

	/**
	 * @return the contentMessage
	 */
	public String getContentMessage() {
		return contentMessage;
	}

	/**
	 * @param contentMessage the contentMessage to set
	 */
	public void setContentMessage(String contentMessage) {
		this.contentMessage = contentMessage;
	}

}
