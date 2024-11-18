package modelo;

import java.util.ArrayList;
import java.util.List;

import excepciones.PersistenciaException;

public class Vuelo {
	
	private String codigo;
	private String compañia;
	private String destino;
	private String horaSalida;
	private String horaLlegada;
	private char puerta;
	private List <Pasajero> pasajeros;
	
	public Vuelo(String codigo, String compañia, String destino,
			String horaSalida, String horaLlegada, char puerta) {
		this.codigo = codigo;
		this.compañia = compañia;
		this.destino = destino;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
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
		String texto = "Vuelo [codigo=" + codigo + ", compañia=" + compañia + ", destino=" + destino + ", horaSalida="
				+ horaSalida + ", horaLlegada=" + horaLlegada + ", puerta=" + puerta + "]\n";
		return texto;
				
	}

	public static Vuelo serializeVuelo(String[] trozos) throws PersistenciaException {
		
		if(trozos.length != 7) {
			throw new PersistenciaException("Error falta o sobra un atributo en este vuelo");
		}
		
		String codigo = trozos[1];
		String compañia = trozos [2];
		String destino = trozos [3];
		String horaSalida = trozos [4];
		String horaLlegada = trozos[5];
		char puerta = trozos[6].charAt(0);
	
		return new Vuelo(codigo,compañia,destino,horaSalida,horaLlegada,puerta);
	}

	public String serializeVuelo() {
		return "2\t"+ this.codigo + "\t" + this.compañia + "\t" + this.destino + "\t" 
				+ this.horaSalida + "\t" + this.horaLlegada+ "\t" + this.puerta;
	}
	
	
	
	

}
