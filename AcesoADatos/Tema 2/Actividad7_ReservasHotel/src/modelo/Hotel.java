package modelo;

public class Hotel {
	
	private int codigo;
	private int codZona;
	private String nombre;
	private char tipo;
	//P.Pensión, S.Hostal, H. Hotel, R. Casa Rural.
	private int estrellas;
	
	public Hotel(int codigo, int codZona, String nombre, char tipo, int estrellas) {
		
		this.codigo = codigo;
		this.codZona = codZona;
		this.nombre = nombre;
		this.tipo = tipo;
		this.estrellas = estrellas;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public int getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	
	public int getCodZona() {
		return codZona;
	}
	public void setCodZona(int codZona) {
		this.codZona = codZona;
	}
	@Override
	public String toString() {
		return "Hotel [codigo=" + codigo + ", codZona=" + codZona + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", estrellas=" + estrellas + "]";
	}
	
	
}
