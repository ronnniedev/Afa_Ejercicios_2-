package ejercicio2;

public class Main {

	public static void main(String[] args) {
		Hotel h = new Hotel();
		añadirHabitacion(h,"1A",TipoHabitacion.DOBLE,true);
		añadirHabitacion(h,"1B",TipoHabitacion.MATRIMONIAL,true);
		añadirHabitacion(h,"1C",TipoHabitacion.SIMPLE,true);
		añadirHabitacion(h,"2A",TipoHabitacion.DOBLE,true);
		añadirHabitacion(h,"2B",TipoHabitacion.MATRIMONIAL,true);
		añadirHabitacion(h,"2C",TipoHabitacion.SIMPLE,true);
		
		h.mostrarHabitacionesTipo(TipoHabitacion.DOBLE);
		h.mostrarHabitacionesTipo(TipoHabitacion.MATRIMONIAL);
		h.mostrarHabitacionesTipo(TipoHabitacion.SIMPLE);
		h.preguntarPrecio("1B");
		h.preguntarPrecio("2C");
		h.preguntarPrecio("2BD");
		h.preguntarDescuentoHabituales();
		
		h.añadirCliente("516", "ESP", "mUARHD", Tipo_Cliente.ESPORADICO);
		h.añadirCliente("517", "HAB", "mUARHD", Tipo_Cliente.HABITUAL);
		h.añadirCliente("516", "marcos", "mUARHD", Tipo_Cliente.ESPORADICO);
		
		System.out.println();
		preguntarPrecio(h,"516",TipoHabitacion.DOBLE,3);
		preguntarPrecio(h,"516",TipoHabitacion.MATRIMONIAL,3);
		preguntarPrecio(h,"516",TipoHabitacion.SIMPLE,3);
		preguntarPrecio(h,"517",TipoHabitacion.DOBLE,3);
		preguntarPrecio(h,"517",TipoHabitacion.MATRIMONIAL,3);
		preguntarPrecio(h,"517",TipoHabitacion.SIMPLE,3);
		
		System.out.println("-----------Reservasnoches------------");
		
		
		try {
			h.reservarHabitacion("1B", "516", 3);
			h.reservarHabitacion("2B", "517", 3);
			h.reservarHabitacion("1B", "5187", 3);
		} catch (HabitacionNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (ClienteNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		h.eliminarReserva("2B");
		h.mostrarHabitacionesTipo(TipoHabitacion.MATRIMONIAL);
		
		h.cambiarValorDescuento(0.3);
		
		h.preguntarDescuentoHabituales();
		h.cambiarPrecioPorTipo(TipoHabitacion.MATRIMONIAL,500);
		
	}
	
	public static void añadirHabitacion(Hotel h,String piso, TipoHabitacion tipo, Boolean disponible) {
		
		try {
			h.añadirHabitacion(piso,tipo,disponible);
		} catch (HabitacionAlreadyInException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void preguntarPrecio(Hotel h,String dni,TipoHabitacion tipo,int noches) {
		
		try {
			h.preguntarPrecio(dni,tipo,noches);
		} catch (ClienteNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	


}
