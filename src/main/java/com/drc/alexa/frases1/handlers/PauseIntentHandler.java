package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.drc.alexa.frases1.model.AmazonIntentEnum;

public class PauseIntentHandler implements RequestHandler {

	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName(AmazonIntentEnum.PAUSE.getIntentName()));
	}

	public Optional<Response> handle(HandlerInput input) {	
		return input.getResponseBuilder().addAudioPlayerStopDirective().withShouldEndSession(false).build();
	}
}