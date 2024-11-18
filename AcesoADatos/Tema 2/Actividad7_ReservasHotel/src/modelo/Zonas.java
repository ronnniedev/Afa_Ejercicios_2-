package modelo;

public class Zonas {
	
	private int codigo;
	private String nombre;
	private String descripcion;
	
	public Zonas(int codigo, String nombre, String descripcion) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Zonas [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	
	

}
