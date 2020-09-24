package org.com.capg.healthcare.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TestNotFoundException extends Exception{
	public TestNotFoundException(String s) {
		super(s);
	}
}
