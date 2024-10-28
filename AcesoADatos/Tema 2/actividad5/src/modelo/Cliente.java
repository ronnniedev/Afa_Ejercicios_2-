package modelo;

import java.util.LinkedList;
import java.util.List;

import excepciones.PersistenciaException;

public class Cliente {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private List <Pelicula> peliculasAlquiladas;
	
	public Cliente(String dni, String nombre, String apellidos, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.peliculasAlquiladas = new LinkedList<Pelicula>();
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
	 * @return the peliculasAlquiladas
	 */
	public List<Pelicula> getPeliculasAlquiladas() {
		return peliculasAlquiladas;
	}

	/**
	 * @param peliculasAlquiladas the peliculasAlquiladas to set
	 */
	public void setPeliculasAlquiladas(List<Pelicula> peliculasAlquiladas) {
		this.peliculasAlquiladas = peliculasAlquiladas;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos 
				+ ", telefono=" + telefono+"]";
	}

	public static Cliente serialize(String linea) throws PersistenciaException {
		String trozos[] = linea.split("@");
		
		if(trozos.length != 5) {
			throw new PersistenciaException("Cliente tiene parametros de mas o menos");
		}
		
		return new Cliente(trozos[1],trozos[2],trozos[3],trozos[4]);
	}

	public void addAlquiler(Pelicula pelicula){
		
		
	}

	public static String serialize(Cliente c) {
		return "1@"+c.getDni() + "@" + c.getApellidos() 
				+ "@" + c.getNombre() + "@" + c.getTelefono() + "\n";
	}
	
	
	
	

}
