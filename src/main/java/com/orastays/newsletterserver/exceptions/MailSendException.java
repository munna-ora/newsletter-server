package com.orastays.newsletterserver.exceptions;

public class MailSendException extends Exception {

	private static final long serialVersionUID = -4353411905072544051L;
	private String name;

	public MailSendException(String name) {
		super(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}