package clases;

public class Inmueble {

	private String codInmueble;
	private String direccion;
	private String tipo;
	private String codEmpleado;
	private double precio;
	
	public Inmueble(String codInmueble, String direccion, 
						String tipo, String codEmpleado, double precio) {
		this.codInmueble = codInmueble;
		this.direccion = direccion;
		this.tipo = tipo;
		this.codEmpleado = codEmpleado;
		this.precio = precio;
	}
	
	public Inmueble(String linea) {
		String trozos[] = linea.split(";");
		this.codInmueble = trozos[0];
		this.direccion = trozos[1];
		this.tipo = trozos[2];
		this.codEmpleado = trozos[3];
		try {
		this.precio = Double.parseDouble(trozos[4]);
		}catch(NumberFormatException e) {
			System.out.println("Numero mal insertado");
		}
		
	}

	public String getCodInmueble() {
		return codInmueble;
	}

	public void setCodInmueble(String codInmueble) {
		this.codInmueble = codInmueble;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	@Override
	public String toString() {
		return "Inmueble [codInmueble=" + codInmueble 
				+ ", direccion=" + direccion + ", tipo=" 
				+ tipo + ", codEmpleado="+ codEmpleado 
				+ ", precio=" + precio + "]";
	}
	
	public String serielize() {
		return this.codInmueble + ";" + this.direccion + ";" + this.tipo + ";" + this.codEmpleado 
					+ ";" + this.precio;
	}
	
	
	
	
}
