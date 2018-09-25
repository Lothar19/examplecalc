package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.requestType;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Context;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.audioplayer.PlaybackStoppedRequest;

public class PlaybackStoppedRequestHandler implements RequestHandler {
	
	static final Logger logger = LoggerFactory.getLogger(PlaybackStoppedRequestHandler.class);

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(requestType(PlaybackStoppedRequest.class));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		logger.info("User ID: " + ((Context)input.getContext().get()).getSystem().getUser().getUserId());
		logger.info("Offset: " + ((PlaybackStoppedRequest)input.getRequestEnvelope().getRequest()).getOffsetInMilliseconds().toString());
		logger.info("Token: " + ((PlaybackStoppedRequest)input.getRequestEnvelope().getRequest()).getToken());
		return null;
	}
}