package Modelo;

import java.util.ArrayList;
import java.util.List;

import Excepciones.PersistenciaException;

public class Cliente implements Serialize{
	
	private String DNI;
	private String nombre;
	private String apellidos;
	private String telefono;
	private List<Video> videos;

	public Cliente(String dni, String apellido, String nombre, String telefono) {
		this.DNI = dni;
		this.nombre = nombre;
		this.apellidos = apellido;
		this.telefono = telefono;
		this.videos = new ArrayList<Video>();
	}
	
	public Cliente() {
		
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
	 * @return the videos
	 */
	public List<Video> getVideos() {
		return videos;
	}

	/**
	 * @param videos the videos to set
	 */
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
	public void addAlquiler(Video v) {
		videos.add(v);
	}

	@Override
	public String toString() {
		String texto = "";
		
		texto += "Cliente [DNI=" + DNI + ", nombre=" + nombre 
				+ ", apellidos=" + apellidos + ", telefono=" + telefono+ "]\n";
				
		for(Video v:videos) {
			texto += v.toString() +"\n";
			
		}
		return texto;
	}

	public String serialize(Object obj) {
		Cliente c = (Cliente) obj;
		String linea = "1@" + c.getDNI() +"@"+ c.getApellidos() + "@" 
						+ c.getNombre() + "@" + c.getTelefono() + "\n";
		
		return linea;
	}

	public Object serialize(String linea) throws PersistenciaException {
		String trozos[] = linea.split("@");
		if(trozos.length !=5) {
			throw new PersistenciaException("ERROR registro cliente incorrecto");
		}
		return new Cliente(trozos[1],trozos[2],trozos[3],trozos[4]);
	}
	
	

}
