package logica;

import java.util.Objects;

public class Restaurante {
	
	private String nombre;
	private String direccion;
	private String ciudad;
	private String Provincia;
	private String cp;
	
	public Restaurante(String nombre, String direccion, String ciudad, String provincia, String cp) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		Provincia = provincia;
		this.cp = cp;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		return other.nombre.compareTo(this.nombre) == 0;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Restaurante [nombre=" + nombre + ", direccion=" + direccion 
				+ ", ciudad=" + ciudad + ", Provincia="
				+ Provincia + ", cp=" + cp + "]";
	}
	
	
	
	
	

}
