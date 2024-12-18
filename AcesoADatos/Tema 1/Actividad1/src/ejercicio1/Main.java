package ejercicio1;

public class Main {

	public static void main(String[] args) {
		
		Almacen a = new Almacen();
		Producto p = new Producto(1);
		Producto p2 = new Producto(2);
		Producto p3 = new Producto(3);
		Producto p4 = new Producto(4);
		Producto p5 = new Producto(5);
		
		meterProducto(a,p);
		meterProducto(a,p2);
		meterProducto(a,p3);
		meterProducto(a,p4);
		meterProducto(a,p5);
		a.mostrarProductos();
		
		Ticket t = new Ticket("1","Marisa");
		
		try {
			t.añadirDetallePedido(p, 5);
			t.añadirDetallePedido(p2, 3);
		} catch (ProductIsNullException e) {
			System.out.println(e);
		} catch (CantidadNotHandledException e) {
			System.out.println(e);
		}
		
		a.mostrarProductos();
		
		t.mostrarTicket();
	}
	
	public static void meterProducto(Almacen a, Producto p) {
		
		try {
			a.añadirProducto(p);
		} catch (ProductIsNullException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
