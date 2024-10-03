package ejercicio2;

public class Main {

	public static void main(String[] args) {
		
		Agenda a = new Agenda();
		agregarEntrada(a,"123456789","Mario","Hamburguesa");
		agregarEntrada(a,"133456789","Ma","Hamburguesa");
		agregarEntrada(a,"223456789","Vero","Hamburguesa");
		agregarEntrada(a,"423456789","Alba","Hamburguesa");
		
		System.out.println(a.buscaContactoNombre("Albyhghyha"));
		try {
			System.out.println(a.buscaContactoTelefono("133456689"));
		} catch (TooLongException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(a.mostrarAgenda());
		
		
	

	}
	
	public static Contacto agregarEntrada(Agenda a ,String numero,String nombre,String direccion) {
		
		
		try {
		a.nuevaEntrada(numero,nombre,direccion);
			 
		} catch (TooLongException e) {
			System.out.println(e.getMessage());
		}
		
		
		return null;
	}

}
