package net.pluriel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class PrincipalExceptionHandler {
	 @ExceptionHandler(RestException.class)
	    public ResponseEntity<RestExceptionResponse> handleSecurityException(RestException se) {
	        HttpStatus httpStatus = se.getHttpStatus();
	        RestExceptionResponse response = new RestExceptionResponse(
	                httpStatus.name(),
	                httpStatus.value(),
	                LocalDateTime.now(),
	                se.getMessage());
	        return new ResponseEntity<RestExceptionResponse>(response, httpStatus);
	    }
	 
	 @ExceptionHandler(NotFound.class)
	    public ResponseEntity<RestExceptionResponse> handleSecurityException(NotFound se) {
	        HttpStatus httpStatus = se.getHttpStatus();
	        RestExceptionResponse response = new RestExceptionResponse(
	                httpStatus.name(),
	                httpStatus.value(),
	                LocalDateTime.now(),
	                se.getMessage());
	        return new ResponseEntity<RestExceptionResponse>(response, httpStatus);
	    }
	 

}
