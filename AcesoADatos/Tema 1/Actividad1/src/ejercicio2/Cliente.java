package ejercicio2;

import java.util.Objects;

public class Cliente {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private Tipo_Cliente tipo;
	private static double descuento_habituales = 0.2;
	private double descuento;
	
	public Cliente(String dni, String nombre, String apellidos, Tipo_Cliente tipo) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tipo = tipo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Tipo_Cliente getTipo() {
		return tipo;
	}

	public void setTipo(Tipo_Cliente tipo) {
		this.tipo = tipo;
	}

	
	public static double getDescuento_habituales() {
		return descuento_habituales;
	}

	public static void setDescuento_habituales(double descuento_habituales) {
		Cliente.descuento_habituales = descuento_habituales;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return other.getDni().compareTo(this.dni) == 0;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + 
				", apellidos=" + apellidos + ", tipo=" + tipo
				+ ", descuento=" + descuento + "]";
	}
	
	
	
	

}
