package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.drc.alexa.frases1.model.AmazonIntentEnum;
import com.drc.alexa.frases1.utils.AlexaSpeechTexts;

public class ShuffleIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName(AmazonIntentEnum.SHUFFLE_ON.getIntentName()).or(intentName(AmazonIntentEnum.SHUFFLE_OFF.getIntentName())));
	}

	public Optional<Response> handle(HandlerInput input) {
		return input.getResponseBuilder().withSpeech(AlexaSpeechTexts.NOT_IMPLEMENTED_SHUFFLE).withShouldEndSession(false).build();
	}
}