package com.drc.alexa.frases1.utils;

public class AlexaSpeechTexts {

	// TITLE
	public static final String TITLE_FRASES1 = "Frases Torrente";
	public static final String TITLE_NOMBRES = "Frases Nombres";
	public static final String TITLE_MASCOTAS = "Frases Nombres de Mascotas";
	public static final String TITLE_CARACRUZ = "Cara o Cruz";
	public static final String TITLE_PARESNONES = "Paras o Nones";
	
	// WELCOME
	// --------------------------------------------------------------------
	public static final String[] WELCOME_FRASES1 = {
		"Te damos la bienvenida a Frases Torrente.",
		"Te damos la bienvenida a nuestra skill de Frases Torrente. ",
		"Hola, esto es Frases Torrente. ",
		"Te damos la bienvenida a Frases Torrente. En esta primera versión sólo podrás escuchar frases de Torrente."
	};

	public static final String[] WELCOME_NOMBRES = { 
		"Te damos la bienvenida a Nombres.",
		"Te damos la bienvenida a nuestra skill de Nombres. ",
		"Hola, esto es Nombres. ",
		"Te damos la bienvenida a Nombres. En esta primera versión sólo podrás escuchar frases de Torrente."
	};
	
	public static final String[] WELCOME_CARACRUZ = {
		"Te damos la bienvenida a "+TITLE_CARACRUZ+". "
		, "Te damos la bienvenida a nuestra skill de "+TITLE_CARACRUZ+"."
		, "Hola, esto es "+TITLE_CARACRUZ+". "
	};
	
	public static final String[] WELCOME_PARESNONES = { 
		"Te damos la bienvenida a "+TITLE_PARESNONES+". "
		, "Te damos la bienvenida a nuestra skill de "+TITLE_PARESNONES+"."
		, "Hola, esto es "+TITLE_PARESNONES+". "
	};
	// --------------------------------------------------------------------
	
	// RESPONSE
	// --------------------------------------------------------------------
	public static final String[] FRASES1 = {
	//	Torrente, el brazo tonto de la Ley.
		"¿Te gustan las pistolitas? ¡PUES CÓMPRATE UNA!",
		"Chinita, chinita,a un poquito pan",
		"Mi nombre es Torrente, José Luis Torrente.", 
		"Quieto todo el mundo. ¡Ya está aquí el alma de la fiesta!",
		"¿Te gustan los niños? Si quieres te hago uno.",
		"Hay dos tipos de hombres: los que se lavan las manos antes de mear y los que se las lavan después. Yo, me las lavo antes.",
		"Mi polla es sagrada, es el centro del universo mundial, la manguerita de la alegría.",
		"Ocúpate de que entierren a mi padre como vivió: con dignidad.",
		"Eh, chaval, ¿nos hacemos unas pajillas? Pero sin mariconadas.",
	
	//	Torrente 2, Misión en Marbella
		"Todo el mundo quieto o me cargo al mono.",
		"Ya que estamos, Gibraltar, de nuevo español o pa' nadie.",
		"¡Di que el Fary es Dios! Di que tu madre es puta... bueno, eso no lo digas, que ya lo sabe todo el mundo.",
		"Tus ojos son como dos sartenes, cuando los veo se me fríen los huevos",
		"Torrente, si tiene usted tetas y responde, esto no son tetas, ¡son pectorales!",
		"Eres lo más grande desde la creación del muñeco Espinete.",
		"Si tú fueras un bollycao me comería hasta el cromo.",
		"Chavalota, haría contigo más cosas que las que haría McGyver en Bricomanía.",
		"Oye, nena… ¿crees en el amor a primera vista? ¿O voy a tener que pasar dos veces?",
	
	//	Torrente 3, el protector
		"Pero como puede ser un hijo mío, de un equipo como el Real Madrid.",
		"Y tú, ¿tienes algún problema? ¿No te gusta tu cara? Porque si quieres te la cambio.",
	
	//	Torrente 4, lethal crisis
		"¿Buscas el tocador? Pues ese soy yo.",
		"Mis padres son músicos. Mi madre toca el violín, y mi padre la viola. ¡La viola! ¡La viola!.",
		"Señora, le cambio a su hija por una guitarra y así los 2 tenemos algo que tocar."
	};
	
	public static final String[] NOMBRES = {
		//	Hombre
		"¿Te gustan las pistolitas? ¡PUES CÓMPRATE UNA!",			
		
		//	Mujer
		"Todo el mundo quieto o me cargo al mono.",			
	};

	public static final String[] CARACRUZ = {
		". Y lanzamos la moneda y sale .............. Cruz.",
		". Y lanzamos la moneda y sale .............. Cara."
	};
		
	public static final String[] PARESNONES = {
		  			
	};
	// --------------------------------------------------------------------

	// HELP GENERIC
	public static final String[] HELP_GENERIC = { 
			"Nuestra skill te permite elegir 'cara o cruz'.",
			"Una de las opciones disponibles es elegir 'cara'.",
			"Una de las opciones disponibles es elegir 'cruz'.",
			"Diga 'cara'.",
			"Diga 'cruz'.",
			"Pruebe a decir 'cara'.",
			"Pruebe a decir 'cruz'."			
	};
	
	/**********************************
	 ********** GENERICO **************
	 **********************************/
	// STOP
	public static final String[] STOP_DEFAULT_EMPTY = {
			"Si te ha gustado nuestra skill danos cinco estrellas.", 
			"Gracias por escucharnos." };

	public static final String[] LIVE_CHOOSE_EVENT_DIDNT_UNDERSTAND = {
			"Perdona, no te he entendido",
			"No he entendido qué es lo que quieres escuchar",
			"Perdona no te he entendido ¿Puedes repetirlo?",
			"Perdona, ¿puedes repetirlo?", 
			"Perdona, ¿Que has dicho?"
	};
	
	// HELP GENERIC PROMPT
	public static final String[] HELP_GENERIC_PROMPT = {
			"No te he entendido.", 
			"No he entendido qué es lo que quieres escuchar.",
			"Perdona, No te he entendido.", 
			"Perdona, ¿puedes repetirlo?",
			"Perdona, ¿Que has dicho?"
	};
	
	//PAUSE
	public static final String[] PAUSE_DEFAULT = {
			"Para seguir puedes decir 'Alexa, continuar', o para terminar puedes decir 'Alexa, cancela'.",
			"Para reanudar puede decir 'Alexa, continuar', y para terminar puede decir 'Alexa, cancela'"
	};	

	// NOT IMPLEMENTED
	public static final String NOT_IMPLEMENTED_REPEAT    = "La opción repite estará disponible en próximas versiones.";
	public static final String NOT_IMPLEMENTED_NEXT      = "La opción de reproducir siguiente estará disponible en próximas versiones.";
	public static final String NOT_IMPLEMENTED_PREVIOUS  = "La opción de reproducir anterior estará disponible en próximas versiones.";
	public static final String NOT_IMPLEMENTED_STARTOVER = "La opción de empezar de nuevo un directo estará disponible en próximas versiones.";
	public static final String NOT_IMPLEMENTED_SHUFFLE   = "La opción de reproducción aleatoria estará disponible en próximas versiones.";
	public static final String NOT_IMPLEMENTED_LOOP      = "La opción de reproducción en bucle estará disponible en próximas versiones.";
}