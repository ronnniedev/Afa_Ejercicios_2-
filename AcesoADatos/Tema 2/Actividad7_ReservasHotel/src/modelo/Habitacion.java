package modelo;

public class Habitacion {
	
	private int codigo;
	private int codHotel;
	private int planta;
	private int ocupacionMax;
	private double precio;
	
	public Habitacion(int codigo, int codHotel, int planta, int ocupacionMax, double precio) {
		
		this.codigo = codigo;
		this.codHotel = codHotel;
		this.planta = planta;
		this.ocupacionMax = ocupacionMax;
		this.precio = precio;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getPlanta() {
		return planta;
	}
	public void setPlanta(int planta) {
		this.planta = planta;
	}
	public int getOcupacionMax() {
		return ocupacionMax;
	}
	public void setOcupacionMax(int ocupacionMax) {
		this.ocupacionMax = ocupacionMax;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getCodHotel() {
		return codHotel;
	}
	public void setCodHotel(int codHotel) {
		this.codHotel = codHotel;
	}
	
	@Override
	public String toString() {
		return "Habitacion [codigo=" + codigo + ", codHotel=" + codHotel + ", planta=" + planta + ", ocupacionMax="
				+ ocupacionMax + ", precio=" + precio + "]";
	}
	
	
	
	

}
