package ejemploClase;

public class Persona {
	
	private String nombre;
	private Dni dni;
	
	public Persona(String nombre, int numero,char letra) {
		this.nombre = nombre;
		this.dni = new Dni (numero,letra);
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
	 * @return the dni
	 */
	public Dni getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(Dni dni) {
		this.dni = dni;
	}
	
	

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + this.dni.getDni() + "]";
	}
	
	
	
	

}
