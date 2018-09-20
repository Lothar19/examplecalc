package com.drc.alexa.frases1.model;

public class SoundingPodcastDTO {
	
	private String url;
	
	private String name;
	
	private Long offsetMilliseconds;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getOffsetMilliseconds() {
		return offsetMilliseconds;
	}

	public void setOffsetMilliseconds(Long offsetMilliseconds) {
		this.offsetMilliseconds = offsetMilliseconds;
	}
}