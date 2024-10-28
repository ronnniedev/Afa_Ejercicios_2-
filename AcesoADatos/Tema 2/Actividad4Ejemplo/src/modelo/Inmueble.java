package modelo;

import excepciones.PersistenciaException;

public class Inmueble {
	private String codInmueble;
	private String direccion;
	private String tipo;
	private String codEmpleado;
	private double precio;
	
	public Inmueble(String codInmueble, String direccion, String tipo,
			String codEmpleado, double precio) {
		this.codInmueble = codInmueble;
		this.direccion = direccion;
		this.tipo = tipo;
		this.codEmpleado = codEmpleado;
		this.precio = precio;
	}

	/**
	 * @return the codInmueble
	 */
	public String getCodInmueble() {
		return codInmueble;
	}

	/**
	 * @param codInmueble the codInmueble to set
	 */
	public void setCodInmueble(String codInmueble) {
		this.codInmueble = codInmueble;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the codEmpleado
	 */
	public String getCodEmpleado() {
		return codEmpleado;
	}

	/**
	 * @param codEmpleado the codEmpleado to set
	 */
	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Inmueble [codInmueble=" + codInmueble + 
				", direccion=" + direccion + ", tipo=" + tipo + ", codEmpleado="
				+ codEmpleado + ", precio=" + precio + "]";
	}

	public static Inmueble serialize(String linea) throws PersistenciaException {
		String trozos[] = linea.split(";");
		if(trozos.length != 5) {
			throw new PersistenciaException("ERROR inmueble mal formado");
		}
		String codigo = trozos[0];
		String direccion = trozos[1];
		String tipo = trozos[2];
		String codEmpleado = trozos[3];
		try {
		double precio = Double.parseDouble(trozos[4]);
		return new Inmueble(codigo,direccion,tipo,codEmpleado,precio);
		}catch(Exception e) {
			throw new PersistenciaException("ERROR precio mal formado");
		}
		
		
	}

	public static String serialize(Inmueble i) {
		
		return i.getCodInmueble() + ";" + i.getDireccion() + ";" + i.getTipo() + ";" 
		+ i.getCodEmpleado() + ";" + i.getPrecio() + "\n";
	}
	
	
	
	

}
