package ejemploClase;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Agenda {
	
	private Map<Dni,Persona>personas;

	public Agenda() {
		
		this.personas = new HashMap <Dni,Persona>();
	}
	
	public void addPersona(Persona p) {
		personas.put(p.getDni(), p);
	}
	
	public String mostrar() {
		String cadena = "Datos persona \n";
		Collection <Persona> coleccion = personas.values();
		
		for(Persona p: coleccion) {
			cadena += p.toString()+"\n";
		}
		cadena += "*****************";
		cadena += "Conjunto de clave \n";
		Set<Dni> claves = personas.keySet();
		
		for(Dni d: claves) {
			cadena += d.toString() + "\n";
		}
		
		cadena += "**********************";
		cadena += "Pares <clave,Valor> \n";
		
		Set <Entry<Dni,Persona>> pares = personas.entrySet();
		for(Entry<Dni,Persona> par:pares) {
			Dni dniDato = par.getKey();
			Persona pDato = par.getValue();
			cadena += "Clave :" + dniDato.toString()+"\n";
			cadena += "\t Item: " + pDato.toString() + "\n";
			
		}
		return cadena;
			
	}
	
	public Persona buscar(Dni dni) {
		return personas.get(dni);
		
	}

	
}
