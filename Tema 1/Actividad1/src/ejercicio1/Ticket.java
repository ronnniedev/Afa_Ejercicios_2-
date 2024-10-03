package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ticket {
	
	private String fecha;
	private String nombreDependienta;
	private List <DetalleTicket> detalles;
	
	public Ticket(String fecha,String nombreDependienta) {
		this.nombreDependienta = nombreDependienta;
		this.fecha = fecha;
		this.detalles = new ArrayList<DetalleTicket>();
	}
	
	
	
	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public String getNombreDependienta() {
		return nombreDependienta;
	}



	public void setNombreDependienta(String nombreDependienta) {
		this.nombreDependienta = nombreDependienta;
	}



	public List<DetalleTicket> getDetalles() {
		return detalles;
	}



	public void setDetalles(List<DetalleTicket> detalles) {
		this.detalles = detalles;
	}



	public void añadirDetallePedido(Producto p,int cantidad) 
			throws ProductIsNullException, CantidadNotHandledException {
		DetalleTicket t = new DetalleTicket(p,cantidad);
		detalles.add(t);
	}
	
	public void mostrarTicket() {
		System.out.println("------Ticket de compra------");
		System.out.println("Productos:");
		int total = 0;
		for(int i = 0; i < detalles.size();i++) {
			System.out.println(detalles.get(i));
			total = total + detalles.get(i).getTotal();
		}
		System.out.println("Total: " + total);
	}

	@Override
	public int hashCode() {
		return Objects.hash(detalles, fecha, nombreDependienta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return this.fecha.compareTo(other.getFecha()) == 0;
	}
	
	
	
	
	

}
