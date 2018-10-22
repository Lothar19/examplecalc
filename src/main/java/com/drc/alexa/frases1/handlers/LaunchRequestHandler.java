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
import com.drc.alexa.frases1.utils.AlexaSpeechTexts;

public class LaunchRequestHandler implements RequestHandler {

	static final Logger logger = LoggerFactory.getLogger(LaunchRequestHandler.class);
	
	public boolean canHandle(HandlerInput input) {
		return input.matches(requestType(LaunchRequest.class));
	}

	public Optional<Response> handle(HandlerInput input) {
		logger.info("Ha entrado en el launch");
//		// Crea el template con el logo de fondo
//		Image image = Image.builder().addSourcesItem(ImageInstance.builder().withUrl(AlexaConstants.LOGO).build()).build();
//		BodyTemplate1 template = BodyTemplate1.builder().withBackgroundImage(image).withBackButton(BackButtonBehavior.VISIBLE).build();
//		
//		// Mensaje de bienvenida
		String speechText = (AlexaSpeechTexts.WELCOME_CARACRUZ[new Random().nextInt(AlexaSpeechTexts.WELCOME_CARACRUZ.length)]);
		logger.info("Launch 2 - speech: " + speechText);
//		// Comprueba si el dispositivo tiene pantalla para mostrar la imagen o no.
//		if (null != input.getRequestEnvelope().getContext().getDisplay()) {
//			return input.getResponseBuilder().withSpeech(speechText).addRenderTemplateDirective(template).withShouldEndSession(false).build();	
//		} else {
//			return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();	
//		}		
		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(true).build();
	}
}