package logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import excepciones.LogicaException;
import modelo.Compañia;
import modelo.Pasajero;
import modelo.Vuelo;
import persistencia.GestorPersistencia;

public class GestorAeropuerto {
	
	private GestorPersistencia gestor;
	private List <Compañia> compañias;
	
	

	public GestorAeropuerto() {
		this.gestor = new GestorPersistencia(this);
		this.compañias = new ArrayList<Compañia>();
	}



	public void cargarDatos(String fichero) throws IOException {
		gestor.cargarDatos(fichero);
		
	}



	public void addCompañia(Compañia c) throws LogicaException {
		
		Compañia com = buscarCompañia(c.getNombre());
		if(com!= null) {
			throw new LogicaException("Error esta compañia ya existe");
		}
		
		compañias.add(c);
		
	}



	private Compañia buscarCompañia(String nombre) {
		
		for(Compañia c : compañias) {
			if(c.getNombre().compareTo(nombre) == 0) {
				return c;
			}
		}
		return null;
	}



	public void addVuelo(Vuelo v) throws LogicaException {
		
		Vuelo vuelo = buscarVuelo(v.getCodigo());
		
		if(vuelo != null) {
			throw new LogicaException("Error este vuelo ya existe");
		}
		
		Compañia c = buscarCompañia(v.getCompañia());
		if(c == null) {
			throw new LogicaException("Error compañia no encontrada");
		}
		c.getVuelos().add(v);
		
	}



	private Vuelo buscarVuelo(String codigo) {
		
		for(Compañia c: compañias) {
			for(Vuelo v: c.getVuelos()) {
				if(v.getCodigo().compareTo(codigo) == 0) {
					return v;
				}
			}
		}
		return null;
	}



	public void addPasajero(Pasajero p) throws LogicaException {
	
		Pasajero pasajero = buscarPasajero(p.getDni());
		if(pasajero != null) {
			throw new LogicaException("Error pasajero ya existe");
		}
		
		Vuelo v = buscarVuelo(p.getCodigo());
		
		if(v == null) {
			throw new LogicaException("Error vuelo no existe");
		}
		
		v.getPasajeros().add(p);
	}



	private Pasajero buscarPasajero(String dni) {
		
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



	public String listarCompañias() {
		String texto = "------Compañias------\n";
		for(Compañia c: compañias) {
			texto += c.toString() + "\n";
		}
		return texto;
	}



	public String listarVuelos(String nombre) throws LogicaException {
		String texto = "----------Vuelos de" + nombre + "---------------\n";
		Compañia c = buscarCompañia(nombre);
		if(c == null) {
			throw new LogicaException("Error compañia no encontrada");
		}
		for(Vuelo v: c.getVuelos()) {
			texto += v.toString() + "\n";
		}
		
		return texto;
	}



	public String listarVuelos() {
		String texto = "--------------Vuelos----------------";
		List <Vuelo>vuelosOrdenados = ordenarVuelos();
		
		for(Vuelo v: vuelosOrdenados) {
			texto += v.toString() + "\n";
		}
		return texto;
	}



	private List<Vuelo> ordenarVuelos() {
		List <Vuelo> vuelos = sacarVuelos();
		
		for (int pivote = 0; pivote < vuelos.size(); pivote++) {
			for (int i = pivote + 1; i < vuelos.size(); i++) {
				if (vuelos.get(pivote).getHoraSalida().compareTo(vuelos.get(i).getHoraSalida()) > 0) {
					Vuelo temp = vuelos.get(pivote);
					vuelos.set(pivote, vuelos.get(i));
					vuelos.set(i, temp);
				}
			}
		}
		return vuelos;
	}



	private List<Vuelo> sacarVuelos() {
		List <Vuelo>vuelos = new ArrayList<Vuelo>();
		for(Compañia c: compañias) {
			for(Vuelo v:c.getVuelos()) {
				vuelos.add(v);
			}
		}
		return vuelos;
	}



	public String listarPasajeros(String codVuelo) throws LogicaException {
		String texto = "";
		Vuelo v = buscarVuelo(codVuelo);
		if(v == null) {
			throw new LogicaException("Error vuelo no encontrado");
		}
		
		for(Pasajero p: v.getPasajeros()) {
			texto += p.toString() + "\n";
		}
		return texto;
	}



	public void eliminarVuelo(String codVuelo) throws LogicaException {
	
		Vuelo v = buscarVuelo(codVuelo);
		if(v == null) {
			throw new LogicaException("Error vuelo no encontrado");
		}
		
		Compañia c = buscarCompañia(v.getCompañia());
		if(c == null) {
			throw new LogicaException("Error compañia no encontrada");
		}
		
		c.getVuelos().remove(v);
		
	}



	public void eliminarPasajeros(String origen, String destino) throws LogicaException {
		Vuelo vueloOrigen = buscarVuelo(origen);
		if(vueloOrigen == null) {
			throw new LogicaException("Error vuelo origen no encontrado");
		}
		
		Vuelo vueloDestino = buscarVuelo(destino);
		if(vueloDestino == null) {
			throw new LogicaException("Error vuelo destino no encontrado");
		}
		
		for(Pasajero p: vueloOrigen.getPasajeros()) {
			vueloDestino.getPasajeros().add(p);
		}
		
		vueloOrigen.getPasajeros().removeAll(vueloOrigen.getPasajeros());
	}



	/**
	 * @return the gestor
	 */
	public GestorPersistencia getGestor() {
		return gestor;
	}



	/**
	 * @param gestor the gestor to set
	 */
	public void setGestor(GestorPersistencia gestor) {
		this.gestor = gestor;
	}



	/**
	 * @return the compañias
	 */
	public List<Compañia> getCompañias() {
		return compañias;
	}



	/**
	 * @param compañias the compañias to set
	 */
	public void setCompañias(List<Compañia> compañias) {
		this.compañias = compañias;
	}



	public void guardarDatos(String string) {
		gestor.guardarDatos(string);
		
	}

}
