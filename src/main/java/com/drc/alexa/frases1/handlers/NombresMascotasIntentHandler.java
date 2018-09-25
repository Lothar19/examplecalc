package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.model.interfaces.audioplayer.PlayBehavior;
import com.amazon.ask.model.interfaces.audioplayer.PlaybackStoppedRequest;
import com.amazon.ask.model.slu.entityresolution.StatusCode;
import com.drc.alexa.frases1.model.CustomIntentEnum;
import com.drc.alexa.frases1.model.Podcast;
import com.drc.alexa.frases1.model.ProgramType;
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
		Slot playLastPodcast = slots.get(AlexaConstants.PLAY_LAST_PODCAST_SLOT);

		Podcast pausedPodcast = getLastPodcast();

		if (pausedPodcast != null && (playLastPodcast.getValue() == null)) {

			return input.getResponseBuilder()
					.withSpeech("La última vez no terminaste de escuchar " + pausedPodcast.getPodcastName()
							+ ". Quieres retomar el podcast?")
					.addElicitSlotDirective(AlexaConstants.PLAY_LAST_PODCAST_SLOT, intent).build();
		} else if (pausedPodcast != null && (playLastPodcast.getValue() != null)
				&& (((String) playLastPodcast.getValue()).equalsIgnoreCase("si"))) {

			setWhatIsSoundingPodcast(input, pausedPodcast.getPodcastName(), pausedPodcast);

			return input.getResponseBuilder().withSpeech("Reproduciendo el podcast " + pausedPodcast.getPodcastName())
					.addRenderTemplateDirective(AlexaUtils.getBodyTemplate1())
					.withShouldEndSession(false)
					.addAudioPlayerPlayDirective(PlayBehavior.REPLACE_ALL, pausedPodcast.getOffsetMilliseconds(), null,
							pausedPodcast.getPodcastUrl(), pausedPodcast.getPodcastUrl())
					.build();

		} else if (pausedPodcast != null && (playLastPodcast.getValue() != null)
				&& (((String) playLastPodcast.getValue()).equalsIgnoreCase("no"))
				&& !intentRequest.getDialogState().equals(DialogState.COMPLETED)) {

			return input.getResponseBuilder().addDelegateDirective(intent).build();

		} else {

			if (!intentRequest.getDialogState().equals(DialogState.COMPLETED)) {
				return input.getResponseBuilder().addDelegateDirective(intent).build();
			} else {
				Slot podcastNameSlot = slots.get(AlexaConstants.PODCAST_NAME_SLOT);
				String realPodcastName = null;
				if ((realPodcastName = getValidCustomSlot(podcastNameSlot)) == null) {
					logger.info("no se reconoce el podcast");
					return input.getResponseBuilder().withSpeech(
							"Perdona, no reconozco ese podcast. Di otro podcast como El Transistor o la Rosa de los vientos")
							.addElicitSlotDirective(AlexaConstants.PODCAST_NAME_SLOT, intent).build();
				}

				String url = AlexaUtils.getUrlPodcast(realPodcastName);

				Podcast podcast = mapPodcast(url, realPodcastName);
				setWhatIsSoundingPodcast(input, realPodcastName, podcast);
				
				return input.getResponseBuilder().withSpeech("Reproduciendo el podcast " + realPodcastName)
						.addRenderTemplateDirective(AlexaUtils.getBodyTemplate1())
						.withShouldEndSession(false)
						.addAudioPlayerPlayDirective(PlayBehavior.REPLACE_ALL, 0L, null, url, url).build();
			}

		}

	}

	private void setWhatIsSoundingPodcast(HandlerInput input, String podcastName, Podcast podcast) {
		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
		sessionAttributes.put("currentProgramType", ProgramType.PODCAST);
		sessionAttributes.put("currentPodcast", podcast);
		// Borramos el directo en caso de que estuviera reproduciendo uno
		sessionAttributes.remove("currentProgram");
	}
	
	private Podcast mapPodcast(String podcastUrl, String podcastName) {
		PlaybackStoppedRequest req = PlaybackStoppedRequest.builder().build();
		Podcast podcast = new Podcast();
		podcast.setOffsetMilliseconds(0L);
		podcast.setPodcastName(podcastName);
		podcast.setPodcastUrl(podcastUrl);
		//podcast.setUserId(userId);
		
		return podcast;
	}

	private Podcast getLastPodcast() {

		Podcast podcast = new Podcast();
		podcast.setOffsetMilliseconds(2000L);
		podcast.setPodcastName("La Rosa de Los Vientos");
		podcast.setPodcastUrl(
				"https://dpvclip.antena3.com/mp_audios5//2018/08/22/4E92CD50-1377-416A-A83D-18EB1A2A7ACB/4E92CD50-1377-416A-A83D-18EB1A2A7ACB.mp4");

		return podcast;
	}

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