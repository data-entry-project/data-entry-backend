package com.example.dataentryproject.base.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.dataentryproject.base.dto.Response;
import com.example.dataentryproject.base.util.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@Autowired
	private Messages messages;

	@ExceptionHandler(value = { DataException.class })
	protected ResponseEntity<Response> handleCommonException(final DataException ex, final WebRequest request) {
		LOGGER.error("EXCEPTION:", ex);
		if (ex.getObject() == null) {

			return new ResponseEntity<Response>(createErrorResponse(ex.getHttpStatus().value(), ex.getMessage(), null),
					ex.getHttpStatus());
		} else {
			return new ResponseEntity<Response>(
					createErrorResponse(ex.getHttpStatus().value(), ex.getMessage(), ex.getObject()),
					ex.getHttpStatus());
		}

	}

	private Response createErrorResponse(int statusCode, String message, Object data) {
		return new Response(statusCode, message, data);

	}

}
