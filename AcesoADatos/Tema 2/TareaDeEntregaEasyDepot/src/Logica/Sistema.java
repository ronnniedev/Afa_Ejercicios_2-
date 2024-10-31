package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Excepciones.LogicaException;
import Excepciones.PersistenciaException;
import Modelo.Cliente;
import Modelo.Consigna;
import Modelo.Email;
import Modelo.Reserva;
import Persistencia.GestorPersistencia;

public class Sistema {

	private Map <Email,Cliente> clientes;
	private List <Reserva> reservas;
	private List <Consigna> consignas;
	
	/**
	 * Contructor  de la clase Sistema
	 */
	 
	public Sistema() {
		this.clientes = new HashMap<Email,Cliente>();
		this.reservas = new ArrayList<Reserva>();
		this.consignas = new ArrayList<Consigna>();
	}
	
	
	
	/**
	 * Metodo get de clientes de clase sistema
	 * @return the clientes <Map>
	 */
	public Map<Email, Cliente> getClientes() {
		return clientes;
	}



	/**
	 * Metodo set de clientes de clase sistema
	 */
	public void setClientes(Map<Email, Cliente> clientes) {
		this.clientes = clientes;
	}



	/**
	 * Metodo get de rservas de clase sistema
	 * @return reservas <List>
	 */
	public List<Reserva> getReservas() {
		return reservas;
	}



	/**
	 * Metodo set de reservas de clase sistema
	 */
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}



	/**
	 * Metodo get de consignas de clase sistema
	 * @return consignas <List>
	 */
	public List<Consigna> getConsignas() {
		return consignas;
	}



	/**
	 * Metodo set de consignas de clase sistema
	 */
	public void setConsignas(List<Consigna> consignas) {
		this.consignas = consignas;
	}



	/**
	 * Lista todos los clientes y los devuelve en formato String
	 * @return texto : String
	 */
	public String listarClientes() {
		String texto = "----------Clientes en el sistema----------\n";
		for(Cliente c: clientes.values()) {
			texto += c.toString()+"\n";
		}
		return texto;
	}

	/**
	 * Lista todas las consignas y las devuelve en formato String
	 * @return texto : String
	 */
	public String listarConsignas() {
		String texto = "----------Consignas en el sistema----------\n";
		
		for(Consigna c: consignas) {
			texto += c.toString()+"\n";
		}
		return texto;
	}

	/**
	 * Lista todas las reservas y las devuelve en formato String
	 * @return texto : String
	 */
	public String listarReservas() {
		String texto = "----------Reservas en el sistema----------\n";
		
		for(Reserva r: reservas) {
			texto += r.toString() +"\n";
		}
		return texto;
	}


	/**
	 * Mete un cliente nuevo si este no se encuentra en la lista del sistema
	 * @param c : Cliente
	 * @return boolean
	 * @throws LogicaException
	 */
	public boolean addCliente(Cliente c) throws LogicaException {
		if(!clientes.containsKey(new Email(c.getEmail()))) {
			clientes.put(new Email(c.getEmail()), c);
		}else {
			throw new LogicaException("ERROR Cliente ya figura en base de datos");
		}
		
		return true;
	}
	
	/**
	 * Mete una consigna si esta no se encuentra en la lista del sistema
	 * @param c : Consigna
	 * @return boolean
	 * @throws LogicaException
	 */
	public boolean addConsigna(Consigna c) throws LogicaException {
		
		for(Consigna con: consignas) {
			if(con.getId() == c.getId()) {
				throw new LogicaException("Error Consigna ya en la base de datos");
				}
		}
		
		return consignas.add(c);
	}



	/**
	 * Mete una reserva si esta no se encuentra en la lista del sistema
	 * @param r : Reserva
	 * @return boolean
	 * @throws LogicaException
	 */
	public boolean addReserva(Reserva r) throws LogicaException {
		String trozos[] = r.getIdReserva().split("-");
		int id = Integer.parseInt(trozos[0]);
		
		for(Consigna c: consignas) {
			if(c.getId() == id) {
				Cliente cli = buscarCliente(r.getEmailCliente());
				cli.setNumeroReservas(cli.getNumeroReservas() + 1);
				c.addReservaEnConsigna(r);
				return reservas.add(r);
			}
		}
		
		throw new LogicaException("La consigna " + id + " no existe");
	}
	
	/**
	 * Comprueba que el telefono tiene 9 caracteres y que son todos digitos
	 * @param telefono : String
	 * @return boolean
	 */
	public boolean comprobarTelefono(String telefono) {

		if (telefono.length() != 9) {
			System.out.println("El telefono debe tener solamente 9 digitos");
			return false;
		}

		for (int i = 0; i < telefono.length(); i++) {
			if (!Character.isDigit(telefono.charAt(i))) {
				System.out.println("El telefono solo puede estar compuesto por numeros");
				return false;
			}
		}
		return true;
	}



	/**
	 * Busca y devuelve un cliente a traves del email proporcionado
	 * @param email : String
	 * @return Cliente
	 * @throws LogicaException
	 */
	public Cliente  buscarCliente(String email) throws LogicaException {
		Email e = new Email(email);
		if(clientes.containsKey(e)) {
			return clientes.get(e);
		}else {
			throw new LogicaException("No se encuentra el cliente especificado");
		}
	}



	/**
	 * Busca una Consigna en fuincion de la id proporcionada
	 * @param id
	 * @return Consigna
	 */
	public Consigna buscarConsigna(int id){
		for(Consigna c: consignas) {
			if(c.getId() == id) {
				return c;
			}
		}
		return null;
	}



	/**
	 * Buscar una reserva en funcion de la id proporcionada
	 * @param id : String
	 * @return Reserva
	 * @throws LogicaException
	 */
	public Reserva buscarReserva(String id) throws LogicaException {
		for(Reserva r: reservas) {
			if(r.getIdReserva().compareTo(id) == 0) {
				return r;
			}
		}
		throw new LogicaException("No se encuentra la reserva con esta id");
	}



	/**
	 * Muestra las reservas abiertas de un Cliente proporcionado
	 * @param c : Cliente
	 * @return texto : String
	 * @throws LogicaException
	 */
	public String mostrarReservasAbiertasCliente(Cliente c) throws LogicaException {
		String texto = "Estas son las reservas abierta que "
				+ "tiene el cliente con correo " + c.getEmail() + " \n";
		String reservasTexto = "";
		
		for(Reserva r: reservas) {
			if(c.getEmail().compareTo(r.getEmailCliente()) == 0 && !r.getReservaFinalizada()) {
				reservasTexto += r.toString();
			}
		}
		
		if(reservasTexto.compareTo("") == 0) {
		throw new LogicaException("No se ha encontrado ninguna reserva abierta con este cliente");
		}
		return texto + reservasTexto;
	}


	/**
	 * Cierra una reserva a traves de la idConsigna proporcionada y si esta Incidencia esta abierta
	 * @param linea : String
	 * @throws LogicaException
	 */
	public void cerrarReserva(String idConsigna) throws LogicaException {
		String trozos[] = idConsigna.split("-");
		
		if(trozos.length != 2) {
			throw new LogicaException("ERROR debe escribir la id con el formato presentado en N-N");
		}
		
		for(int i = 0; i < trozos.length ; i++) {
			for(int j = 0; j < trozos[i].length() ; j++) {
				if(!Character.isDigit(trozos[i].charAt(j))) {
					throw new LogicaException("ERROR las ids deben ser numerica en formato N-N");
				}
			}
			
		}
		
		for(Reserva r: reservas) {
			if(r.getIdReserva().compareTo(idConsigna) == 0 && !r.getReservaFinalizada()) {
				Consigna c = buscarConsigna(Integer.parseInt(trozos[0]));
				Cliente cli = buscarCliente(r.getEmailCliente());
				cli.setPuntosTienda(cli.getPuntosTienda() + 10);
				c.setIngresos(c.getIngresos() + 10);
				r.setFechaExtraccion(new Date().toString());
				r.setReservaFinalizada(true);
			}
		}
		
	}



	/**
	 * Muestra las incidencias abiertas dentro del sistema
	 * @return texto : String
	 * @throws LogicaException
	 */
	public String mostrarIncidenciasAbiertas() throws LogicaException {
		String texto = "";
		for(Reserva r : reservas) {
			if(r.getIncidencia()) {
				texto += r.toString() + "\n";
			}
		}
		
		if(texto.compareTo("") == 0) {
			throw new LogicaException("Actualmente no hay incidencias abiertas");
		}
		return texto;
	}



	/**
	 * Muestra las incidencias cerradas dentro del sistema
	 * @return texto : String
	 * @throws LogicaException
	 */
	public String mostrarIncidenciasCerradas() throws LogicaException {
		String texto = "";
		for(Reserva r : reservas) {
			
			if(!r.getIncidencia()) {
				texto += r.toString() + "\n";
			}
			
		}
		
		if(texto.compareTo("") == 0) {
			throw new LogicaException("Actualmente no hay incidencias cerradas");
		}
		
		return texto;
	}



	/**
	 * Abre una incidencia siempre y cuando esta no este abierta
	 * @param r : Reserva
	 * @param descripcion : String
	 * @throws LogicaException
	 */
	public void abrirIncidencia(Reserva r, String descripcion) throws LogicaException {
		if(r.getIncidencia()) {
			throw new LogicaException("ERROR esta reserva ya tiene una incidencia abierta");
		}
		r.setIncidencia(true);
		r.setDescripciónIncidencia(descripcion);
	}



	/**
	 * Cierra una incidencia siempre y cuando esta no este cerrada
	 * @param r : Reserva
	 * @param descripcion : String
	 * @throws LogicaException
	 */
	public void cerrarIncidencia(Reserva r, String descripcion) throws LogicaException {
		if(!r.getIncidencia()) {
			throw new LogicaException("ERROR esta reserva no tiene una incidencia abierta");
		}
		r.setIncidencia(false);
		r.setDescripciónIncidencia(descripcion);
	}


	/**
	 * Cambia la direccion de la consigna a traves de la direccion proporcionada
	 * @param c : Consigna
	 * @param direccion : String
	 */
	public void cambiarDireccionConsigna(Consigna c, String direccion) {
		c.setDireccion(direccion);
	}


	/**
	 * Cambia los nombre y el apellido  de un cliente a traves del cliente y los Strings 
	 * proporcionados
	 * @param nombre : String
	 * @param apellidos : String
	 * @param c : Cliente
	 */
	public void cambiarNombreApellidos(String nombre,String apellidos,Cliente c) {
		c.setNombre(nombre);
		c.setApellidos(apellidos);
	}



	/**
	 * Cambia la contraseña de un cliente a traves del string y cliente proporcionado
	 * @param c : Cliente
	 * @param password : String
	 */
	public void cambiarContraseña(Cliente c , String password) {
		c.setContraseña(password);
		
	}


	/**
	 * Cambia el telefono  de un cliente a traves del String y el cliente proporcionados
	 * @param c : Cliente
	 * @param telefono : String
	 */
	public void cambiarTelefono(Cliente c, String telefono) {
		c.setTelefono(telefono);
		
	}


	/**
	 * Comprueba si un email proprocionado figura en el sistema
	 * @param email : String
	 * @throws LogicaException
	 */
	public void comprobarSiEmailEstaGuardado(String email) throws LogicaException {
		Email e = new Email(email);
		if(clientes.containsKey(e)) {
			throw new LogicaException("Este email ya esta registrado, introduzca otro");
		}
		
	}


	/**
	 * Cambia el correo del cliente asociado al mismo y tambien todas sus referencias en reservas
	 * @param c : Cliente
	 * @param email : String
	 */
	public void cambiarEmail(Cliente c, String email) {
		String oldEmail = c.getEmail();
		Email e = new Email(oldEmail);
		clientes.remove(e);
		c.setEmail(email);
		for(Reserva r: reservas) {
			if(r.getEmailCliente().compareTo(oldEmail) == 0) {
				r.setEmailCliente(email);
			}
		}
		clientes.put(new Email(email), c);
		System.out.println("Cambios realizados con exito");
		
	}


	/**
	 * Elmina una reserva a traves de una reserva proporcionada
	 * @param r : Reserva
	 */
	public void eliminarReserva(Reserva r) {
		String trozos[] = r.getIdReserva().split("-");
		Consigna c = buscarConsigna(Integer.parseInt(trozos[0]));
		c.borrarReserva(r);
		reservas.remove(r);
	}


	/**
	 * Elmina una consigna a traves de la consigna proporcionada
	 * @param c : Consigna
	 */
	public void eliminarConsigna(Consigna c) {
		List <Reserva> ReservasEnConsigna = c.getReservas();
		
		for(Reserva r: ReservasEnConsigna) {
			reservas.remove(r);
		}
		
		consignas.remove(c);
		
	}

	/**
	 * Elimina un cliente a traves del String de cliente proporcionado, 
	 * tambien escribe Cliente eliminadodonde figuraba el antiguo cliente
	 * @param idCliente
	 * @throws LogicaException
	 */
	public void eliminarCliente(String idCliente) throws LogicaException {
		
		Cliente c = buscarCliente(idCliente);
		clientes.remove(new Email (c.getEmail()), c);
		for(Reserva r:reservas) {
			if(c.getEmail().compareTo(r.getEmailCliente()) == 0) {
				r.setEmailCliente("Cliente eliminado");
			}
		}
	}



}
