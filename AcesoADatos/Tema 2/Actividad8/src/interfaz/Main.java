package interfaz;

import java.io.IOException;
import java.util.Scanner;

import excepciones.LogicaException;
import logica.GestorAeropuerto;

public class Main {

	private GestorAeropuerto ga;
	final int SALIR = 5;
	private static Scanner keyboard = new Scanner (System.in);
	
	public Main() throws IOException  {
		ga = new GestorAeropuerto();
		ga.cargarDatos("Datos\\entrada-errores.txt");
	}

	public static void main(String[] args) {
		
			try {
				new Main().run();
			} catch (IOException e) {
				System.out.println("Error al cargar el sistema, cerrando");
			}
		
	}

	private void run()  {
		int opcion;
		do {
			showMenu();
			opcion = pedirOpcion();
			processOpcion(opcion);
		} while (opcion != 0);
		guardarDatosFinales();
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
			if (opcion < 0 || opcion > SALIR) {
				System.out.println("Opcion invalida, repite");
			}
		} while (opcion < 0 || opcion > SALIR);
		return opcion;
	}

	private int pedirEntero(String mensaje) {
		int entero = keyboard.nextInt();;
		return entero;
	}

	public String pedirString(String msg) {
		System.out.print(msg);
		
		return keyboard.next();
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
		System.out.println(ga.listarCompañias());
		try {
			System.out.println(ga.listarVuelos(pedirString("Nombre Compañia:")));
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarVuelos() {
		System.out.println(ga.listarVuelos());
	}

	private void listarPasajeros() {
		try {
			System.out.println(ga.listarPasajeros(pedirString("Codigo Vuelo:")));
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}

	}

	private void eliminarVuelo() {
		try {
			ga.eliminarVuelo(pedirString("Codigo Vuelo: "));
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}

	}

	private void eliminarPasajeros() {
		try {
			ga.eliminarPasajeros(pedirString("Codigo VueloOrigen: ")
								,pedirString("Codigo VueloDestino: "));
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}
	}

	private void guardarDatosFinales() {
	    ga.guardarDatos("Datos\\Salida.txt");
	   
	  }
}
