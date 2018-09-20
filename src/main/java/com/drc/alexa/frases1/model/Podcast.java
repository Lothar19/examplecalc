package com.drc.alexa.frases1.model;

public class Podcast {

	private String userId;
	
	private String podcastName;
	
	private String podcastUrl;
	
	private Long offsetMilliseconds;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPodcastName() {
		return podcastName;
	}

	public void setPodcastName(String podcastName) {
		this.podcastName = podcastName;
	}

	public String getPodcastUrl() {
		return podcastUrl;
	}

	public void setPodcastUrl(String podcastUrl) {
		this.podcastUrl = podcastUrl;
	}

	public Long getOffsetMilliseconds() {
		return offsetMilliseconds;
	}

	public void setOffsetMilliseconds(Long offsetMilliseconds) {
		this.offsetMilliseconds = offsetMilliseconds;
	}
}
