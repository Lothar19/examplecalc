package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.intentName;

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
import com.drc.alexa.frases1.utils.AlexaUtils;

public class NombresMascotasIntentHandler implements RequestHandler {

	private static final Logger logger = LoggerFactory.getLogger(NombresMascotasIntentHandler.class);

	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName(CustomIntentEnum.NOMBRES_MASCOTAS.getIntentName()));
	}

	public Optional<Response> handle(HandlerInput input) {

		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();

		Map<String, Slot> slots = intent.getSlots();

		Slot nameSlot = slots.get(AlexaConstants.NAME_SLOT);
		String realNameSlot = null;
		if ((realNameSlot = getValidCustomSlot(nameSlot)) == null) {
			logger.info("no se reconoce el tipo de animal");
			return input.getResponseBuilder()
					.withSpeech("Perdona, no reconozco ese animal. Di otro animal como 'Perro', 'Gato' o Pájaro'")
					.addElicitSlotDirective(AlexaConstants.NAME_SLOT, intent).build();
		} 
		
		String speechText = "";
		for (int i = 0; i<5; i++) {
			speechText += (AlexaSpeechTexts.MASCOTAS[new Random().nextInt(AlexaSpeechTexts.MASCOTAS.length)]) + ", ";
		}
		
		return input.getResponseBuilder()
				.withSpeech(speechText)
				.addRenderTemplateDirective(AlexaUtils.getBodyTemplateWithImage())
				.withShouldEndSession(false).build();
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