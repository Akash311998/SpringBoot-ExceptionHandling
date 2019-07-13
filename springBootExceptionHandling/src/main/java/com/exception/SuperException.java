package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SuperException {

	@ExceptionHandler(value = PersonAlreadyExists.class)
	public ResponseEntity<ExceptionResponse> personAlreadyExist() {
		return new ResponseEntity<ExceptionResponse>(new ExceptionResponse("Student Already Exists", "CONFLICT"),
				HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = PersonNotFound.class)
	public ResponseEntity<ExceptionResponse> personNotFound() {
		return new ResponseEntity<ExceptionResponse>(new ExceptionResponse("Student Not Found", "NOT FOUND"),
				HttpStatus.NOT_FOUND);
	}

}
