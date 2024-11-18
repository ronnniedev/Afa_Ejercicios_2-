package modelo;

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
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodHabitacion() {
		return codHabitacion;
	}
	public void setCodHabitacion(int codHabitacion) {
		this.codHabitacion = codHabitacion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Reserva [codigo=" + codigo + ", codHabitacion=" + codHabitacion + ", dni=" + dni + ", fecha=" + fecha
				+ "]";
	}
	
	
	
}
