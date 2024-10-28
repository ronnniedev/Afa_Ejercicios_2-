package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Excepciones.LogicaException;
import Modelo.Cliente;
import Modelo.Consigna;
import Modelo.Email;
import Modelo.Reserva;
import Persistencia.GestorPersistencia;

public class Sistema {

	private Map <Email,Cliente> clientes;
	private List <Reserva> reservas;
	private List <Consigna> consignas;
	
	public Sistema() {
		this.clientes = new HashMap<Email,Cliente>();
		this.reservas = new ArrayList<Reserva>();
		this.consignas = new ArrayList<Consigna>();
	}
	
	
	
	/**
	 * @return the clientes
	 */
	public Map<Email, Cliente> getClientes() {
		return clientes;
	}



	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(Map<Email, Cliente> clientes) {
		this.clientes = clientes;
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
	 * @return the consignas
	 */
	public List<Consigna> getConsignas() {
		return consignas;
	}



	/**
	 * @param consignas the consignas to set
	 */
	public void setConsignas(List<Consigna> consignas) {
		this.consignas = consignas;
	}



	public String listarClientes() {
		String texto = "----------Clientes en el sistema----------\n";
		System.out.println(clientes.size());
		for(Cliente c: clientes.values()) {
			texto += c.toString()+"\n";
		}
		return texto;
	}

	public String listarConsignas() {
		String texto = "----------Consignas en el sistema----------\n";
		
		for(Consigna c: consignas) {
			texto += c.toString()+"\n";
		}
		return texto;
	}

	public String listarReservas() {
		String texto = "----------Reservas en el sistema----------";
		
		for(Reserva r: reservas) {
			texto += r.toString() +"\n";
		}
		return texto;
	}



	public void addCliente(Cliente c) throws LogicaException {
		if(!clientes.containsKey(new Email(c.getEmail()))) {
			clientes.put(new Email(c.getEmail()), c);
		}else {
			throw new LogicaException("ERROR Cliente ya figura en base de datos");
		}
		
		
	}

}
