package com.employee.exceptions;

import javax.naming.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import io.jsonwebtoken.JwtException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ApiError> handleUsernameNotFounndException(UsernameNotFoundException ex){
		ApiError apiError = new ApiError("Username not found with username : "+ex.getMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiError>(apiError,apiError.getStatusCode());
	}
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException ex){
		ApiError apiError = new ApiError("Authentication Failed : "+ex.getMessage(), HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<ApiError>(apiError,apiError.getStatusCode());
	}
	
	@ExceptionHandler(JwtException.class)
	public ResponseEntity<ApiError> handleJwtException(JwtException ex){
		ApiError apiError = new ApiError("Invalid JWT Token : "+ex.getMessage(), HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<ApiError>(apiError,apiError.getStatusCode());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleGenericException(Exception ex){
		ApiError apiError = new ApiError("An unexpected error occured! : "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ApiError>(apiError,apiError.getStatusCode());
	}

}
