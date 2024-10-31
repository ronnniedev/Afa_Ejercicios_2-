package Modelo;

import java.util.ArrayList;
import java.util.List;

import Excepciones.LogicaException;
import Excepciones.PersistenciaException;

public class Consigna {
	
	private int id;
	private int numeroReservas;
	private List <Reserva> reservas;
	private int ingresos;
	private String direccion;
	
	/**
	 * Contructor de 2 parametros de la clase Consigna
	 * @param id : int
	 * @param direccion : String
	 */
	public Consigna(int id, String direccion) {
		this.id = id;
		this.numeroReservas = 0;
		this.reservas = new ArrayList<Reserva>();
		this.ingresos = 0;
		this.direccion = direccion;
	}

	/**
	 * Metodo get de id de la clase Consigna
	 * @return int : id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo set de id de la clase Consigna
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo get de numeroReservas de la clase Consigna
	 * @return numeroReservas : int
	 */
	public int getNumeroReservas() {
		return numeroReservas;
	}

	/**
	 * Metodo set de numeroReservas de la clase Consigna
	 * @param numeroReservas : int
	 */
	public void setNumeroReservas(int numeroReservas) {
		this.numeroReservas = numeroReservas;
	}

	/**
	 * Metodo get de reservas de la clase Consigna
	 * @return reservas : List
	 */
	public List<Reserva> getReservas() {
		return reservas;
	}

	/**
	 * Metodo set de reservas de la clase Consigna
	 * @param reservas : List
	 */
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	/**
	 * Metodo get de ingresos de la clase Consignad
	 * @return ingresos : int
	 */
	public int getIngresos() {
		return ingresos;
	}

	/**
	 * Metodo set de ingresos de la clase Consigna
	 * @param ingresos : int
	 */
	public void setIngresos(int ingresos) {
		this.ingresos = ingresos;
	}

	/**
	 * Metodo get de direccion de la clase Consigna
	 * @return direccion : String
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo set de direccion de la clase Consigna
	 * @param direccion : String
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Consigna [id=" + id + ", numeroReservas=" + numeroReservas + 
				", ingresos="+ ingresos + ", direccion=" + direccion + "]";
	}

	/**
	 * Serializa una linea String para convertirla en un objeto y su posterior cargado
	 * Tambien comprueba si la linea esta mal formada
	 * @param linea : String
	 * @return Consigna
	 * @throws PersistenciaException
	 */
	public static Consigna serializeConsigna(String linea) throws PersistenciaException {
		String trozos[] = linea.split(";");
		if(trozos.length != 3) {
			throw new PersistenciaException("Linea mal formateada");
		}
		int id = Integer.parseInt(trozos[1]);
		String direccion = trozos[2];
		return new Consigna (id,direccion);
	}

	/**
	 * Mete una reserva en la lista de reservas de una consigna especifica
	 * comprueba si ya esta alojada en el sistema
	 * @param r : Reserva
	 * @throws LogicaException
	 */
	public void addReservaEnConsigna(Reserva r) throws LogicaException {
		
		for(Reserva reserva: reservas) {
			if(reserva.getIdReserva().compareTo(r.getIdReserva()) == 0) {
				throw new LogicaException("ERROR ya existe esta reserva");
			}
		}
		reservas.add(r);
		this.setNumeroReservas(this.getNumeroReservas()+1);
	}

	/**
	 * Lista las reservas dentro de la consigna y las devuelve en forma de String
	 * @return texto : String
	 */
	public String listarReservas() {
		String texto = "-------Reservas en consigna " + this.getId() + " ----------------------\n";
		
		for(Reserva r: reservas) {
			texto += r.toString() + "\n";
		}
		
		return texto;
		
	}

	/**
	 * Busca una reserva dentro de la consigna a traves de una id de reserva proporcionada
	 * Avisa si no se encuentra
	 * @param idReserva : String
	 * @return Reserva
	 * @throws LogicaException
	 */
	public Reserva buscarReserva(String idReserva) throws LogicaException {
		for(Reserva r: reservas) {
			if(r.getIdReserva().compareTo(idReserva) == 0) {
				return r;
			}
		}
		throw new LogicaException("ERROR No se encuentra la Reserva");
	}

	/**
	 * Serializa uan consigna transformandola de objeto a String para su guardado
	 * @param c : Consigna
	 * @return String
	 */
	public static String serializeConsigna(Consigna c) {
		return 2 + ";" + c.getId() + ";" + c.getDireccion() +"\n";
	}

	/**
	 * Borra una reserva proporcionad y actualiza el numero de reservas dentro de la consigna
	 * @param r : Reserva
	 */
	public void borrarReserva(Reserva r) {
		
		reservas.remove(r);
		this.numeroReservas--;
	}
	
	
	
	

}
