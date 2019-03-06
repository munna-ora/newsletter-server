package com.orastays.newsletterserver.exceptions;

public class EmptyValueException extends Exception {

	
	private static final long serialVersionUID = 5665113550143664217L;
	private String name;

	public EmptyValueException(String name) {
		super(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}