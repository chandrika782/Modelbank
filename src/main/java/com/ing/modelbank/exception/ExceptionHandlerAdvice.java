package com.ing.modelbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ing.modelbank.entity.ErrorReponse;


@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	private ResponseEntity<ErrorReponse> handleAllExceptions(Exception ex) {
		ErrorReponse errorResponse = new ErrorReponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PasswordMissMatchException.class)
	private ResponseEntity<ErrorReponse> handleExceptions(PasswordMissMatchException ex) {
		ErrorReponse errorResponse = new ErrorReponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
}