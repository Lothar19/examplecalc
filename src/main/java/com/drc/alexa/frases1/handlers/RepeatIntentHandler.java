package com.drc.alexa.frases1.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.drc.alexa.frases1.dao.AlexaUserDao;
import com.drc.alexa.frases1.model.AlexaUser;
import com.drc.alexa.frases1.model.AmazonIntentEnum;
import com.drc.alexa.frases1.utils.AlexaConstants;
import com.drc.alexa.frases1.utils.AlexaUtils;

public class RepeatIntentHandler implements RequestHandler {
	
	static final Logger logger = LoggerFactory.getLogger(RepeatIntentHandler.class);
	
	private AlexaUserDao dao = new AlexaUserDao();
	private AlexaUtils utils = new AlexaUtils();
	
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName(AmazonIntentEnum.REPEAT.getIntentName()));
	}

	public Optional<Response> handle(HandlerInput input) {
//		String speechText = AlexaSpeechTexts.NOT_IMPLEMENTED_REPEAT;
//		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();
		
		// TODO eliminar todo este codigo. Se ha incluido para hacer pruebas de conexion a bbdd de escritura y lectura
		Request request = input.getRequestEnvelope().getRequest();
		ZonedDateTime requestDateTime = request.getTimestamp().atZoneSameInstant(ZoneId.of(AlexaConstants.ZONE));
		String idUser = input.getRequestEnvelope().getSession().getUser().getUserId();
		AlexaUser user = getUser(idUser);
		saveUser(user, idUser, requestDateTime);
		return input.getResponseBuilder().withSpeech("Hasta Luego: " + ((user != null) ? user.getNameUser() : "")).withShouldEndSession(false).build();
	}
	
	private AlexaUser getUser(String userId) {
		AlexaUser user = dao.readByIdUser(userId);
		return user;
	}
	
	private void saveUser(AlexaUser user, String idUser, ZonedDateTime requestDateTime) {		
		dao.save(getSaveAlexaUser(user, idUser, requestDateTime));
	}
	
	private AlexaUser getSaveAlexaUser(AlexaUser user, String idUser, ZonedDateTime requestDateTime) {
		if (user == null) {
			user = new AlexaUser();
		}
		
		user.setIdSite(AlexaConstants.SITE_ONDACERO);		
		user.setIdUser(idUser);
		user.setNameUser("Alexa");
		user.setNumVisits(utils.addOneVisit((user.getNumVisits() != null) ? user.getNumVisits() : "0"));		
		user.setLastLogin(utils.getFormatDate(requestDateTime));

		return user;
	}	
}