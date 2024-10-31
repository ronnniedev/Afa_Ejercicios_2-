package Modelo;

import Excepciones.PersistenciaException;

public class Cliente {
	
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private String contraseña;
	private int numeroReservas;
	private int puntosTienda;
	
	
	/**
	 * Constructor de 7 parametros de la clase Cliente
	 * @param nombre : String
	 * @param apellidos : String
	 * @param telefono : String
	 * @param email : String 
	 * @param contraseña : String
	 * @param numeroReservas : int
	 * @param puntosTienda : int
	 */
	public Cliente(String nombre, String apellidos, String telefono, String email, 
			String contraseña, int numeroReservas,int puntosTienda) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.contraseña = contraseña;
		this.numeroReservas = numeroReservas;
		this.puntosTienda = puntosTienda;
	}
	
	/**
	 * Constructor de 5 parametros de la clase Cliente
	 * @param nombre : String
	 * @param apellidos : String
	 * @param telefono : String
	 * @param email : String
	 * @param contraseña : String
	 */
	public Cliente(String nombre, String apellidos, String telefono, String email, String contraseña) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.contraseña = contraseña;
		int numeroReservas = 0;
		int puntosTienda = 0;
	}

	/**
	 * Metodo get de nombre de la clase Cliente
	 * @return nombre : String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo set de nombre de la clase Cliente
	 * @param nombre : String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo get de apellidos de la clase Cliente
	 * @return apellidos : String
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Metodo set de apellidos de la clase Cliente
	 * @param apellidos : String
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Metodo get de telefono de la clase Cliente
	 * @return telefono : String
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Meetodo set de telefono de la clase Cliente
	 * @param telefono : String
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Metodo get de email de la clase Cliente
	 * @return email : String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo set de email de la clase Cliente
	 * @param email : String
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo get de password de la clase Cliente
	 * @return contraseña : String
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * Metodo set de contraseña de la clase Cliente
	 * @param contraseña : String
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * Metodo numeroReservas de la clase Cliente
	 * @return numeroReservas : int
	 */
	public int getNumeroReservas() {
		return numeroReservas;
	}

	/**
	 * Metodo numeroReservas de la clase Cliente
	 * @param numeroReservas : int
	 */
	public void setNumeroReservas(int numeroReservas) {
		this.numeroReservas = numeroReservas;
	}

	/**
	 * Metodo get de puntosTienda de la clase Cliente
	 * @return puntosTienda : int
	 */
	public int getPuntosTienda() {
		return puntosTienda;
	}

	/**
	 * Metodo set de PuntosTienda de la clase Cliente
	 * @param puntosTienda
	 */
	public void setPuntosTienda(int puntosTienda) {
		this.puntosTienda = puntosTienda;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + 
				", email=" + email.toString()
				+ ", contraseña=" + contraseña 
				+ ", numeroReservas=" + numeroReservas 
				+ ", puntosTienda=" + puntosTienda
				+ "]";
	}

	/**
	 * Serializa una linea en formato String para convertirlo en un objeto cliente y posteriormente
	 * cargarlo en el sistema
	 * @param linea : String
	 * @return Cliente
	 * @throws PersistenciaException
	 */
	public static Cliente serializeCliente(String linea) throws PersistenciaException {
		String trozos[] = linea.split(";");
		
		if(trozos.length != 8) {
			throw new PersistenciaException("Linea mal formateada");
		}
		
		String nombre = trozos[1];
		String apellidos = trozos[2];
		String telefono = trozos[3];
		String email = trozos[4];
		String contraseña = trozos[5];
		int numeroReservas = Integer.parseInt(trozos[6]);
		int puntosTienda = Integer.parseInt(trozos[7]);
		
		return new Cliente(nombre,apellidos,telefono,email,contraseña,numeroReservas,puntosTienda);
	}



	/**
	 * Tranforma un cliente a formato String siguiendo el formato proprocionado para su guardado
	 * @param c : Cliente
	 * @return String
	 */
	public static String serializeCliente(Cliente c) {
		return 1 + ";" + c.getNombre() + ";" + c.getApellidos() + ";" + c.getTelefono() + ";" 
					+ c.getEmail() + ";" + c.getContraseña() + ";" + c.getNumeroReservas() 
					+ ";" + c.getPuntosTienda() + "\n";
	}
	
	
	
	

}
