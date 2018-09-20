package com.drc.alexa.frases1.model;

public enum ProgramType {
	
	PROGRAM("programa"), PODCAST("podcast");
	
	private String name;
	
	private ProgramType(String name) {
		this.name= name;
	}

	public String getName() {
		return name;
	}
}