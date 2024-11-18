package modelo;

import excepciones.PersistenciaException;

public class Habitacion {
	
	private int codigo;
	private int codigoHotel;
	private int planta;
	private int ocupacionMax;
	private double  precio;
	
	

	public Habitacion(int codigo, int codigoHotel, int planta, int ocupacionMax, double precio) {
		this.codigo = codigo;
		this.codigoHotel = codigoHotel;
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
	 * @return the codigoHotel
	 */
	public int getCodigoHotel() {
		return codigoHotel;
	}





	/**
	 * @param codigoHotel the codigoHotel to set
	 */
	public void setCodigoHotel(int codigoHotel) {
		this.codigoHotel = codigoHotel;
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
	public void setPrecio(int precio) {
		this.precio = precio;
	}





	public static Habitacion serialize(String linea) throws PersistenciaException {
		String trozos[] = linea.split("\t");
		
		if(trozos.length != 6) {
			throw new PersistenciaException("ERROR linea que tiene numero erroeneo de categorias");
		}
		int codigo = Integer.parseInt(trozos[1]);
		int codigoHotel = Integer.parseInt(trozos[2]);
		int planta = Integer.parseInt(trozos[3]);
		int ocupacion = Integer.parseInt(trozos[4]);
		double precio = Double.parseDouble(trozos[5]);
		
		return new Habitacion(codigo,codigoHotel,planta,ocupacion,precio);
	}





	@Override
	public String toString() {
		return "Habitacion [codigo=" + codigo + ", codigoHotel=" + codigoHotel 
				+ ", planta=" + planta + ", ocupacionMax=" + ocupacionMax 
				+ ", precio=" + precio + "]";
	}





	public static String serialize(Habitacion hab) {
		return "3" + "\t" + hab.getCodigo() + "\t" + hab.getCodigoHotel() + "\t" + hab.planta 
				+ "\t" + hab.getOcupacionMax() + "\t" + hab.getPrecio() + "\n";
	}
	
	

}
