package com.drc.alexa.frases1.utils;

public class AlexaSpeechTexts {

	public static final String TITLE = "Onda Cero Radio"; 
	
	// WELCOME
	public static final String[] WELCOME = { "Te damos la bienvenida a Onda Cero radio. Puedes escuchar el directo o podcasts. ¿Qué quieres hacer?",
			"Te damos la bienvenida a nuestra skill de Onda Cero radio. Una de las opciones disponibles es 'escuchar el directo'.",
			"Hola, esto es Onda Cero radio. Para escuchar el directo diga, por ejemplo, 'pon el directo'.",
			"Te damos la bienvenida a Onda Cero. En esta primera versión sólo podrás escuchar el directo, más adelante incluiremos podcasts."};

	// STOP
	public static final String[] STOP_DEFAULT_EMPTY = {
			"Gracias por escuchar Onda cero, puede visitarnos en ondacero.es",
			//"Si te ha gustado nuestra skill danos cinco estrellas.", 
			"Gracias por escuchar Onda Cero" };

	// PODCAST
	public final static String[] PODCAST_NOT_IMPLEMENTED = { "En breve podrá disfrutar de los podcast en nuestra skill",
			"La opción de reproducir podcast estará disponible en próximas versiones." };

	public static final String[] PLAYING_LIVE_WITH_FORMAT = {"Actualmente estamos emitiendo el programa %s", "Esta sonando nuestro programa %s", "Nuestro programa actual es %"};
	public static final String UNKNOWN_LIVE_PLAYING = "No se ha podido determinar que programa está sonando";

	public static final String[] LIVE_CHOOSE_EVENT = {
			"Ahora mismo puedes escuchar nuestro directo o el evento %s, ¿qué te apetece escuchar?",
			"Además de nuestra programación habitual, ahora podemos ofrecerte el evento %s, ¿quieres escuchar el evento, o el directo?",
			"¿Prefieres escuchar nuestro directo, o el evento %s ?" 
	};
	
	public static final String[] LIVE_CHOOSE_EVENT_REPROMT = {
			"¿Quieres escuchar nuestro directo, o el evento %s?",
			"Ahora puedes escuchar nuestra programación habitual, o el evento %s, ¿Qué prefieres?" 
	};

	public static final String[] LIVE_CHOOSE_EVENT_DIDNT_UNDERSTAND = {
			"Perdona, no te he entendido",
			"No he entendido qué es lo que quieres escuchar",
			"Perdona no te he entendido ¿Puedes repetirlo?",
			"Perdona, ¿puedes repetirlo?", 
			"Perdona, ¿Que has dicho?"
	};
	
	public static final String LIVE_CHOOSE_HELP = " .Puedes decir \"directo\" para escuchar nuestro programa en directo, o \"evento\" para escuchar nuestro evento ";

	// HELP
	// reproduce el directo, escuchar directo, directo
	public static final String[] ALEXA_HELP = { "Nuestra skill te permite escuchar el directo.",
			"Una de las opciones disponibles es 'abrir el directo'. En breve podrá disfrutar de los podcast en nuestra skill.", 
			"Diga 'escuchar directo'.",
			"Pruebe a decir 'directo'. La opción de reproducir podcast estará disponible en próximas versiones.",
			"Para escuchar el directo diga, por ejemplo, 'pon el directo'."};
	public static final String[] ALEXA_PROMPT_HELP = { "No te he entendido", "Perdona, ¿puedes repetirlo?" };

	// REPEAT
	public static final String NOT_IMPLEMENTED_REPEAT = "La opción repite estará disponible en próximas versiones.";


	// NOT IMPLEMENTED
	public static final String NOT_IMPLEMENTED_NEXT = "La opción de reproducir siguiente estará disponible en próximas versiones.";
	public static final String NOT_IMPLEMENTED_PREVIOUS = "La opción de reproducir anterior estará disponible en próximas versiones.";
	public static final String NOT_IMPLEMENTED_STARTOVER = "La opción de empezar de nuevo un directo estará disponible en próximas versiones.";
	public static final String NOT_IMPLEMENTED_SHUFFLE = "La opción de reproducción aleatoria estará disponible en próximas versiones.";
	public static final String NOT_IMPLEMENTED_LOOP = "La opción de reproducción en bucle estará disponible en próximas versiones.";
}