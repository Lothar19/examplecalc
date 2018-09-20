package com.drc.alexa.frases1.model;

public enum AmazonIntentEnum {
	
	REPEAT("AMAZON.RepeatIntent"), 
	STOP("AMAZON.StopIntent"), 
	CANCEL("AMAZON.CancelIntent"),
	FALLBACK("AMAZON.FallbackIntent"),
	HELP("AMAZON.HelpIntent"),
	LOOP_OFF("AMAZON.LoopOffIntent"),
	LOOP_ON("AMAZON.LoopOnIntent"),
	NEXT("AMAZON.NextIntent"),
	PREVIOUS("AMAZON.PreviousIntent"),	
	PAUSE("AMAZON.PauseIntent"),
	RESUME("AMAZON.ResumeIntent"),
	SHUFFLE_OFF("AMAZON.ShuffleOffIntent"),
	SHUFFLE_ON("AMAZON.ShuffleOnIntent"),
	STARTOVER("AMAZON.StartOverIntent"),
	;
	
	String intentName;
	
	public String getIntentName() {
		return intentName;
	}

	private AmazonIntentEnum(String intentName) {
		this.intentName = intentName;
	}
}