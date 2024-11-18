package principal;

import java.io.*;
import java.util.Scanner;

import excepciones.LogicaException;
import logica.CentralReservas;

public class Main {

	public static Scanner teclado = new Scanner(System.in);
	private CentralReservas central = new CentralReservas();

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		int opcion;
		do {
			opcion = showMenu();
			processOpcion(opcion);
		} while (opcion != 0);
		central.guardarDatos();
		System.out.print("FIN");
	}

	private int showMenu() {
		String[] opciones = { "------ CONTROL de RESERVAS ------\n", "1.- Listar Zonas\n ", "2.- Listar todos los hoteles \n",
				"3.- Listar Habitaciones disponibles en fecha en una Zona\n", "4.- Hacer reserva \n", "5.- Cancelar reserva \n", "6-  Listar reservas de una cliente \n",
				"7.- Listar reservas de un hotel \n", "8.- Emergencia Eliminar todas las reservas de un hotel en un dia \n",
				"9.- Emergencia REubicar todas las reservas de un hotel en un dia \n", "-------------- \n" };
		for (int i = 0; i < opciones.length; i++) {
			System.out.print(opciones[i]);
		}

		System.out.println("Opcion:");
		int opcion = teclado.nextInt();
		return opcion;
	}

	private void processOpcion(int opcion) {
		switch (opcion) {
		case 1:
			listarZonas();
			break;
		case 2:
			listarTodosHoteles();
			break;
		case 3:
			listasHabitacionesDisponiblesfechaZona();
			break;
		case 4:
			hacerReserva();
			break;
		case 5:
			cancelarReserva();
			break;
		case 6:
			listarReservasCliente();
			break;
		case 7:
			listarReservasHotel();
			break;
		case 8:
			eliminarReservasHotelDia();
			break;
		case 9:
			reubicarReservasHotelDia();
			break;

		}

	}

	public void listarZonas() {
		System.out.println(central.listarZonas());

	}

	public void listarTodosHoteles() {
		System.out.println(central.listarHoteles());
	}

	public void listasHabitacionesDisponiblesfechaZona() {
		System.out.println("Dime el identificador:");
		int identificador = teclado.nextInt();
		System.out.println("Escribeme la fecha:");
		String fecha = teclado.next();
		try {
			System.out.println(central.listarPorFecha(identificador, fecha));
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}
	}

	public void hacerReserva() {
		
		System.out.println("Escribeme el codigo de la habitacion: ");
		int codHab = teclado.nextInt();
		System.out.println("Escribe tu dni:");
		String dni = teclado.next();
		System.out.println("Escribeme la fecha: ");
		String fecha = teclado.next();
		try {
			central.hacerReserva(codHab,dni,fecha);
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}
	}

	public void cancelarReserva() {
		System.out.println("Escribeme el codigo de la reserva a eliminar: ");
		int codigoReserva = teclado.nextInt();
		try {
			central.cancelarReserva(codigoReserva);
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}

	}

	public void listarReservasCliente() {

		System.out.println("Escribeme el dni de un cliente: ");
		String dni = teclado.next();
		
		try {
			System.out.println(central.listarReservasCliente(dni));
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarReservasHotel() {
		
		System.out.println("Dime el codigo del hotel: ");
		int codHotel = teclado.nextInt();
		
		try {
			System.out.println(central.reservasHotel(codHotel));
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}

	}

	public void eliminarReservasHotelDia() {
		System.out.println("Escribeme la fecha de las reservas a eliminar: ");
		String fecha = teclado.next();
		
		central.emergenciaPorDias(fecha);
		
	}

	public void reubicarReservasHotelDia() {
		System.out.println("Dime el codigo del hotel: ");
		int codigoHotel = teclado.nextInt();
		System.out.println("Dime la fecha de las reservas a reubicar:");
		String fecha = teclado.next();
		try {
			central.reubicarReservas(codigoHotel,fecha);
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}
	}

}