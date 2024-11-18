package modelo;

import excepciones.PersistenciaException;

public class Pasajero {
	
	private String codigo;
	private String dni;
	private String nombre;
	private String direccion;
	private String telefono;
	private String clase;
	
	public Pasajero(String codigo, String dni, String nombre, String direccion, String telefono, String clase) {
		this.codigo = codigo;
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.clase = clase;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	/**
	 * @return the clase
	 */
	public String getClase() {
		return clase;
	}

	/**
	 * @param clase the clase to set
	 */
	public void setClase(String clase) {
		this.clase = clase;
	}

	@Override
	public String toString() {
		return "Pasajero [codigo=" + codigo + ", dni=" + dni + ", nombre=" 
				+ nombre + ", direccion=" + direccion+ ", telefono=" + telefono + ", clase=" 
				+ clase + "]";
	}

	public static Pasajero serializePasajero(String[] trozos) throws PersistenciaException {
		if(trozos.length != 7) {
			throw new PersistenciaException("Error falta o sobra un atributo en este pasajero");
		}
		
		String codigo = trozos[1];
		String dni = trozos [2];
		String nombre = trozos[3];
		String direccion = trozos [4];
		String telefono = trozos[5];
		String clase = trozos[6];
	
		
		return new Pasajero(codigo,dni,nombre,direccion,telefono,clase);
	}

	public String serializePasajero() {
		return "3\t" + this.codigo + "\t" + this.dni + "\t" + this.nombre 
				+ "\t" + this.direccion + "\t" + this.telefono + "\t" + this.clase;
	}
	
	
	

}
