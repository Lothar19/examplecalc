package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;
import java.util.Random;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.drc.alexa.frases1.model.AmazonIntentEnum;
import com.drc.alexa.frases1.utils.AlexaSpeechTexts;

public class HelpIntentHandler implements RequestHandler {

    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName(AmazonIntentEnum.HELP.getIntentName()));
    }

    public Optional<Response> handle(HandlerInput input) {
    	String speechText = (AlexaSpeechTexts.HELP_GENERIC[new Random().nextInt(AlexaSpeechTexts.HELP_GENERIC.length)]);
    	
        return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();
    }
}