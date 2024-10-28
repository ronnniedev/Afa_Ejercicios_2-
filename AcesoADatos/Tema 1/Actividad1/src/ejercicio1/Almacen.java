package ejercicio1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Almacen {
	
	Set <Producto> productos;
	Set <Ticket> tickets;
	
	public Almacen() {
		this.productos = new TreeSet<Producto>();
		this.tickets = new HashSet<Ticket>();
	}
	
	public void añadirProducto(Producto p) throws ProductIsNullException {
		
		if(productos.contains(p)) {
			throw new ProductIsNullException("Producto ya añadido");
			
		}else {
			productos.add(p);
			System.out.println("Productos añadido");
		}
		
	}
	
	public void mostrarProductos() {
		System.out.println("---------Productos----------");
		for(Producto p: productos) {
			System.out.println(p.toString());
			
		}
		
	}
	
	public void buscarProductos(int numero) throws NotFoundException {
		Producto p = new Producto(numero);
		if (productos.contains(p)) {
			for (Producto prod: productos) {
				if(prod.getNombre() == p.getNombre()) {
					System.out.println(prod.toString());
				}
				
			}
		}else {
			throw new NotFoundException("No se ha encontrado el producto");
			
		}
		
	}
	
	public void mostrarTicket(String fecha) throws TicketNotFoundException {
		Ticket t = new Ticket(fecha,"prueba");
		if(tickets.contains(t)) {
			for(Ticket c: tickets) {
				if(c.getFecha().compareTo(t.getFecha()) == 0) {
					c.mostrarTicket();
				}
			}
		}else {
			throw new TicketNotFoundException("No se encontro el ticket");
		}
		
	}
	
	

}
