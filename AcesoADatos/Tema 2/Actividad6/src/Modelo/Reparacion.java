package Modelo;

public class Reparacion {
	
	private int codigo;
	private String DNI;
	private String matricula;
	private String fecha;
	private double importe;
	private String descripcionTrabajo;
	
	public Reparacion(int codigo, String dNI, String matricula, String fecha, double importe,
			String descripcionTrabajo) {
		this.codigo = codigo;
		this.DNI = dNI;
		this.matricula = matricula;
		this.fecha = fecha;
		this.importe = importe;
		this.descripcionTrabajo = descripcionTrabajo;
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
	 * @return the dNI
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * @param dNI the dNI to set
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the importe
	 */
	public double getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}

	/**
	 * @return the descripcionTrabajo
	 */
	public String getDescripcionTrabajo() {
		return descripcionTrabajo;
	}

	/**
	 * @param descripcionTrabajo the descripcionTrabajo to set
	 */
	public void setDescripcionTrabajo(String descripcionTrabajo) {
		this.descripcionTrabajo = descripcionTrabajo;
	}

	@Override
	public String toString() {
		return "Reparacion [codigo=" + codigo + ", DNI Mecanico=" + DNI + 
				", matricula=" + matricula + ", fecha=" + fecha + ", importe=" + importe 
				+ ", descripcionTrabajo=" + descripcionTrabajo + "]";
	}
	
	
	
	

}
