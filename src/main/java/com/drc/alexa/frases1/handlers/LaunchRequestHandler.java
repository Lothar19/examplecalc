package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.requestType;

import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.BackButtonBehavior;
import com.amazon.ask.model.interfaces.display.BodyTemplate1;
import com.amazon.ask.model.interfaces.display.Image;
import com.amazon.ask.model.interfaces.display.ImageInstance;
import com.drc.alexa.frases1.utils.AlexaConstants;
import com.drc.alexa.frases1.utils.AlexaSpeechTexts;

public class LaunchRequestHandler implements RequestHandler {

	static final Logger logger = LoggerFactory.getLogger(LaunchRequestHandler.class);
	
	public boolean canHandle(HandlerInput input) {
		return input.matches(requestType(LaunchRequest.class));
	}

	public Optional<Response> handle(HandlerInput input) {		
		// Mensaje de bienvenida
		String speechText = (AlexaSpeechTexts.WELCOME_MASCOTAS[new Random().nextInt(AlexaSpeechTexts.WELCOME_MASCOTAS.length)]);
		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();
	}
}