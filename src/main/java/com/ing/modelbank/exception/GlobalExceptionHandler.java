package com.ing.modelbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)

	public ResponseEntity<ResponseError> globalExceptionHandler(Exception exception) {

		ResponseError ResponseDto = new ResponseError(exception.getMessage(), HttpStatus.BAD_REQUEST.value());

		ResponseDto.setMessage(exception.getMessage());

		return new ResponseEntity<>(ResponseDto, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = { AccountNotFoundException.class })
	public ResponseEntity<ResponseError> ageException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

}