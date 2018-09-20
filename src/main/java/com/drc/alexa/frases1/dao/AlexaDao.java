package com.drc.alexa.frases1.dao;

public interface AlexaDao<T> {
	
	void save(T t);
	T readByIdUser(String idUser);	
}