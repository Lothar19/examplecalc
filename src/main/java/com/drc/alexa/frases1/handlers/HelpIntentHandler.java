package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.drc.alexa.frases1.model.AmazonIntentEnum;
import com.drc.alexa.frases1.model.ProgramType;
import com.drc.alexa.frases1.utils.AlexaSpeechTexts;

public class HelpIntentHandler implements RequestHandler {

    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName(AmazonIntentEnum.HELP.getIntentName()));
    }

    public Optional<Response> handle(HandlerInput input) {
    	
//    	ProgramType currentProgramType = null;
    	String speechText = null;
    	
//    	Map<String, Object> sessionAtributes = input.getAttributesManager().getSessionAttributes();
//    	if(sessionAtributes != null) {
//    		String stringProgramType = (String)sessionAtributes.get("status");
//    		if(stringProgramType != null) {
//    			currentProgramType = ProgramType.valueOf(stringProgramType);
//    		}
//    	}
        
//        if (ProgramType.PROGRAM.equals(currentProgramType)) {
//        	speechText = (AlexaSpeechTexts.ALEXA_HELP[new Random().nextInt(AlexaSpeechTexts.ALEXA_HELP.length)]);
//        	speechPromptText = (AlexaSpeechTexts.ALEXA_PROMPT_HELP[new Random().nextInt(AlexaSpeechTexts.ALEXA_PROMPT_HELP.length)]);
//        } else if(ProgramType.PODCAST.equals(currentProgramType)) {
//        	speechText = (AlexaSpeechTexts.ALEXA_HELP[new Random().nextInt(AlexaSpeechTexts.ALEXA_HELP.length)]);
//        	speechPromptText = (AlexaSpeechTexts.ALEXA_PROMPT_HELP[new Random().nextInt(AlexaSpeechTexts.ALEXA_PROMPT_HELP.length)]);
//        } else {
        	speechText = (AlexaSpeechTexts.ALEXA_HELP[new Random().nextInt(AlexaSpeechTexts.ALEXA_HELP.length)]);
//        }
        
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withShouldEndSession(false)
                .build();
    }
}