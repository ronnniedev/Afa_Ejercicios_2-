package Modelo;

public class Habitacion {

	private int codigo;
	private int codHotel;
	private int planta;
	private int ocupacionMax;
	private double precio;
	
	public Habitacion(int codigo,int codHotel, int planta, int ocupacionMax, double precio) {
		this.codigo = codigo;
		this.codHotel = codHotel;
		this.planta = planta;
		this.ocupacionMax = ocupacionMax;
		this.precio = precio;
	}
	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the planta
	 */
	public int getPlanta() {
		return planta;
	}
	/**
	 * @param planta the planta to set
	 */
	public void setPlanta(int planta) {
		this.planta = planta;
	}
	/**
	 * @return the ocupacionMax
	 */
	public int getOcupacionMax() {
		return ocupacionMax;
	}
	/**
	 * @param ocupacionMax the ocupacionMax to set
	 */
	public void setOcupacionMax(int ocupacionMax) {
		this.ocupacionMax = ocupacionMax;
	}
	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Habitacion [codigo=" + codigo + ", codHotel=" + codHotel 
				+ ", planta=" + planta + ", ocupacionMax="
				+ ocupacionMax + ", precio=" + precio + "]";
	}
	
	
	
}
