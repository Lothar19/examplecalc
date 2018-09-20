package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.requestType;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.SessionEndedRequest;

public class SessionEndedRequestHandler implements RequestHandler {

	static final Logger logger = LoggerFactory.getLogger(SessionEndedRequestHandler.class);

	public boolean canHandle(HandlerInput input) {
		return input.matches(requestType(SessionEndedRequest.class));
	}

	public Optional<Response> handle(HandlerInput input) {
		logger.info("SessionEndedRequest received");
		SessionEndedRequest request = ((SessionEndedRequest) input.getRequestEnvelope().getRequest());
		if ((request != null) && (request.getError() != null) && request.getError().getMessage() != null) {
			logger.info("Received session ended error: " + request.getError().getMessage());
		}
		if ((request != null) && (request.getError() != null) && request.getError().getType() != null) {
			logger.info("Error type: " + request.getError().getType().toString());
		}
		return input.getResponseBuilder().build();
	}
}
