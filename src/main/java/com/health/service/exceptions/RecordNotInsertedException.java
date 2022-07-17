package com.health.service.exceptions;

public class RecordNotInsertedException extends RuntimeException {
	String msg;

	public RecordNotInsertedException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "record not inserted";
	}

}
