package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.model.slu.entityresolution.StatusCode;
import com.drc.alexa.frases1.model.CustomIntentEnum;
import com.drc.alexa.frases1.utils.AlexaConstants;
import com.drc.alexa.frases1.utils.AlexaSpeechTexts;

public class CaraCruzIntentHandler implements RequestHandler {

	private static final Logger logger = LoggerFactory.getLogger(CaraCruzIntentHandler.class);

	public boolean canHandle(HandlerInput input) {
//		logger.info("********** " + AlexaConstants.SITENAME_CARA_CRUZ + ": " + new Date() + input);
		logger.info("********** " + ": " + CustomIntentEnum.CARACRUZ.getIntentName() + input);
		return input.matches(intentName(CustomIntentEnum.CARACRUZ.getIntentName()));
	}

	public Optional<Response> handle(HandlerInput input) {
		logger.info("********** " + new Date());
		logger.info("Ha entrado en el handler principal");
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();

		Map<String, Slot> slots = intent.getSlots();		
		Slot nameSlot = slots.get(AlexaConstants.SLOT_OPTIONALS);
		ZonedDateTime requestDateTime = request.getTimestamp().atZoneSameInstant(ZoneId.of("Europe/Madrid"));
		
		String realNameSlot = null;
		if ((realNameSlot = getValidCustomSlot(nameSlot)) == null) {
			logger.info("no se reconoce el slot");
			return input.getResponseBuilder()
					.withSpeech(AlexaSpeechTexts.HELP_GENERIC[new Random().nextInt(AlexaSpeechTexts.HELP_GENERIC.length)])
	        		.withReprompt(AlexaSpeechTexts.HELP_GENERIC_PROMPT[new Random().nextInt(AlexaSpeechTexts.HELP_GENERIC_PROMPT.length)])
					.addElicitSlotDirective(AlexaConstants.SLOT_CARACRUZ_TYPE, intent).build();
		} 
		logger.info("MainHandler 4");
			
		String Opt = AlexaSpeechTexts.OPT_CARACRUZ[new Random().nextInt(AlexaSpeechTexts.OPT_CARACRUZ.length)];
		String speechText = "Has seleccionado " + realNameSlot + AlexaSpeechTexts.CARACRUZ[new Random().nextInt(AlexaSpeechTexts.CARACRUZ.length)] + Opt + ".";
		if (realNameSlot.equalsIgnoreCase(Opt))
			speechText += "<emphasis level=\"strong\"> Tu Ganas </emphasis>";
		else
			speechText += "<emphasis level=\"strong\">Tu Pierdes </emphasis>";

		logger.info("*******************************");
		logger.info("MainHandler 5 - speechText: " + speechText);
		logger.info("*******************************");
		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();
	}

	/**
	 * 
	 * @param slot
	 * @return
	 */
	private String getValidCustomSlot(Slot slot) {
		String podcastRealName = null;
		if( (slot.getValue() != null) && (slot.getResolutions() != null)
				&& (slot.getResolutions().getResolutionsPerAuthority() != null)
				&& (slot.getResolutions().getResolutionsPerAuthority().get(0) != null)
				&& (slot.getResolutions().getResolutionsPerAuthority().get(0).getStatus() != null)
				&& !(slot.getResolutions().getResolutionsPerAuthority().get(0).getStatus().getCode()
						.equals(StatusCode.ER_SUCCESS_NO_MATCH)
						|| slot.getResolutions().getResolutionsPerAuthority().get(0).getStatus().getCode()
								.equals(StatusCode.ER_ERROR_EXCEPTION))) {
			podcastRealName = slot.getResolutions().getResolutionsPerAuthority().get(0).getValues().get(0).getValue().getName(); 
		}
		
		return podcastRealName;
	}
}