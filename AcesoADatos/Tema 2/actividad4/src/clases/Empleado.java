package clases;

public class Empleado {

	private String codEmpleado;
	private String nombreCompleto;
	private String telefono;
	
	public Empleado(String codEmpleado, String nombreCompleto, String telefono) {
		this.codEmpleado = codEmpleado;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
	}
	
	public Empleado(String linea) {
		String []trozos = linea.split(";");
		this.codEmpleado = trozos[0];
		this.nombreCompleto = trozos[1];
		this.telefono = trozos[2];
	}
	

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	@Override
	public String toString() {
		return "Empleado [codEmpleado=" + codEmpleado 
				+ ", nombreCompleto=" + nombreCompleto 
				+ ", telefono=" + telefono
				+ "]";
	}
	
	public String serielize() {
		return this.codEmpleado + ";" + this.nombreCompleto + ";" + this.telefono;
	}
	
	
	
}
