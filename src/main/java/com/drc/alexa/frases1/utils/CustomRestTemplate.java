package com.drc.alexa.frases1.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

public class CustomRestTemplate extends RestTemplate {
	
	public CustomRestTemplate(String auth) {
		super();
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new AuthInterceptor(auth));
		this.setInterceptors(interceptors);
	}

}
