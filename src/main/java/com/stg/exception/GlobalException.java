package com.stg.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.stg.model.ResponseError;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = GeneralException.class)
	ResponseEntity<ResponseError> tellException(GeneralException generalException,
			HttpServletRequest httpServletRequest) {
		ResponseError responseError = new ResponseError(generalException.getMessage(),
				httpServletRequest.getRequestURI());

		return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
	}

}
