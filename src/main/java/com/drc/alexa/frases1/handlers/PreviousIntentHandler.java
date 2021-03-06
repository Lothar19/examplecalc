package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.drc.alexa.frases1.model.AmazonIntentEnum;
import com.drc.alexa.frases1.utils.AlexaSpeechTexts;

public class PreviousIntentHandler implements RequestHandler {

	static final Logger logger = LoggerFactory.getLogger(PreviousIntentHandler.class);
	
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName(AmazonIntentEnum.PREVIOUS.getIntentName()));
	}

	public Optional<Response> handle(HandlerInput input) {
		return input.getResponseBuilder().withSpeech(AlexaSpeechTexts.NOT_IMPLEMENTED_PREVIOUS).withShouldEndSession(false).build();
	}
}