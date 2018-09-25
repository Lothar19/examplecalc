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
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class AlexaUtils {

	private static Logger logger = LoggerFactory.getLogger(AlexaUtils.class);

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
}
