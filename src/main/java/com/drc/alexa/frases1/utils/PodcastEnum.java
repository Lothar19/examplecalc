package com.drc.alexa.frases1.utils;

public enum PodcastEnum {	
	
	TRANSISTOR("El Transistor"), 
	MAS_DE_UNO("Más de uno"), 
	JULIO_ONDA("Julia en la onda"),
	LA_BRUJULA("La Brújula"), 
	NO_SON_HORAS("No son horas"), 
	LA_CULTERETA("La Cultureta"),
	QUEDATE_CON_LO_MEJOR("Quédate con lo mejor"), 
	ONDA_DEPORTIVO("Onda Deportiva"), 
	POR_FIN_NO_ES_LUNES("Por fin no es lunes"),
	LA_ROSA_DE_LOS_VIENTOS("La rosa de los vientos"), 
	RADIOESTADIO("Radioestadio"), 
	NOTICIAS_FIN_DE_SEMANA("Noticias fin de semana"),
	GENTE_VIAJERA("Gente Viajera"), 
	COMO_EL_PERRO_Y_EL_GATO("Como el perro y el gato"), 
	EN_BUENAS_MANOS("En buenas manos"),
	ONDA_AGRARIA("Onda Agraria");
	
	private String name;
	
	private PodcastEnum(String name) {
        this.name = name;
    }

	public String getName() {
		return name;
	}
	
}