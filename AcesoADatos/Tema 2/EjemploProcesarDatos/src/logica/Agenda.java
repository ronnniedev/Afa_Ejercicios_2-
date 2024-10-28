package logica;

import java.util.LinkedList;
import java.util.List;

public class Agenda {
	
	private List<Persona>personas;
	
	public Agenda() {
		this.personas = new LinkedList<Persona>();
	}
	
	public void addPersona(Persona p) {
		personas.add(p);
		
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	
}
