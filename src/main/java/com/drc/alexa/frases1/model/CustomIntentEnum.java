package com.drc.alexa.frases1.model;

public enum CustomIntentEnum {
	
	WHAT_IS_SOUNDING("QueEstaSonando"), LIVE("Directo"), PODCAST("Podcast");
	
	String intentName;
	
	public String getIntentName() {
		return intentName;
	}

	private CustomIntentEnum(String intentName) {
		this.intentName = intentName;
	}
}