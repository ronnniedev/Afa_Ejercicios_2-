package modelo;

import excepciones.PersistenciaException;

public class Vehiculo {
	
	private String matricula;
	private String marcaModelo;
	private String tipo;
	private String nombre;
	private String telefono;
	
	public Vehiculo(String matricula, String marcaModelo, String tipo, String nombre, String telefono) {
		this.matricula = matricula;
		this.marcaModelo = marcaModelo;
		this.tipo = tipo;
		this.nombre = nombre;
		this.telefono = telefono;
	}
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
		return "Vehiculo [matricula=" + matricula + ", marcaModelo=" + marcaModelo + ", tipo=" + tipo + ", nombre="
				+ nombre + ", telefono=" + telefono + "]";
	}
	public static Vehiculo serializeVehiculo(String linea) throws PersistenciaException {
		String trozos[] = linea.split("@");
		if(trozos.length != 6) {
			throw new PersistenciaException("ERROR a este vehiculo le sobra o falta un atributo");
		}
		
		String matricula = trozos[1];
		String marcaModelo = trozos[2];
		String tipo = trozos[3];
		String nombre = trozos[4];
		String telefono = trozos[5];
		
		return new Vehiculo(matricula,marcaModelo,tipo,nombre,telefono);
	}
	public static String serializeVehiculo(Vehiculo v) {
		return "1" + "@" + v.getMatricula() + "@" + v.getMarcaModelo() + "@" + v.getTipo() + "@" + 
				v.getNombre() + "@" + v.getTelefono() + "\n";
		
	}
	

}
