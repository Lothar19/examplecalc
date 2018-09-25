package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.drc.alexa.frases1.model.AmazonIntentEnum;

public class ResumeIntentHandler implements RequestHandler {
	private static final Logger logger = LoggerFactory.getLogger(ResumeIntentHandler.class);

	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName(AmazonIntentEnum.RESUME.getIntentName()));
	}

	public Optional<Response> handle(HandlerInput input) {
		return input.getResponseBuilder().addAudioPlayerStopDirective().withShouldEndSession(false).build();
	}
}