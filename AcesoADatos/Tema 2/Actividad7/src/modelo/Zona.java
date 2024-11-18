package modelo;

import excepciones.PersistenciaException;

public class Zona {
	
	private int codigo;
	private String nombre;
	private String descripcion;
	
	public Zona(int codigo, String nombre, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Zona [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

	public static Zona serialize(String linea) throws PersistenciaException {
		
		String trozos[] = linea.split("\t");
		
		if(trozos.length != 4) {
			throw new PersistenciaException("Error faltan o sobran categorias");
		}
	
		int codigo = Integer.parseInt(trozos[1]);
		String nombre = trozos[2];
		String descripcion = trozos[3];
		
		return new Zona(codigo,nombre,descripcion);
	}

	public static String serialize(Zona z) {
		return "1" + "\t" + z.getCodigo() + "\t" + z.getNombre() + "\t" + z.getDescripcion() + "\n";
	}

	
	


}
