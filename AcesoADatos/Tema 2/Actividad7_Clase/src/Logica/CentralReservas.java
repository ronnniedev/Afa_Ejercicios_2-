package Logica;

import java.util.ArrayList;
import java.util.List;

import Modelo.Habitacion;
import Modelo.Hotel;
import Modelo.Reserva;
import Modelo.Zonas;

public class CentralReservas {
	
	private List <Zonas> zonas;
	private List <Hotel> hoteles;
	private List <Habitacion> habitaciones;
	private List <Reserva> reservas;
	
	public CentralReservas() {
		zonas = new ArrayList<Zonas>();
		hoteles = new ArrayList<Hotel>();
		habitaciones = new ArrayList<Habitacion>();
		reservas = new ArrayList<Reserva>();
	}
	
	
	public void addZonas(Zonas z) {
		zonas.add(z);
	}
	
	public void addHotel(Hotel h) {
		hoteles.add(h);
	}
	
	public void addHabitacion(Habitacion h) {
		habitaciones.add(h);
	}
	
	public void addReserva(Reserva r) {
		reservas.add(r);
	}
	
	public Zonas buscarZona(int codZona) {
		for(Zonas z : zonas) {
			if(z.getCodigo()== codZona) {
				return z;
			}
			
		}
		return null;
	}
	
	public Hotel buscarHotel(int codHotel) {
		for(Hotel h: hoteles) {
			if(h.getCodigo()==codHotel ) {
				return h;
			}
		}
		return null;
	}
	
	public Habitacion buscaHabitacion(int codHabitacion) {
		for(Habitacion h : habitaciones) {
			if(h.getCodigo() == codHabitacion) {
				return h;
			}
		}
		return null;
	}
	
	public Reserva buscarReserva(int codReserva) {
		for(Reserva rev: reservas) {
			if(codReserva == rev.getCodigo()) {
				return rev;
			}
		}
		return null;
	}
	
	public String listarDatos() {
		String texto = "";
		texto += "Zonas : " +zonas.size() +  "\n";
		for(Zonas z: zonas) {
			texto += z.toString() + "\n";
		}
		texto += "Hoteler : " + hoteles.size() +  "\n";
		for(Hotel h: hoteles) {
			texto += h.toString() + "\n";
		}
		texto += "Habitaciones : " + habitaciones.size() + "\n";
		for(Habitacion h: habitaciones) {
			texto += h.toString() + "\n";
		}
		texto += "Reservas: " + reservas.size() + "\n";
		for(Reserva r: reservas) {
			texto += r.toString() + "\n";
		}
		return texto;
	} 

}
