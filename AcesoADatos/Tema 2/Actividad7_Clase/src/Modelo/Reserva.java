package Modelo;

public class Reserva {
	
	private int codigo;
	private int codHabitacion;
	private String dni;
	private String fecha;
	
	public Reserva(int codigo, int codHabitacion, String dni, String fecha) {
		this.codigo = codigo;
		this.codHabitacion = codHabitacion;
		this.dni = dni;
		this.fecha = fecha;
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
	 * @return the codHabitacion
	 */
	public int getCodHabitacion() {
		return codHabitacion;
	}
	/**
	 * @param codHabitacion the codHabitacion to set
	 */
	public void setCodHabitacion(int codHabitacion) {
		this.codHabitacion = codHabitacion;
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
	@Override
	public String toString() {
		return "Reserva [codigo=" + codigo + ", codHabitacion=" 
				+ codHabitacion + ", dni=" + dni + ", fecha=" + fecha
				+ "]";
	}
	
	

}
