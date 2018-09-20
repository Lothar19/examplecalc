package com.drc.alexa.frases1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.drc.alexa.frases1.model.AlexaUser;
import com.drc.alexa.frases1.utils.AlexaUtils;

public class AlexaUserDao implements AlexaDao<AlexaUser> {

	static final Logger logger = LoggerFactory.getLogger(AlexaUserDao.class);
	private AlexaUtils utils = new AlexaUtils();

	// ------------------------------------
	// ---- SAVE
	// ------------------------------------
	@Override
	public void save(AlexaUser request) {		 
		utils.persistData(request);
		logger.info("Saved {} Successfully!!!", request.getIdUser());		 
	}	

	// ------------------------------------
	// ---- READ
	// ------------------------------------
	/**
	 * Metodo que se encarga de realizar una busqueda en bbdd por el idUser
	 * @param idUser identificador unico del usuario
	 * @return
	 */
	@Override
	public AlexaUser readByIdUser(String idUser) {

		AlexaUser user = null;		
		Item item = utils.readData(idUser);
		
		if (null != item) {
			user = utils.setAlexaUser(item);		 
			logger.info("Alexa Read {} Successfully!!!", user.getIdUser());
		} else {
			logger.info("Alexa Read {} Not found!!!", idUser);
		}
		return user;
	}
}