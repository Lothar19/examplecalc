package com.drc.alexa.frases1.model;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Alexa-User")
public class AlexaUser implements Serializable {

	private static final long serialVersionUID = 745214836622078997L;
	
	// PK
	@DynamoDBRangeKey
	private String id;
	@DynamoDBRangeKey
	private String idSite;

	@DynamoDBAttribute
	private String city;
	@DynamoDBAttribute
	private String lastLogin;
	@DynamoDBAttribute
	private String numVisits;
	@DynamoDBAttribute
	private String idUser;
	@DynamoDBAttribute
	private String nameUser;

	public AlexaUser() {
		super();
	}
	
	/**
	 * 
	 * @param id
	 * @param idSite
	 * @param city
	 * @param lastLogin
	 * @param numVisits
	 * @param idUser
	 * @param nameUser
	 */	
	public AlexaUser(String id, String idSite, String city, String lastLogin, String numVisits, String idUser, String nameUser) {
		super();
		this.id = id;
		this.idSite = idSite;
		this.city = city;
		this.lastLogin = lastLogin;
		this.numVisits = numVisits;
		this.idUser = idUser;
		this.nameUser = nameUser;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdSite() {
		return idSite;
	}
	public void setIdSite(String idSite) {
		this.idSite = idSite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getNumVisits() {
		return numVisits;
	}
	public void setNumVisits(String numVisits) {
		this.numVisits = numVisits;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	@Override
	public String toString() {
		return "AlexaUserDTO [id=" + id + ", idSite=" + idSite + ", city=" + city + ", lastLogin=" + lastLogin
				+ ", numVisits=" + numVisits + ", idUser=" + idUser + ", nameUser=" + nameUser + "]";
	}	
}