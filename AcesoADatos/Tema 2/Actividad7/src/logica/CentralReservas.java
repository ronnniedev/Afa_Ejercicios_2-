package logica;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import excepciones.LogicaException;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Reserva;
import modelo.Zona;
import persistencia.GestorPersistencia;

public class CentralReservas {
	
	private List <Zona> zonas;
	private List <Hotel> hoteles;
	private List<Habitacion> habitaciones;
	private List<Reserva> reservas;
	private GestorPersistencia gestor;

	public CentralReservas() {
		this.zonas = new ArrayList<Zona>();
		this.hoteles = new ArrayList<Hotel>();
		this.habitaciones = new ArrayList<Habitacion>();
		this.reservas = new ArrayList<Reserva>();
		this.gestor = new GestorPersistencia(this);
		this.gestor.cargarDatos();
	}
	
	

	/**
	 * @return the zonas
	 */
	public List<Zona> getZonas() {
		return zonas;
	}



	/**
	 * @param zonas the zonas to set
	 */
	public void setZonas(List<Zona> zonas) {
		this.zonas = zonas;
	}



	/**
	 * @return the hoteles
	 */
	public List<Hotel> getHoteles() {
		return hoteles;
	}



	/**
	 * @param hoteles the hoteles to set
	 */
	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}



	/**
	 * @return the habitaciones
	 */
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}



	/**
	 * @param habitaciones the habitaciones to set
	 */
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
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
	 * @return the gestor
	 */
	public GestorPersistencia getGestor() {
		return gestor;
	}



	/**
	 * @param gestor the gestor to set
	 */
	public void setGestor(GestorPersistencia gestor) {
		this.gestor = gestor;
	}



	public void addZona(Zona z) throws LogicaException {
		
		for(Zona zona : zonas) {
			if(zona.getCodigo() == z.getCodigo()) {
				throw new LogicaException("Error esta zona ya existe");
			}
		}
		zonas.add(z);
		
		
	}

	public void addHotel(Hotel h) throws LogicaException {
		
		for(Hotel hotel: hoteles) {
			if(h.getCodigo() == hotel.getCodigo()) {
				throw new LogicaException("ERROR el codigo de este hotel ya existe");
			}
		}
		
		for(Zona zona: zonas) {
			if(zona.getCodigo() == h.getCodigoZona()) {
				hoteles.add(h);
				return;
			}
		}
		
		throw new LogicaException("ERROR no existe el codigo de la zona especificado");
	}

	public String listarZonas() {
		String texto = "";
		for(Zona zona: zonas) {
			texto += zona.toString() +"\n";
		}
		return texto;
	}

	public String listarHoteles() {
		String texto = "";
		for(Hotel h: hoteles) {
			texto += "Nombre zona: " + buscarZona(h.getCodigoZona()).getNombre()  +"\n";
			texto += h.toString()  +"\n";
		}
		return texto;
	}
	
	public Zona buscarZona(int codigoZona) {
		
		for(Zona zona: zonas) {
			if(zona.getCodigo() == codigoZona) {
				return zona;
			}
		}
		
		return null;
	}

	public void addHabitacion(Habitacion hab) throws LogicaException {
		
		for(Habitacion h: habitaciones) {
			if(h.getCodigo() == hab.getCodigo()) {
				throw new LogicaException("ERROR ya existe esta habitacion en el sistema");
			}
		}
		
		for(Hotel hotel: hoteles) {
			if(hotel.getCodigo() == hab.getCodigoHotel()) {
				habitaciones.add(hab);
				return;
			}
		}
		
		throw new LogicaException("ERROR no existe el codigo del hotel especificado");
	}

	public void addReserva(Reserva r) throws LogicaException {
		
		
		for(Reserva rev: reservas) {
			if(rev.getCodigo() == r.getCodigo()) {
				throw new LogicaException("ERROR ya existe esta reserva  en el sistema");
			}
		}
		
		for(Habitacion h: habitaciones) {
			if(h.getCodigo() == r.getCodigoHabitacion()) {
				reservas.add(r);
				return;
			}
		}
		
		throw new LogicaException("ERROR no existe el codigo de la habitacion especificado");
	}

	public String listarPorFecha(int identificador,String fecha) throws LogicaException {
		
		Zona z = buscarZona(identificador);
		
		if(z == null) {
			throw new LogicaException("ERROR no existe la zona con ese identificador");
		}
		String texto = "";
		for(Hotel hot: hoteles) {
			if(hot.getCodigoZona() == identificador) {
				for(Habitacion h: habitaciones) {
					for(Reserva r: reservas) {
						if(h.getCodigo() == r.getCodigoHabitacion() && r.getFechaEntrada().compareTo(fecha) != 0) {
							texto += "-----Hotel " + hot.getNombre() + "-------\n";
							texto += r.toString() +"\n";
						}
						
					}
				}	
			}
		}
		
		return texto;
		
	}

	private Hotel buscarHotel(int identificador) throws LogicaException {
		for(Hotel h: hoteles) {
			if(h.getCodigo() == identificador) {
				return h;
			}
		}
		throw new LogicaException("ERROR hotel no encontrado");
	}

	public void hacerReserva(int codHab,String dni, String fecha) throws LogicaException {
		Habitacion h = buscarHabitacion(codHab);
		
		for(Reserva r: reservas) {
			if(r.getCodigoHabitacion() == codHab && r.getFechaEntrada().compareTo(fecha) == 0) {
				throw new LogicaException("ERROR habitacion ya reservada");
			}
		}
		int id = (int)(Math.random()*100);
		reservas.add(new Reserva (id,h.getCodigo(),dni,fecha));
		System.out.println("Codigo nuevo: " + id);
		System.out.println(buscarReserva(id).toString());
	}

	private Reserva buscarReserva(int id) throws LogicaException {
		for(Reserva r: reservas) {
			if(r.getCodigo() == id) {
				return r;
			}
		}
		throw new LogicaException("ERROR reserva no encontrada");
	}

	private Habitacion buscarHabitacion(int codHab) throws LogicaException {
		for(Habitacion h : habitaciones) {
			if(h.getCodigo() == codHab) {
				return h;
			}
		}
		throw new LogicaException("ERROR habitacion no encontrada");
	}

	public void cancelarReserva(int codigoReserva) throws LogicaException {
		
		Reserva r = buscarReserva(codigoReserva);
		reservas.remove(r);

	}

	public String listarReservasCliente(String dni) throws LogicaException {
		String texto = "";
		
		for(Reserva r: reservas) {
			if(r.getDni().compareTo(dni) == 0) {
				Habitacion h = buscarHabitacion(r.getCodigoHabitacion());
				Hotel hot = buscarHotel(h.getCodigoHotel());
				texto += "Nombre hotel: " + hot.getNombre() + "Planta : " + h.getPlanta() + "Fecha: "
				+ r.getFechaEntrada() + "Precio: " + h.getPrecio() +  "\n";
			}
		}
		return texto;
	}

	public String reservasHotel(int codHotel) throws LogicaException {
		Hotel h = buscarHotel(codHotel);
		String texto = "";
		
		for(Reserva r: reservas) {
			Habitacion hab = buscarHabitacion(r.getCodigoHabitacion());
			if(hab.getCodigoHotel() == codHotel) {
				System.out.println("Entra");
				texto += "Nombre hotel: " + h.getNombre() + " Planta : " + hab.getPlanta() + " Fecha: "
						+ r.getFechaEntrada() + "Precio: " + hab.getPrecio() +  " \n";
			}
		}
		return texto;
	}

	public void emergenciaPorDias(String fecha) {
		
		reservas.removeIf(r -> r.getFechaEntrada().compareTo(fecha) == 0);
	}

	public void guardarDatos() {
		gestor.guardarDatos();
		
	}



	public void reubicarReservas(int codigoHotel, String fecha) throws LogicaException {
		Hotel hotelOrigen = buscarHotel(codigoHotel);
		List <Reserva> reservasReubicadas = reservasAreubicar(fecha);
		List <Hotel> hotelesCompatibles = hotelesParaReubicar(hotelOrigen);
		List <Habitacion> habitacionesCompatibles = habitacionesCompatibles(hotelesCompatibles);
		
		for(Reserva r: reservasReubicadas) {
			Habitacion h = buscarHabitacion(r.getCodigoHabitacion());
			for(Habitacion hab: habitacionesCompatibles) {
				if(hab.getOcupacionMax() == h.getOcupacionMax()) {
					r.setCodigoHabitacion(hab.getCodigo());
				}
			}
		}
	}



	private List<Habitacion> habitacionesCompatibles(List<Hotel> hotelesCompatibles) {
		List <Habitacion> habitacionesCompatibles = new ArrayList<Habitacion>();
		
		for(Habitacion hab: habitaciones) {
			if(estaEntrelosHoteles(hotelesCompatibles,hab.getCodigoHotel())) {
				habitacionesCompatibles.add(hab);
			}
		}
		return habitacionesCompatibles;
	}



	private boolean estaEntrelosHoteles(List<Hotel> hotelesCompatibles, int codigoHotel) {
		
		for(Hotel h: hotelesCompatibles) {
			if(h.getCodigo() == codigoHotel) {
				return true;
			}
		}
		
		return false;
	}



	private List<Hotel> hotelesParaReubicar(Hotel hotelOrigen) {
		List<Hotel> hotelesCompatibles = new ArrayList<Hotel>();
		
		for(Hotel h: hoteles) {
			if(h.getCodigoZona() == hotelOrigen.getCodigoZona()) {
				hotelesCompatibles.add(hotelOrigen);
			}
		}
		return hotelesCompatibles;
	}



	private List<Reserva> reservasAreubicar(String fecha) {
		List <Reserva> reservasAreubicar = new ArrayList<Reserva>();
		
		for(Reserva r: reservas) {
			if(r.getFechaEntrada() == fecha) {
				reservasAreubicar.add(r);
			}
		}
		
		return reservasAreubicar;
	}



	
	
	
	
	
	

}
