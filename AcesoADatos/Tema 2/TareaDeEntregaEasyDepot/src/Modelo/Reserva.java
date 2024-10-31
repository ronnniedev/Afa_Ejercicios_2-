package Modelo;

import java.util.Date;

import Excepciones.PersistenciaException;

public class Reserva {
	
	private String emailCliente;
	private String idReserva;
	private String fechaInicio;
	private String  fechaExtraccion;
	private Boolean reservaFinalizada;
	private Boolean incidencia;
	private String descripciónIncidencia;
	
	/**
	 * Constructor de 7 parametros de la clase Reserva
	 * @param emailCliente : String
	 * @param idReserva : String
	 * @param fechaInicio : String
	 * @param fechaExtraccion : String
	 * @param reservaFinalizada : Boolean
	 * @param incidencia : Boolean
	 * @param descripciónIncidencia : String
	 */
	public Reserva(String emailCliente, String idReserva, String fechaInicio, String fechaExtraccion,
			Boolean reservaFinalizada, Boolean incidencia, String descripciónIncidencia) {
		this.emailCliente = emailCliente;
		this.idReserva = idReserva;
		this.fechaInicio = fechaInicio;
		this.fechaExtraccion = fechaExtraccion;
		this.reservaFinalizada = reservaFinalizada;
		this.incidencia = incidencia;
		this.descripciónIncidencia = descripciónIncidencia;
	}
	
	

	/**
	 * Constructor de 2 parametros de clase Reserva
	 * @param emailCliente : String
	 * @param con : Consigna
	 */
	public Reserva(String emailCliente,Consigna con) {
		this.emailCliente = emailCliente;
		this.idReserva = con.getId() + "-" + (con.getNumeroReservas() + 1);
		this.fechaInicio = new Date().toString();
		this.fechaExtraccion = "NA";
		this.reservaFinalizada = false;
		this.incidencia = false;
		this.descripciónIncidencia = "Sin Incidencia";
	}

	/**
	 * Metodo get de emailCliente de la clase Reserva
	 * @return emailCliente
	 */
	public String getEmailCliente() {
		return emailCliente;
	}



	/**
	 * Metodo set de emailCliente de la clase Reserva
	 * @param emailCliente
	 */
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}



	/**
	 * Metodo get de la idReserva de la clase Reserva
	 * @return idReserva : String
	 */
	public String getIdReserva() {
		return idReserva;
	}



	/**
	 * Metodo set de IdReserva de la clase Reserva
	 * @param idReserva
	 */
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}



	/**
	 * Metodo get de FechaInicio de la clase Reserva
	 * @return fechaInicio : String
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}



	/**
	 * Metodo set de FechaInicio de la clase Reserva
	 * @param fechaInicio
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	/**
	 * Metodo get de FechaExtraccion de la clase Reserva
	 * @return fechaExtraccion : String
	 */
	public String getFechaExtraccion() {
		return fechaExtraccion;
	}



	/**
	 * Metodo set de FechaExtraccion de la clase Reserva
	 * @param fechaExtraccion
	 */
	public void setFechaExtraccion(String fechaExtraccion) {
		this.fechaExtraccion = fechaExtraccion;
	}



	/**
	 * Metodo get de reservaFinalizada de la clase Reserva
	 * @return reservaFinalizada : Boolean
	 */
	public Boolean getReservaFinalizada() {
		return reservaFinalizada;
	}



	/**
	 * Metodo set de reservaFinalizada de la clase Reserva
	 * @param reservaFinalizada
	 */
	public void setReservaFinalizada(Boolean reservaFinalizada) {
		this.reservaFinalizada = reservaFinalizada;
	}



	/**
	 * Metodo get de incidencia de la clase Reserva
	 * @return incidencia : Boolean
	 */
	public Boolean getIncidencia() {
		return incidencia;
	}



	/**
	 * Metodo set de incidencia de la clase Reserva
	 * @param incidencia
	 */
	public void setIncidencia(Boolean incidencia) {
		this.incidencia = incidencia;
	}



	/**
	 * Metodo get de descripcionIncidencia de la clase Reserva
	 * @return descripcionIncidencia : String
	 */
	public String getDescripciónIncidencia() {
		return descripciónIncidencia;
	}



	/**
	 * Metodo set de descripcionIncidencia de la claseReserva
	 * @param descripciónIncidencia the descripciónIncidencia to set
	 */
	public void setDescripciónIncidencia(String descripciónIncidencia) {
		this.descripciónIncidencia = descripciónIncidencia;
	}



	@Override
	public String toString() {	
		return "Reserva [emailCliente=" + emailCliente + ", idReserva=" 
				+ idReserva+ ", fechaInicio=" + fechaInicio+ ", fechaExtraccion=" + fechaExtraccion 
				+ ", reservaFinalizada=" + reservaFinalizada + ", incidencia="
				+ incidencia +", descripcionIncidencia = " + descripciónIncidencia + "]";
	}



	/**
	 * Serializa una linea traida desde el gestor de archivos para su cargado
	 * @param linea : String
	 * @return Reserva
	 * @throws PersistenciaException
	 */
	public static Reserva serializeReserva(String linea) throws PersistenciaException {
		String trozos[] = linea.split(";");
		
		if(trozos.length != 8) {
			throw new PersistenciaException("Linea mal formateada");
		}
		
		String emailCliente = trozos[1];
		String id = trozos[2];
		String fechaInicio = trozos[3];
		String  fechaExtraccion = trozos[4];
		Boolean reservaFinalizada = comprobarBooleano(trozos[5]);
		Boolean incidencia = comprobarBooleano(trozos[6]);
		String descripcionIncidencia = trozos[7];
		return new Reserva(emailCliente,id,fechaInicio,fechaExtraccion,
							reservaFinalizada,incidencia,descripcionIncidencia);
	}


	/**
	 * Procesa un boolean escrito en String para reconvertilo a su valor en boolean real
	 * @param booleano : String
	 * @return Boolean
	 * @throws PersistenciaException
	 */
	private static Boolean comprobarBooleano(String booleano) throws PersistenciaException {
		String texto = booleano.toLowerCase();
		if(texto.compareTo("true") == 0) {
			return true;
		}else if(texto.compareTo("false") == 0) {
			return false;
		}
		throw new PersistenciaException("ERROR booleano mal escrito");
	}


	/**
	 * Serializa una reserva y la transforma en String para su guardado
	 * @param r : Reserva
	 * @return String
	 */
	public static String serializeReserva(Reserva r) {
		return 3 + ";" + r.getEmailCliente() + ";" + r.getIdReserva() 
				+ ";" + r.getFechaInicio() + ";" + r.getFechaExtraccion() + ";" 
				+ r.getReservaFinalizada() + ";" + r.getIncidencia() + ";" 
				+ r.getDescripciónIncidencia() +"\n";
	} 

	
	

}
