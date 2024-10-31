package Modelo;

public class Hotel {
	
	private int codigo;
	private int codZona;
	private String nombre;
	private Character tipo;
	private int estrellas;
	
	public Hotel(int codigo, int codZona,String nombre, Character tipo, int estrellas) {
		this.codigo = codigo;
		this.codZona = codZona;
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

	@Override
	public String toString() {
		return "Hotel [codigo=" + codigo + ", codZona=" 
				+ codZona + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", estrellas=" + estrellas + "]";
	}

	

	
	

}
