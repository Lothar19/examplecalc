package com.drc.alexa.frases1.utils;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.ask.model.interfaces.display.BackButtonBehavior;
import com.amazon.ask.model.interfaces.display.BodyTemplate1;
import com.amazon.ask.model.interfaces.display.Image;
import com.amazon.ask.model.interfaces.display.ImageInstance;
import com.amazon.ask.model.interfaces.display.PlainText;
import com.amazon.ask.model.interfaces.display.TextContent;
import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.drc.alexa.frases1.model.AlexaUser;

public class AlexaUtils {

	private static Logger logger = LoggerFactory.getLogger(AlexaUtils.class);
	private DynamoDB dynamoDb;

	/**
	 * Metodo que se encarga de recuperar la imagen en la plantilla de tipo 1
	 * 
	 * @return
	 */
	public static BodyTemplate1 getBodyTemplate1() {
		Image image = com.amazon.ask.model.interfaces.display.Image.builder()
				.addSourcesItem(ImageInstance.builder().withUrl(AlexaConstants.LOGO).build()).build();

		BodyTemplate1 template = BodyTemplate1.builder().withBackgroundImage(image).withTitle("")
				.withBackButton(BackButtonBehavior.HIDDEN)
				.withTextContent(
						TextContent.builder().withPrimaryText(PlainText.builder().withText("").build()).build())
				.build();

		return template;
	}

	/**
	 * Metodo que se encarga de persistir la informacion en bbdd
	 * 
	 * @param userRequest
	 *            objeto que contiene los valores a persistir
	 * @return PutItemOutcome
	 * @throws ConditionalCheckFailedException
	 */
	public PutItemOutcome persistData(AlexaUser userRequest) throws ConditionalCheckFailedException {
		Item item = new Item().withString("id", userRequest.getId() != null ? userRequest.getId() : "")
				.withString("idSite", userRequest.getIdSite() != null ? userRequest.getIdSite() : "")
				.withString("city", userRequest.getCity() != null ? userRequest.getCity() : "")
				.withString("lastLogin",
						userRequest.getLastLogin() != null ? userRequest.getLastLogin() : getFormatDate())
				.withString("numVisits", userRequest.getNumVisits() != null ? userRequest.getNumVisits() : "")
				.withString("idUser", userRequest.getIdUser() != null ? userRequest.getIdUser() : "")
				.withString("nameUser", userRequest.getNameUser() != null ? userRequest.getNameUser() : "");

		logger.info("item: " + item);
		this.initDynamoDbClient();
		Table table = this.dynamoDb.getTable(AlexaConstants.DYNAMODB_TABLE_USER_NAME);
		PutItemOutcome outcome = table.putItem(item);
		return outcome;
	}

	/**
	 * Metodo que se encarga de recuperar de la bbdd el objeto AlexaUser filtrando
	 * por el idUser
	 * 
	 * @param idUser
	 *            identificador unico del usuario
	 * @return
	 * @throws ConditionalCheckFailedException
	 */
	public Item readData(String idUser) throws ConditionalCheckFailedException {
		Item item = null;

		try {
			KeyAttribute key = new KeyAttribute(AlexaConstants.DYNAMO_IDUSER, idUser);
			logger.info("Alexa readData key: " + key);
			this.initDynamoDbClient();
			ItemCollection<QueryOutcome> i = this.dynamoDb.getTable(AlexaConstants.DYNAMODB_TABLE_USER_NAME).query(key);
			if (i.iterator().hasNext()) {
				item = i.iterator().next();
			}
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage(), e);
		}
		return item;
	}

	/**
	 * Metodo que se encarga de parsear la informacion de la bbdd al objeto
	 * AlexaUser
	 * 
	 * @param item
	 * @return
	 */
	public AlexaUser setAlexaUser(Item item) {
		AlexaUser user = new AlexaUser();
		user.setId(item.getString(AlexaConstants.DYNAMO_ID));
		user.setIdSite(item.getString(AlexaConstants.DYNAMO_IDSITE));
		user.setCity(item.getString(AlexaConstants.DYNAMO_CITY));
		user.setIdUser(item.getString(AlexaConstants.DYNAMO_IDUSER));
		user.setNameUser(item.getString(AlexaConstants.DYNAMO_NAMEUSER));
		user.setNumVisits(item.getString(AlexaConstants.DYNAMO_NUMVISITS));
		user.setLastLogin(item.getString(AlexaConstants.DYNAMO_LASTLOGIN));

		return user;
	}

	/**
	 * Metodo que se encarga de sumarla una visita al usuario
	 * 
	 * @param numVisits
	 * @return
	 */
	public String addOneVisit(String numVisits) {
		int response = Integer.valueOf(numVisits) + Integer.valueOf(1);
		return String.valueOf(response);
	}

	/**
	 * Formatea la fecha
	 * 
	 * @param requestDateTime
	 * @return
	 */
	public String getFormatDate(ZonedDateTime requestDateTime) {
		String date = requestDateTime.toString();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(AlexaConstants.FORMAT_DATE);
			dateFormat.setTimeZone(TimeZone.getTimeZone(AlexaConstants.FORMAT_TIMEZONE));
			logger.info("Fecha requestDateTime: " + requestDateTime);
			date = dateFormat.format(requestDateTime);
			logger.info("Fecha requestDateTime: " + requestDateTime);
		} catch (Exception e) {
			logger.error("Se ha producido un error al formatear la fecha %s", date, e.getMessage(), e);
		}
		return date;
	}

	/**
	 * Formatea la fecha
	 * 
	 * @param requestDateTime
	 * @return
	 */
	public String getFormatDate() {
		String date = new Date().toString();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(AlexaConstants.FORMAT_DATE);
			dateFormat.setTimeZone(TimeZone.getTimeZone(AlexaConstants.FORMAT_TIMEZONE));
			date = dateFormat.parse(date).toString();
		} catch (Exception e) {
			logger.error("Se ha producido un error al formatear la fecha %s", date, e.getMessage(), e);
		}
		return date;
	}

	/**
	 * Metodo que se encarga de establecer la conexion con la BBDD de DynamoDB
	 */
	private void initDynamoDbClient() {
		AmazonDynamoDBClient client = new AmazonDynamoDBClient();
		client.setRegion(Region.getRegion(AlexaConstants.REGION));
		this.dynamoDb = new DynamoDB(client);
		logger.info("Se ha completado la conexion con DynamoDb!!!");
	}

	/**
	 * Metodo que se encarga de obtener la url del podcast a reproducir (ACTUALMENTE
	 * ESTA EN FASE DE DESARROLLO)
	 * 
	 * @return
	 */
	public static final String getUrlPodcast(String namePodcast) {
		logger.info("********* Recuperar getUrlPodcast");

		String url;
		// Podcast
		// El Transistor
		if (namePodcast.equals(PodcastEnum.TRANSISTOR.getName())) {
			url = "https://dpvclip.antena3.com/mp_audios5//2018/08/22/4E92CD50-1377-416A-A83D-18EB1A2A7ACB/4E92CD50-1377-416A-A83D-18EB1A2A7ACB.mp4";
		} else if (namePodcast.equals(PodcastEnum.MAS_DE_UNO.getName())) {
			// Mas de uno
			url = "https://dpvclip.antena3.com/mp_audios5//2018/08/22/0847D350-1294-42DD-8353-5B7106844326/0847D350-1294-42DD-8353-5B7106844326.mp4";
		} else if (namePodcast.equals(PodcastEnum.LA_ROSA_DE_LOS_VIENTOS.getName())) {
			// La rosa de los vientos
			url = "https://dpvclip.antena3.com/mp_audios5//2018/08/20/2C03FAFA-7242-42A9-908A-E439A9353D19/2C03FAFA-7242-42A9-908A-E439A9353D19.mp4";
		} else {
			// Live
			url = "https://icecast-streaming.nice264.com/ondacero";
		}

		logger.info("********* Recuperar getUrlPodcast - url: " + url + " - namePodcast: " + namePodcast);
		return url;
	}
}
