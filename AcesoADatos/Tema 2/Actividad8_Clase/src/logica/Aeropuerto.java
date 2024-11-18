package logica;

import java.util.ArrayList;
import java.util.List;

import excepciones.LogicaException;
import modelo.Compañia;
import modelo.Pasajero;
import modelo.Vuelo;

public class Aeropuerto {
	private List <Compañia> compañias;
	
	public Aeropuerto() {
		this.compañias = new ArrayList<Compañia>();
	}
	
	public Compañia buscarCompañia(String nombre) {
		
		for(Compañia c: compañias) {
			if(c.getNombre().compareTo(nombre) == 0) {
				return c;
			}
		}
		return null;
	}
	
	public Vuelo buscarVuelo(String codVuelo) {
		for(Compañia c: compañias) {
			for(Vuelo v: c.getVuelos()) {
				if(v.getCodigo().compareTo(codVuelo) == 0) {
					return v;
				}
			}
		}
		return null;
	}
	
	public Pasajero buscarPasajero(String dni) {
		for(Compañia c: compañias) {
			for(Vuelo v: c.getVuelos()) {
				for(Pasajero p: v.getPasajeros()) {
					if(p.getDni().compareTo(dni) == 0) {
						return p;
					}
				}
			}
		}
		return null;
	}
	
	public void addCompañia(Compañia c) throws LogicaException {
		if(buscarCompañia(c.getNombre())!= null) {
			throw new LogicaException("Error compañia duplicada");
		}
		
		compañias.add(c);
		
	}

	public void addVuelo(Vuelo v) throws LogicaException {
		Compañia c = buscarCompañia(v.getCompañia());
		if(c == null) {
			throw new LogicaException("ERROR compañia no encontrada");
		}
		c.getVuelos().add(v);
	}
	
	
	
}
