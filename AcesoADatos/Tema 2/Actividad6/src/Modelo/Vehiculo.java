package Modelo;

import java.util.ArrayList;
import java.util.List;

import Excepciones.ExcepcionLogica;

public class Vehiculo {
	
	private String matricula;
	private String marcaModelo;
	private String tipo;
	private String nombreApellidos;
	private String telefono;
	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	/**
	 * @return the marcaModelo
	 */
	public String getMarcaModelo() {
		return marcaModelo;
	}
	/**
	 * @param marcaModelo the marcaModelo to set
	 */
	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the nombreApellidos
	 */
	public String getNombreApellidos() {
		return nombreApellidos;
	}
	/**
	 * @param nombreApellidos the nombreApellidos to set
	 */
	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marcaModelo=" + marcaModelo + ", tipo=" + tipo
				+ ", nombreApellidos=" + nombreApellidos + ", telefono=" + telefono + "]";
	}
	
	
	

}
