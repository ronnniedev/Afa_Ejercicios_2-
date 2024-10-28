package ejercicio4;

import java.util.Objects;

public class DireccionHTTP {
	
	private String servidor;
	private int puerto;
	private String direccion;
	
	public DireccionHTTP(String servidor, int puerto, String direccion) {
		this.servidor = servidor;
		this.puerto = puerto;
		this.direccion = direccion;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public String getDireccion() {
		return direccion;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(direccion, puerto, servidor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DireccionHTTP other = (DireccionHTTP) obj;
		return other.getServidor().compareTo(servidor) == 0;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "DireccionHTTP [servidor=" + servidor + 
				", puerto=" + puerto + ", direccion=" + direccion + "]";
	}
	
	
	
	
	

}
