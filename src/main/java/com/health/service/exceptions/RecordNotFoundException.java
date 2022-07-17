package com.health.service.exceptions;

public class RecordNotFoundException extends RuntimeException {

	String msg;
	public RecordNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public RecordNotFoundException(String arg0) {
		this.msg=arg0;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Record not Found with given id";
	}

}
