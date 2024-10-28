package Modelo;

import java.util.Date;

public class Reserva {
	
	private String emailCliente;
	private String idRserva;
	private Date fechaInicio;
	private Date fechaExtraccion;
	private Boolean reservaFinalizada;
	private Boolean incidencia;
	private String descripciónIncidencia;
	
	public Reserva(String emailCliente, String idRserva, Date fechaInicio, Date fechaExtraccion,
			Boolean reservaFinalizada, Boolean incidencia, String descripciónIncidencia) {
		this.emailCliente = emailCliente;
		this.idRserva = idRserva;
		this.fechaInicio = fechaInicio;
		this.fechaExtraccion = fechaExtraccion;
		this.reservaFinalizada = reservaFinalizada;
		this.incidencia = incidencia;
		this.descripciónIncidencia = descripciónIncidencia;
	}
	
	

	/**
	 * @return the emailCliente
	 */
	public String getEmailCliente() {
		return emailCliente;
	}



	/**
	 * @param emailCliente the emailCliente to set
	 */
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}



	/**
	 * @return the idRserva
	 */
	public String getIdRserva() {
		return idRserva;
	}



	/**
	 * @param idRserva the idRserva to set
	 */
	public void setIdRserva(String idRserva) {
		this.idRserva = idRserva;
	}



	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}



	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	/**
	 * @return the fechaExtraccion
	 */
	public Date getFechaExtraccion() {
		return fechaExtraccion;
	}



	/**
	 * @param fechaExtraccion the fechaExtraccion to set
	 */
	public void setFechaExtraccion(Date fechaExtraccion) {
		this.fechaExtraccion = fechaExtraccion;
	}



	/**
	 * @return the reservaFinalizada
	 */
	public Boolean getReservaFinalizada() {
		return reservaFinalizada;
	}



	/**
	 * @param reservaFinalizada the reservaFinalizada to set
	 */
	public void setReservaFinalizada(Boolean reservaFinalizada) {
		this.reservaFinalizada = reservaFinalizada;
	}



	/**
	 * @return the incidencia
	 */
	public Boolean getIncidencia() {
		return incidencia;
	}



	/**
	 * @param incidencia the incidencia to set
	 */
	public void setIncidencia(Boolean incidencia) {
		this.incidencia = incidencia;
	}



	/**
	 * @return the descripciónIncidencia
	 */
	public String getDescripciónIncidencia() {
		return descripciónIncidencia;
	}



	/**
	 * @param descripciónIncidencia the descripciónIncidencia to set
	 */
	public void setDescripciónIncidencia(String descripciónIncidencia) {
		this.descripciónIncidencia = descripciónIncidencia;
	}



	@Override
	public String toString() {
		return "Reserva [emailCliente=" + emailCliente + ", idRserva=" 
				+ idRserva + ", fechaInicio=" + fechaInicio+ ", fechaExtraccion=" + fechaExtraccion 
				+ ", reservaFinalizada=" + reservaFinalizada + ", incidencia="
				+ incidencia + ", descripciónIncidencia=" + descripciónIncidencia + "]";
	}
	
	

}
