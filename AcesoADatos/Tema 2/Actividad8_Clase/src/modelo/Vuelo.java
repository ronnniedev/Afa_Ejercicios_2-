package modelo;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {

	private String codigo;
	private String compañia;
	private String destino;
	private String horaLlegada;
	private String horaSalida;
	private char puerta;
	
	private List <Pasajero> pasajeros;

	
	public Vuelo(String codigo, String compañia, String destino, 
			String horaLlegada, String horaSalida, char puerta) {
		this.codigo = codigo;
		this.compañia = compañia;
		this.destino = destino;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.puerta = puerta;
		this.pasajeros = new ArrayList<Pasajero>();
	}


	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}


	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	/**
	 * @return the compañia
	 */
	public String getCompañia() {
		return compañia;
	}


	/**
	 * @param compañia the compañia to set
	 */
	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}


	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}


	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}


	/**
	 * @return the horaLlegada
	 */
	public String getHoraLlegada() {
		return horaLlegada;
	}


	/**
	 * @param horaLlegada the horaLlegada to set
	 */
	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}


	/**
	 * @return the horaSalida
	 */
	public String getHoraSalida() {
		return horaSalida;
	}


	/**
	 * @param horaSalida the horaSalida to set
	 */
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}


	/**
	 * @return the puerta
	 */
	public char getPuerta() {
		return puerta;
	}


	/**
	 * @param puerta the puerta to set
	 */
	public void setPuerta(char puerta) {
		this.puerta = puerta;
	}


	/**
	 * @return the pasajeros
	 */
	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}


	/**
	 * @param pasajeros the pasajeros to set
	 */
	public void setPasajeros(List<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}


	@Override
	public String toString() {
		String texto = "Vuelo [codigo=" + codigo + ", compañia=" + compañia + ", destino=" + destino 
				+ ", horaLlegada="+ horaLlegada + ", horaSalida=" + horaSalida + "]\n"
				+ ", puerta=" + puerta ;
		
		for(Pasajero p: pasajeros) {
			texto += p.toString() + "\n";
		}
		
		return texto;
	}
	
	public void addPasajero(Pasajero p) {
		pasajeros.add(p);
	}
	
	
}
