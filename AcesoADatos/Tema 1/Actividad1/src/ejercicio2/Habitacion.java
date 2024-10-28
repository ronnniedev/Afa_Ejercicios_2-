package ejercicio2;

public class Habitacion implements Comparable{
	
	private String piso;
	private int precio;
	private TipoHabitacion tipo;
	private boolean disponible;
	private static int PRECIO_MATRIMONIAL = 200;
	private static int PRECIO_SIMPLE = 100;
	private static int PRECIO_DOBLE= 300;
	
	
	public Habitacion(String piso,TipoHabitacion tipo, boolean disponible) {
		this.piso = piso;
		this.tipo = tipo;
		this.precio = asignarPrecio();
		this.disponible = disponible;
	}
	
	public int asignarPrecio() {
		int precio = 0;
		if(this.tipo == TipoHabitacion.DOBLE) {
			precio = PRECIO_DOBLE;
		}else if(this.tipo == TipoHabitacion.MATRIMONIAL) {
			precio = PRECIO_MATRIMONIAL;
		}else{
			precio = PRECIO_SIMPLE;
		}
		
		return precio;
	}


	public String getPiso() {
		return piso;
	}


	public void setPiso(String piso) {
		this.piso = piso;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public TipoHabitacion getTipo() {
		return tipo;
	}


	public void setTipo(TipoHabitacion tipo) {
		this.tipo = tipo;
	}
	
	
	
	public static int getPRECIO_MATRIMONIAL() {
		return PRECIO_MATRIMONIAL;
	}

	public static void setPRECIO_MATRIMONIAL(int pRECIO_MATRIMONIAL) {
		PRECIO_MATRIMONIAL = pRECIO_MATRIMONIAL;
	}

	public static int getPRECIO_SIMPLE() {
		return PRECIO_SIMPLE;
	}

	public static void setPRECIO_SIMPLE(int pRECIO_SIMPLE) {
		PRECIO_SIMPLE = pRECIO_SIMPLE;
	}

	public static int getPRECIO_DOBLE() {
		return PRECIO_DOBLE;
	}

	public static void setPRECIO_DOBLE(int pRECIO_DOBLE) {
		PRECIO_DOBLE = pRECIO_DOBLE;
	}

	@Override
	public String toString() {
		return "Habitacion [piso=" + piso + ", precio=" + precio 
				+ ", tipo=" + tipo + ", disponible=" + disponible
				+ "]";
	}


	@Override
	public int compareTo(Object o) {
		Habitacion other = (Habitacion)o;
		return other.piso.compareTo(this.piso);
	}


	
	
	
	
	

}
