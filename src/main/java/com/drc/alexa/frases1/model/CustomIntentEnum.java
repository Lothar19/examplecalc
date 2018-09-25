package com.drc.alexa.frases1.model;

public enum CustomIntentEnum {
	
	NOMBRES_MASCOTAS("NombresDeMascotas"), NOMBRES("Nombres"), FRASES_TORRENTES("Frases");
	
	String intentName;
	
	public String getIntentName() {
		return intentName;
	}

	private CustomIntentEnum(String intentName) {
		this.intentName = intentName;
	}
}