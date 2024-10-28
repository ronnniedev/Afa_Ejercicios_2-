package Modelo;

import java.util.ArrayList;
import java.util.List;

import Excepciones.ExcepcionLogica;

public class Mecanico {
	
	private String DNI;
	private String nombre;
	private String apellidos;
	
	public Mecanico(String dNI, String nombre, String apellidos) {
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	/**
	 * @return the dNI
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * @param dNI the dNI to set
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
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
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Mecanico [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
	
	

}
