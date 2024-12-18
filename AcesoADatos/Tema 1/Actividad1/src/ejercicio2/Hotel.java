package ejercicio2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Hotel {
	
	Set <Habitacion>habitaciones;
	Set <Cliente>clientes;
	List <Reserva>reservas;
	
	public Hotel() {
		this.habitaciones = new TreeSet<Habitacion>();
		this.clientes = new HashSet<Cliente>();
		this.reservas = new ArrayList<Reserva>();
	}
	
	public void añadirCliente(String dni, String nombre, String apellidos, Tipo_Cliente tipo) {
		Cliente c = new Cliente(dni,nombre,apellidos,tipo);
		if(clientes.contains(c)) {
			System.out.println("Cliente ya dentro de la lista");
		}else {
			clientes.add(c);
			System.out.println("añadido");
		}
		
	}
	
	public void añadirHabitacion(String piso, TipoHabitacion tipo,boolean disponible) 
			throws HabitacionAlreadyInException {
		Habitacion h = new Habitacion(piso,tipo,disponible);
		if(habitaciones.contains(h)) {
			throw new HabitacionAlreadyInException("Esta habitacion ya se encuentra dentro");
			
		}else {
			habitaciones.add(h);
			
		}
		
	}
	
	public void mostrarHabitacionesTipo(TipoHabitacion tipo) {
		System.out.println("---BusquedaPorTipo---");
		
		for(Habitacion h: habitaciones) {
			if(h.getTipo() == tipo) {
				System.out.println(h.toString());
			}
		}
		
	}
	
	public void preguntarPrecio(String codigo) {
		System.out.println("---BusquedaPrecio---");
		
		for(Habitacion h: habitaciones) {
			if(h.getPiso() == codigo) {
				System.out.println("El precio de " + h.getPiso() + " es: " + h.getPrecio());
				return;
			}
		}
		
		System.out.println("No se ha encontrado la habitacion");
		
	}
	
	public void preguntarDescuentoHabituales() {
		
		System.out.println("El descuento actual es " + Cliente.getDescuento_habituales());
		
	}
	
	public Cliente EncontrarCliente(String dni) throws ClienteNotFoundException {
		Cliente c = new Cliente(dni,"marco","jdsasd",Tipo_Cliente.HABITUAL);
		
		if(clientes.contains(c)) {
			for(Cliente cli: clientes) {
				if(cli.getDni().compareTo(dni) == 0) {
					return cli;
					
				}
			}
			
		}else {
			
			throw new ClienteNotFoundException("Cliente no encontrado");
		}
		
		return c;
		
	}
	
	public void preguntarPrecio(String dni,TipoHabitacion tipoHab,int dias) 
			throws ClienteNotFoundException {
		
		Cliente c = EncontrarCliente(dni);
		Habitacion h = new Habitacion ("1a",tipoHab,false);
		if(c.getTipo() == Tipo_Cliente.HABITUAL) {
			System.out.println("El precio para este cliente es : " + (h.getPrecio()*dias));
		}else {
			System.out.println("El precio para este cliente es : " 
		+ (h.getPrecio()*dias*Cliente.getDescuento_habituales()));
			
		}
		
	}
	
	public void reservarHabitacion(String codigo,String dni,int noches) 
			throws HabitacionNotFoundException, ClienteNotFoundException {
		Habitacion h = encontrarHabitacion(codigo);
		Cliente c = EncontrarCliente(dni);
		
		if(h.isDisponible()) {
			h.setDisponible(false);
			Reserva r = new Reserva(c,h,"2",noches);
			reservas.add(r);
			mostrarReservas();
		}else {
			System.out.println("Habitacion no disponible");
		}
	}
	
	public Habitacion encontrarHabitacion(String codigo) throws HabitacionNotFoundException {
		Habitacion h = new Habitacion(codigo,TipoHabitacion.DOBLE,false);
		
		if(habitaciones.contains(h)) {
			for(Habitacion hab: habitaciones) {
				if(hab.getPiso().compareTo(codigo) == 0) {
					return hab;
					
				}
				
			}
			
		}
		
		throw new HabitacionNotFoundException("Habitacion no encontrada");
	}
	
	public void mostrarReservas() {
		System.out.println("------Reservas actuales------");
		
		for(int i = 0; i < reservas.size();i++) {
			System.out.println(reservas.get(i).toString());
		}
		
	}
	
	public void eliminarReserva(String codigo) {
		
		for(int i = 0; i < reservas.size();i++) {
			if(reservas.get(i).getHabitacion().getPiso().compareTo(codigo) == 0) {
				reservas.get(i).getHabitacion().setDisponible(true);
				reservas.remove(i);
				mostrarReservas();
				return;
			}
		}
		
		System.out.println("No se ha encontrado la habitacion");
		
	}
	
	public void cambiarValorDescuento(double descuento) {
		Cliente.setDescuento_habituales(descuento);
		
		
	}
	
	public void cambiarPrecioPorTipo(TipoHabitacion tipo, int precio) {
		
		if(tipo == TipoHabitacion.DOBLE) {
			Habitacion.setPRECIO_DOBLE(precio);
		}else if(tipo == TipoHabitacion.MATRIMONIAL) {
			Habitacion.setPRECIO_MATRIMONIAL(precio);
		}else{
			Habitacion.setPRECIO_SIMPLE(precio);
		}
		
		
		for(Habitacion h: habitaciones) {
			if(h.getTipo() == tipo) {
				h.setPrecio(precio);
			}
		}
		System.out.println("----------Precio Cambiado---------");
		mostrarHabitacionesTipo(tipo);
	}
	

}
