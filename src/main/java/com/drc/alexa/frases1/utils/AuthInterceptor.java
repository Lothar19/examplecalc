package com.drc.alexa.frases1.utils;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

public class AuthInterceptor implements ClientHttpRequestInterceptor {
	
	private String authorization;

	public AuthInterceptor(String authorization) {
		this.authorization = authorization;
	}

	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		HttpRequestWrapper requestWrapper = new HttpRequestWrapper(request);
		requestWrapper.getHeaders().set("Authorization", "Basic " + authorization);
		return execution.execute(requestWrapper, body);
	}
}