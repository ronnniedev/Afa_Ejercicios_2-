package logica;

import java.util.ArrayList;
import java.util.List;

import Excepciones.Loggerfichero;
import Excepciones.LogicaException;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Reserva;
import modelo.Zonas;

public class CentralReservas {

	private List<Zonas> zonas;
	private List<Hotel> hoteles;
	private List<Habitacion> habitaciones;
	private List<Reserva> reservas;

	public CentralReservas() {
		this.zonas = new ArrayList<Zonas>();
		this.hoteles = new ArrayList<Hotel>();
		this.habitaciones = new ArrayList<Habitacion>();
		this.reservas = new ArrayList<Reserva>();
	}

	public void addZonas(Zonas z) {
		zonas.add(z);
	}

	public void addHoteles(Hotel h) {
		hoteles.add(h);
	}

	public void addHabitacion(Habitacion h) {
		habitaciones.add(h);
	}

	public void addReserva(Reserva r) {
		reservas.add(r);
	}

	public Zonas buscarZona(int codZona) {
		for (Zonas z : zonas) {
			if (z.getCodigo() == codZona)
				return z;
		}
		return null;
	}

	public Hotel buscarHotel(int codHotel) {
		for (Hotel h : hoteles) {
			if (h.getCodigo() == codHotel)
				return h;
		}
		return null;
	}

	public Habitacion buscarHabitacion(int codHabitacion) {
		for (Habitacion hab : habitaciones) {
			if (hab.getCodigo() == codHabitacion) {
				return hab;
			}
		}
		return null;
	}

	public Reserva buscarReserva(int codReserva) {
		for (Reserva r : reservas) {
			if (r.getCodigo() == codReserva)
				return r;
		}
		return null;
	}

	public String listarDatos() {
		String texto = "";

		texto += "Zonas: " + zonas.size() + "\n";
		for (Zonas z : zonas) {
			texto += z.toString() + "\n";
		}
		texto += "Hoteles: " + hoteles.size() + "\n";
		for (Hotel h : hoteles) {
			texto += h.toString() + "\n";
		}

		texto += "Habitaciones: " + habitaciones.size() + "\n";
		for (Habitacion h : habitaciones) {
			texto += h.toString() + "\n";
		}
		reservasOrdenadas();
		texto += "Reservas: " + reservas.size() + "\n";
		for (Reserva r : reservas) {
			texto += r.toString() + "\n";
		}
		return texto;
	}

	public String listarHoteles() {
		String texto = "";
		for (Hotel h : hoteles) {
			texto += h.getCodigo() + "\t" + h.getNombre() + "\t" + h.getTipo() + "\t" + h.getEstrellas();
			Zonas z = buscarZona(h.getCodZona());
			texto += "\t" + z.getNombre() + "\n";
		}
		return texto;
	}

	public String listarHabitacionesDisponibles(String fecha, int codZona) {
		// Buscar habitaciones de una zona
		List<Habitacion> habitacionesZona = new ArrayList<Habitacion>();
		for (Habitacion hab : habitaciones) {
			int codHotel = hab.getCodHotel();
			Hotel hotel = buscarHotel(codHotel);
			if (hotel.getCodZona() == codZona) {
				habitacionesZona.add(hab);
			}
		}
		List<Habitacion> habitacionesReservadas = buscarHabReservadas(fecha);
		// resultado = habitaciones de la zona que no estan en reservas
		List<Habitacion> habitacionesDisponibles = new ArrayList<Habitacion>();
		for (Habitacion h : habitacionesZona) {
			if (!habitacionesReservadas.contains(h)) {
				habitacionesDisponibles.add(h);
			}
		}
		// Sacar datos
		String texto = "";
		for (Habitacion hab : habitacionesDisponibles) {
			Hotel hot = buscarHotel(hab.getCodHotel());
			texto += hot.getNombre() + "\t" + hot.getTipo() + "\t" + hot.getEstrellas() + "\t" + hab.getPrecio() + "\n";
		}
		return texto;
	}

	private List<Habitacion> buscarHabReservadas(String fecha) {
		// buscar habitaciones reservadas en la fecha
		List<Habitacion> habitacionesReservadas = new ArrayList<Habitacion>();
		for (Reserva r : reservas) {
			String fechaReserva = r.getFecha();
			if (fechaReserva.compareTo(fecha) == 0) {
				Habitacion habitacion = buscarHabitacion(r.getCodHabitacion());
				habitacionesReservadas.add(habitacion);
			}
		}
		return habitacionesReservadas;
	}

	// Ordenar zonas
	private void zonasOrdenadas() {
		for (int pivote = 0; pivote < zonas.size(); pivote++) {
			for (int i = pivote + 1; i < zonas.size(); i++) {
				if (zonas.get(pivote).getCodigo() > zonas.get(i).getCodigo()) {
					Zonas temp = zonas.get(pivote);
					zonas.set(pivote, zonas.get(i));
					zonas.set(i, temp);

				}
			}
		}
	}

	// Ordenar reservas por cod habitacion
	private void reservasOrdenadas() {
		for (int pivote = 0; pivote < reservas.size(); pivote++) {
			for (int i = pivote + 1; i < reservas.size(); i++) {
				if (reservas.get(pivote).getCodHabitacion() > reservas.get(i).getCodHabitacion()) {
					Reserva temp = reservas.get(pivote);
					reservas.set(pivote, reservas.get(i));
					reservas.set(i, temp);
				}
			}
		}
	}

	public void hacerReserva(String fecha, int codHabitacion, String dni) 
																			throws LogicaException {
		Habitacion habBuscada = buscarHabitacion(codHabitacion);
		if (habBuscada == null) {
			throw new LogicaException("ERROR. La habitacion no existe.");
		}
		List<Habitacion> habitacionesReservadas = buscarHabReservadas(fecha);
		if (habitacionesReservadas.contains(habBuscada) == true) {
			throw new LogicaException("ERROR. Habitacion reservada.");
		}
		//Si llegamos a aqui la hab no estaba reservada
		int codReserva = maximoCodReserva() + 1;
		Reserva r = new Reserva(codReserva, codHabitacion, dni, fecha);
		reservas.add(r);
	}

	private int maximoCodReserva() {
		int codMax = Integer.MIN_VALUE;
		for(Reserva r : reservas) {
			if (r.getCodigo() > codMax) {
				codMax = r.getCodigo();
			}
		}
		return codMax;
	}

	public void cancelarReserva(int codReserva) throws LogicaException {
		Reserva r = buscarReserva(codReserva);
		if (r == null) {
			throw new LogicaException("ERROR. La reserva no existe");
		}
		// no retorne la excepcion. La reserva existe
		reservas.remove(r);
		
	}

	public String listarReservasDni(String dni) {
		//retornamos nombre hotel, planta habitación, fecha y precio
		String texto = "**********************************************************************\n";
		texto += "Reservas del cliente " + dni + "\n";
		for (Reserva r : reservas) {
			if (r.getDni().compareTo(dni) == 0) {
				int codHab = r.getCodHabitacion();
				Habitacion hab = buscarHabitacion(codHab);
				if (hab != null) {
					int planta = hab.getPlanta();
					int codHotel = hab.getCodHotel();
					Hotel h = buscarHotel(codHotel);
					if (h != null) {
						String nombreHotel = h.getNombre();
						String fecha = r.getFecha();
						double precio = hab.getPrecio();
						texto += nombreHotel + "\t" + planta + "\t" + fecha + "\t" + precio + "\n";
					}
				}
			}
		}
		
		return texto;
	}

	public String listarReservasHotel(int codHotel, String fechaInf, String fechaSup) 
																			throws LogicaException {
		//nombre hotel, planta habitación, DNI del cliente, fecha y precio
		String texto = "Reservas del hotel " + codHotel + "\n";
		Hotel hotel = buscarHotel(codHotel);
		if (hotel == null) {
			throw new LogicaException("ERROR. El hotel no esta registrado.");
		}
		for (Reserva r: reservas) {
			if (r.getFecha().compareTo(fechaInf) >= 0 && r.getFecha().compareTo(fechaSup) <= 0) {
				Habitacion hab = buscarHabitacion(r.getCodHabitacion());
				if (hab.getCodHotel() == codHotel) {
					texto += r.getCodigo()+ "\t" + hab.getPlanta() + "\t" + r.getDni() + "\t" 
							+ r.getFecha() + "\t" + hab.getPrecio() + "\n";
				}
			}
		}
		return texto;
	}

	public int eliminarReservasHotel(int codHotel, String fecha) throws LogicaException {
		String listado = listarReservasHotel(codHotel, fecha, fecha);
		String [] lineas = listado.split("\n");
		System.out.println();
		int contReservasEliminadas = 0;
		for (int i = 1; i <lineas.length; i++) {
			String[] trozos = lineas[i].split("\t");
			try {
				System.out.println(trozos[0]);
				int codReserva = Integer.parseInt(trozos[0]);
				cancelarReserva(codReserva);
				contReservasEliminadas++;
			}catch(NumberFormatException e) {
				System.out.println(e.getMessage());
				Loggerfichero.getInstance().writeSmg("ERROR. formato de numero");	
				}
		}
		
		return contReservasEliminadas;
		
	}
	
	
	

}
