package ejercicio1;

public class DetalleTicket {
	
	private String nombreProducto;
	private int cantidad;
	private int total;
	
	public DetalleTicket(Producto p,int cantidad) throws ProductIsNullException
	,CantidadNotHandledException {
		this.nombreProducto = comprobarNombre(p);
		this.cantidad = comprobarCantidad(p,cantidad);
		this.total = p.getPrecio()*this.cantidad;
	}
	
	private static String comprobarNombre(Producto p) throws ProductIsNullException {
		if(p == null) {
			throw new ProductIsNullException("Producto es nulo");
			
		}
		return p.getNombre();
	}
	
	private static int comprobarCantidad(Producto p,int cantidad) 
			throws CantidadNotHandledException {
		if(cantidad > p.getCantidad()) {
			throw new CantidadNotHandledException("La cantidad no esta disponible") ;
		}
		p.setCantidad(p.getCantidad()-cantidad);
		return cantidad;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "DetalleTicket [nombreProducto=" + nombreProducto 
				+ ", cantidad=" + cantidad + ", total=" + total + "]";
	}
	
	
	

}
