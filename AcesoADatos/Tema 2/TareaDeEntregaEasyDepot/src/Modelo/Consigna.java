package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Consigna {
	
	private int id;
	private int numeroReservas;
	private List <Reserva> reservas;
	private int ingresos;
	private String direccion;
	
	public Consigna(int id, int numeroReservas, List<Reserva> reservas, int ingresos
					, String direccion) {
		this.id = id;
		this.numeroReservas = numeroReservas;
		this.reservas = new ArrayList<Reserva>();
		this.ingresos = ingresos;
		this.direccion = direccion;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the numeroReservas
	 */
	public int getNumeroReservas() {
		return numeroReservas;
	}

	/**
	 * @param numeroReservas the numeroReservas to set
	 */
	public void setNumeroReservas(int numeroReservas) {
		this.numeroReservas = numeroReservas;
	}

	/**
	 * @return the reservas
	 */
	public List<Reserva> getReservas() {
		return reservas;
	}

	/**
	 * @param reservas the reservas to set
	 */
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	/**
	 * @return the ingresos
	 */
	public int getIngresos() {
		return ingresos;
	}

	/**
	 * @param ingresos the ingresos to set
	 */
	public void setIngresos(int ingresos) {
		this.ingresos = ingresos;
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

	@Override
	public String toString() {
		return "Consigna [id=" + id + ", numeroReservas=" + numeroReservas + ", reservas=" 
				+ reservas + ", ingresos="+ ingresos + ", direccion=" + direccion + "]";
	}
	
	
	
	

}
