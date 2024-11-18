package modelo;

import excepciones.PersistenciaException;

public class Mecanico {

	private String dni;
	private String nombre;
	private String apellidos;
	
	
	public Mecanico(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
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
		return "Mecanico [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	public static Mecanico serializeMecanico(String linea) throws PersistenciaException {
		String trozos[] = linea.split("@");
		if(trozos.length != 4) {
			throw new PersistenciaException("ERROR a este mecanico le sobra o falta un atributo");
		}
		
		String dni = trozos[1];
		String nombre = trozos[2];
		String apellidos = trozos[3];
		
		return new Mecanico(dni,nombre,apellidos);
	}
	public static String serializeMecanico(Mecanico m) {
		
		return "2" + "@" + m.getDni() + "@" + m.getNombre() + "@" + m.getApellidos() + "\n";
	}
	
	
}
