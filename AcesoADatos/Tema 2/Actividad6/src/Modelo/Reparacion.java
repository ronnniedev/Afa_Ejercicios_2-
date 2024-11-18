package modelo;

import excepciones.PersistenciaException;

public class Reparacion {

	private int codigo;
	private String dniMecanico;
	private String matricula;
	private String fecha;
	private double importe;
	private String descripcion;
	
	public Reparacion(int codigo, String dniMecanico, String matricula, String fecha, double importe,
			String descripcion) {
		this.codigo = codigo;
		this.dniMecanico = dniMecanico;
		this.matricula = matricula;
		this.fecha = fecha;
		this.importe = importe;
		this.descripcion = descripcion;
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
	 * @return the dniMecanico
	 */
	public String getDniMecanico() {
		return dniMecanico;
	}

	/**
	 * @param dniMecanico the dniMecanico to set
	 */
	public void setDniMecanico(String dniMecanico) {
		this.dniMecanico = dniMecanico;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Reparacion [codigo=" + codigo + ", dniMecanico=" + dniMecanico + ", matricula=" 
				+ matricula + ", fecha="+ fecha + ", importe=" + importe + ", descripcion=" 
				+ descripcion + "]";
	}

	public static Reparacion serializeReparacion(String linea) throws PersistenciaException {
		String trozos[] = linea.split("@");
		if(trozos.length != 7) {
			throw new PersistenciaException("ERROR a esta reparacion le sobra o falta un atributo");
		}
		
		int codigo = Integer.parseInt(trozos[1]);
		String dniMecanico = trozos[2];
		String matricula = trozos[3];
		String fecha = trozos[4];
		double importe = Double.parseDouble(trozos[5]);
		String descripcion = trozos[6];
		
		return new Reparacion(codigo,dniMecanico,matricula,fecha,importe,descripcion);
	}

	public static String serializeReparacion(Reparacion r) {
		return "3" + "@" + r.getCodigo() + "@" + r.getDniMecanico() + "@" + r.getMatricula() + "@" +
				r.getFecha() + "@" + r.getImporte() + "@" + r.getDescripcion() + "\n";
	}
	
	
	

}
