package com.drc.alexa.frases1.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.drc.alexa.frases1.model.AmazonIntentEnum;
import com.drc.alexa.frases1.utils.AlexaSpeechTexts;

import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.amazon.ask.request.Predicates.intentName;

public class ExitSkillHandler implements RequestHandler {
	
	static final Logger logger = LoggerFactory.getLogger(ExitSkillHandler.class);

    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName(AmazonIntentEnum.STOP.getIntentName())
                .or(intentName(AmazonIntentEnum.CANCEL.getIntentName())));
    }

    public Optional<Response> handle(HandlerInput input) {    	
        String speechText = (AlexaSpeechTexts.STOP_DEFAULT_EMPTY[new Random().nextInt(AlexaSpeechTexts.STOP_DEFAULT_EMPTY.length)]);
        return input.getResponseBuilder().withSpeech(speechText).addAudioPlayerStopDirective().withShouldEndSession(true).build();
    }
}