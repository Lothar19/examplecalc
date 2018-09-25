package com.drc.alexa.frases1.handlers;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class Frases1StreamHandler extends SkillStreamHandler {

	public Frases1StreamHandler() {
		super(getSkill());
	}

	/**
	 * Configuramos todos los handler que va a utilizar nuestra skill
	 * @return
	 */
	private static Skill getSkill() {
		return Skills.standard().addRequestHandlers(
			new SessionEndedRequestHandler(), 
			new ExceptionOcurredRequestHandler(),
			new LaunchRequestHandler(), 
			new NombresMascotasIntentHandler(), 
			new ExitSkillHandler(), 
			new HelpIntentHandler(),
			new LoopIntentHandler(), 
			new NextIntentHandler(), 
			new PauseIntentHandler(),
			new PreviousIntentHandler(), 
			new RepeatIntentHandler(), 
			new ResumeIntentHandler(),
			new ShuffleIntentHandler(), 
			new StartOverIntentHandler())
			.build();
	}
}