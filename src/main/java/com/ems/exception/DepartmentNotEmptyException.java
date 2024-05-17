package com.ems.exception;

public class DepartmentNotEmptyException extends RuntimeException {
	public DepartmentNotEmptyException(String message) {
        super(message);
    }
}
