package ejercicio2;

public class Reserva {
	
	private Cliente cliente;
	private Habitacion habitacion;
	private String fecha;
	private int dias;
	
	public Reserva(Cliente cliente, Habitacion habitacion, String fecha,int dias) {
		this.cliente = cliente;
		this.habitacion = habitacion;
		this.fecha = fecha;
		this.dias = dias;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	@Override
	public String toString() {
		return "Reserva [cliente=" + cliente + ", habitacion=" 
				+ habitacion + ", fecha=" + fecha + ", dias=" + dias
				+ "]";
	}
	
	
	
	

}
