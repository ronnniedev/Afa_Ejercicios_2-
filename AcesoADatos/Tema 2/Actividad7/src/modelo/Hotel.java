package modelo;

import excepciones.PersistenciaException;

public class Hotel {
	
	private int codigo;
	private int codigoZona;
	private String nombre;
	private Character tipo;
	private int estrellas;
	
	public Hotel(int codigo,int codigoZona, String nombre, Character tipo, int estrellas) {
		this.codigo = codigo;
		this.codigoZona = codigoZona;
		this.nombre = nombre;
		this.tipo = tipo;
		this.estrellas = estrellas;
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
	 * @return the tipo
	 */
	public Character getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the estrellas
	 */
	public int getEstrellas() {
		return estrellas;
	}

	/**
	 * @param estrellas the estrellas to set
	 */
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	

	/**
	 * @return the codigoZona
	 */
	public int getCodigoZona() {
		return codigoZona;
	}

	/**
	 * @param codigoZona the codigoZona to set
	 */
	public void setCodigoZona(int codigoZona) {
		this.codigoZona = codigoZona;
	}
	
	

	@Override
	public String toString() {
		return "Hotel [codigo=" + codigo + ", codigoZona=" 
				+ codigoZona + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", estrellas=" + estrellas + "]";
	}

	public static Hotel serialize(String linea) throws PersistenciaException {
		String trozos[] = linea.split("\t");
		
		if(trozos.length != 6) {
			throw new PersistenciaException("Error faltan o sobran categorias");
		}
		
		int codigo = Integer.parseInt(trozos[1]);
		int codigoZona = Integer.parseInt(trozos[2]);
		String nombre = trozos[3];
		Character tipo = trozos[4].charAt(0);
		int estrellas = Integer.parseInt(trozos[5]);
		return new Hotel(codigo,codigoZona,nombre,tipo,estrellas);
	}

	public static String serialize(Hotel h) {
		
		return "2" + "\t" + h.getCodigo() + "\t" + h.getCodigoZona() + "\t" + h.getNombre() 
		+ "\t" + h.getTipo() + "\t" + h.getEstrellas() + "\n";
	}
	
	
	

}
