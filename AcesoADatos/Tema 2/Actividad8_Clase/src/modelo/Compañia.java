package modelo;

import java.util.ArrayList;
import java.util.List;

public class Compañia {
	
	private String nombre;
	private String destino;
	private List <Vuelo> vuelos;
	
	public Compañia(String nombre, String destino) {
		this.nombre = nombre;
		this.destino = destino;
		this.vuelos = new ArrayList<Vuelo>();
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * @return the vuelos
	 */
	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	/**
	 * @param vuelos the vuelos to set
	 */
	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	@Override
	public String toString() {
		String texto = "Compañia [nombre=" + nombre + ", destino=" + destino + "]\n";
		
		for(Vuelo v: vuelos) {
			texto += v.toString() + "\n";
		}
		
		return texto;
	}
	
	

}
