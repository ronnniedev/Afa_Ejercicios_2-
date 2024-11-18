package interfaz;

import logica.Aeropuerto;

public class Main {
	private Aeropuerto ga;
	private final int SALIR = 0;

	public Main()  {
		ga = new Aeropuerto();
		
		

	}

	public static void main(String[] args) {
		
			new Main().run();
		
	}

	private void run()  {
		int opcion;
		
		do {
			showMenu();
			opcion = pedirOpcion();
			processOpcion(opcion);
		} while (opcion != 0);
		
		System.out.println("FIN");
	}

	private void showMenu() {
		String[] opciones = { "------ Examen Junio 08 ------", "",
				"1- Listar compañias y vuelos",
				"2- Listar todos los vuelos",
				"3- Listar los pasajeros de un vuelo",
				"4- Eliminar un vuelo",
				"5- Eliminar pasajeros",
				"0- Salir", "--------------" };
		for (int i = 0; i < opciones.length; i++) {
			System.out.println(opciones[i]);
		}
	}

	private int pedirOpcion() {
		int opcion = 0;
		do {
			opcion = pedirEntero("Opcion: ");
			if (opcion > 5 || opcion < SALIR) {
				System.out.println("Opcion invalida, repite");
			}
		} while (opcion > 5 || opcion < SALIR);
		return opcion;
	}

	private int pedirEntero(String mensaje) {
		int entero = 0;
		// COMPLETAR
		
		return entero;
	}

	public String pedirString(String msg) {
		System.out.print(msg);
		
		// COMPLETAR
		
		return "";
	}

	private void processOpcion(int opcion) {
		switch (opcion) {
		case 1:
			listarCompañiasVuelos();
			break;
		case 2:
			listarVuelos();
			break;
		case 3:
			listarPasajeros();
			break;
		case 4:
			eliminarVuelo();
			break;
		case 5:
			eliminarPasajeros();
			break;
		
		}
	}

	private void listarCompañiasVuelos() {
		// p.println(ga.listarCompañias());
		// p.println(ga.listarVuelos(pedirString("Nombre Compañia:")));
	}

	private void listarVuelos() {
		
	}

	private void listarPasajeros() {
		

	}

	private void eliminarVuelo() {
		

	}

	private void eliminarPasajeros() {
		
	}

	private void guardarDatosFinales() {
	    
	   
	  }
}
