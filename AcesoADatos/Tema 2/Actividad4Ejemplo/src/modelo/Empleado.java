package modelo;

import excepciones.PersistenciaException;

public class Empleado {
	private String codEmpleado;
	private String nombre;
	private String telefono;
	public Empleado(String codEmpleado, String nombre, String telefono) {
		super();
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	/**
	 * @return the codEmpleado
	 */
	public String getCodEmpleado() {
		return codEmpleado;
	}
	/**
	 * @param codEmpleado the codEmpleado to set
	 */
	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
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
		return "Empleado [codEmpleado=" + codEmpleado + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	public static Empleado serialize(String linea) throws PersistenciaException {
		
		
		String trozos[] = linea.split(";");

		if(trozos.length != 3) {
			throw new PersistenciaException("No tiene el tamaño correctop el serial");
		}
		Empleado nuevo = new Empleado(trozos[0],trozos[1],trozos[2]);
		
		return nuevo;
	}
	public static String serialize(Empleado e) {
		return e.getCodEmpleado() + ";" + e.getNombre() + ";" + e.getTelefono() + "\n";
	}
	
	

}
