package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.requestType;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import com.amazon.ask.model.interfaces.system.ExceptionEncounteredRequest;;

public class ExceptionOcurredRequestHandler implements RequestHandler {
	
	static final Logger logger = LoggerFactory.getLogger(ExceptionOcurredRequestHandler.class);
	
	public boolean canHandle(HandlerInput input) {
		return input.matches(requestType(ExceptionEncounteredRequest.class));
	}

	public Optional<Response> handle(HandlerInput input) {
		ExceptionEncounteredRequest request = (ExceptionEncounteredRequest)input.getRequestEnvelope().getRequest();
		logger.error("Error - Request: ", request.toString());
		logger.error("Error - type: ", request.getType().toString());
		logger.error("Error - error.type: ", request.getError().getType().toString());
		logger.error("Error - error.message: ", request.getError().getMessage());
		logger.error("Error - error: ", request.getError().toString());
		logger.error("Error - cause: ", request.getCause().toString());
		
		return input.getResponseBuilder().build();
	}
}