package com.health.service.exceptions;

import lombok.ToString;

public class RecordModificationException extends RuntimeException {
	String msg;

	public RecordModificationException() {
		// TODO Auto-generated constructor stub
	}

	public RecordModificationException(String message) {
		this.msg = msg;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "RecordModificationException ";
	}

}
