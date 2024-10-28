package ejercicio1;

public class Producto implements Comparable{
	
	private String nombre;
	private int cantidad;
	private int precio;
	
	
	public Producto(int numero) {
		this.nombre = "producto" + numero;
		this.cantidad = (int) (Math.random()*50)+1;
		this.precio = (int)(Math.random()*100)+1;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}


	@Override
	public int compareTo(Object o) {
		Producto other = (Producto)o;
		return this.nombre.compareTo(other.getNombre());
	}
	
	
	
	

}
