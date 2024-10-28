package ejercicio2;

public class Contacto {
	
	private String nombre;
	private Telefono telefono;
	private String direccion;
	
	
	public Contacto(String nombre, Telefono telefono, String direccion) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
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


	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono.getTelefono() + 
				", direccion=" + direccion + "]";
	}
	
	

	
}
