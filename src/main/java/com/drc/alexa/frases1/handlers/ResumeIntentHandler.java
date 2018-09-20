package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.audioplayer.PlayBehavior;


public class ResumeIntentHandler implements RequestHandler {
	private static final Logger logger = LoggerFactory.getLogger(ResumeIntentHandler.class);

	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.ResumeIntent"));
	}

	public Optional<Response> handle(HandlerInput input) {

		logger.info("Reanudando directo");
		String liveUrl = "https://icecast-streaming.nice264.com/ondacero";
		return input.getResponseBuilder()
				.addAudioPlayerPlayDirective(PlayBehavior.REPLACE_ALL, 0L, null, liveUrl, liveUrl)
				.withShouldEndSession(false).build();

	}

}