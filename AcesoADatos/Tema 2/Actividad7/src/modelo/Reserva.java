package modelo;

import excepciones.PersistenciaException;

public class Reserva {
	
	private int codigo;
	private int codigoHabitacion;
	private String dni;
	private String fechaEntrada;
	
	public Reserva(int codigo, int codigoHabitacion, String dni, String fechaEntrada) {
		this.codigo = codigo;
		this.codigoHabitacion = codigoHabitacion;
		this.dni = dni;
		this.fechaEntrada = fechaEntrada;
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
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the fechaEntrada
	 */
	public String getFechaEntrada() {
		return fechaEntrada;
	}

	/**
	 * @param fechaEntrada the fechaEntrada to set
	 */
	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	

	/**
	 * @return the codigoHabitacion
	 */
	public int getCodigoHabitacion() {
		return codigoHabitacion;
	}

	/**
	 * @param codigoHabitacion the codigoHabitacion to set
	 */
	public void setCodigoHabitacion(int codigoHabitacion) {
		this.codigoHabitacion = codigoHabitacion;
	}

	@Override
	public String toString() {
		return "Reserva [codigo=" + codigo + ", codigoHabitacion=" + codigoHabitacion + ", dni=" + dni
				+ ", fechaEntrada=" + fechaEntrada + "]";
	}

	public static Reserva serialize(String linea) throws PersistenciaException {
		String trozos[] =  linea.split("\t");
		
		if(trozos.length != 5) {
			throw new PersistenciaException("ERROR linea que tiene numero erroneo de categorias");
		}
		
		int codigo = Integer.parseInt(trozos[1]);
		int codigoHabitacion = Integer.parseInt(trozos[2]);
		String dni = trozos[3];
		String fechaEntrada = trozos[4];
		
		return new Reserva(codigo,codigoHabitacion,dni,fechaEntrada);
	}

	public static String serialize(Reserva r) {
		return "4" + "\t" + r.getCodigo() + "\t" + r.getCodigoHabitacion() 
		+ "\t" + r.getDni() + "\t" + r.getFechaEntrada() + "\n";
	}
	

	
	
}
