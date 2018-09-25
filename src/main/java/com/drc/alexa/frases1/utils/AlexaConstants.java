package com.drc.alexa.frases1.utils;

import com.amazonaws.regions.Regions;

public class AlexaConstants {
	
	public static final String PODCAST_NAME_SLOT = "podcastName";
	public static final String PLAY_LAST_PODCAST_SLOT = "playLastPodcast";
	public static final String LOGO = "";
	public static final String ZONE = "Europe/Madrid";
	public static final Regions REGION = Regions.EU_WEST_1;
	
	// SITES
	public static final String SITE_ONDACERO = "2";
	public static final String SITE_EUROPAFM = "3";
	public static final String SITE_MELODIAFM = "40";
	
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_TIMEZONE = "UTC";
	
	// ELASTICACHE
	public static final String  CACHE_HOST = "alexa-cache.jnt8m7.cfg.euw1.cache.amazonaws.com";
	public static final Integer CACHE_PORT = 11211;
	
	// DYNAMODB
	public static final String DYNAMODB_TABLE_USER_NAME = "Alexa-user";
	public static final String DYNAMO_IDUSER = "idUser";
	public static final String DYNAMO_ID = "id";
	public static final String DYNAMO_IDSITE = "idSite";
	public static final String DYNAMO_CITY = "city";	
	public static final String DYNAMO_NAMEUSER = "nameUser";
	public static final String DYNAMO_NUMVISITS = "numVisits";
	public static final String DYNAMO_LASTLOGIN = "lastLogin";
}