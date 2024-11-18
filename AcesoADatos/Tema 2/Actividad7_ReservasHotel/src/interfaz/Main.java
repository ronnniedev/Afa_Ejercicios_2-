package interfaz;


import java.io.*;
import java.util.Scanner;

import Excepciones.Loggerfichero;
import Excepciones.LogicaException;
import logica.CentralReservas;
import persistencia.GestorTXT;



public class Main {
	
   public static Scanner teclado=new Scanner(System.in);	
   private CentralReservas central=new CentralReservas();
   
   private String ruta; 
   
   public Main() throws IOException {
	   this.ruta = System.getProperty("user.dir");
	   String fichero = ruta + "\\datos\\CentralReservas.txt";
	   GestorTXT gestor = new GestorTXT();
	   gestor.cargarDatos(central, fichero);
	   System.out.println(central.listarDatos());
	   
   }
   
	public static void main(String[] args) {
		try {
			new Main().run();
		} catch (IOException e) {
			System.out.println("ERROR E/S");
		}
		Loggerfichero.getInstance().closeLog();
	}

	private void run() {	
		int opcion;
		do {
			opcion = showMenu();
			processOpcion(opcion);
		} while (opcion != 0);
		System.out.print("FIN");
	}

	private int showMenu() {
		String[] opciones = {
			"------ CONTROL de RESERVAS ------",
			"1.- Listar Zonas",
			"2.- Listar todos los hoteles ",
			"3.- Listar Habitaciones disponibles en fecha en una Zona",
			"4.- Hacer reserva",
			"5.- Cancelar reserva",
			"6.- Listar Reservas de un cliente",
			"7.- Listar reservas de un hotel",
			"8.- Emergencia Eliminar todas las reservas de un hotel en un dia",
			"9.- Emergencia REubicar todas las reservas de un hotel en un dia",
			"--------------" 
		};
		for (int i = 0; i < opciones.length; i++) {
			System.out.print(opciones[i] + "\n");
		}
		System.out.println("Opcion: ");
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

public void listarZonas(){
	
}
public void listarTodosHoteles(){
	System.out.println(central.listarHoteles());
	
}
public void listasHabitacionesDisponiblesfechaZona(){
	System.out.println("Introduce una fecha: ");
	String fecha = teclado.next();
	System.out.println("Codigo Zona: ");
	int codZona = teclado.nextInt();
	System.out.println("Habitaciones disponibles: ");
	System.out.println(central.listarHabitacionesDisponibles(fecha, codZona));
	
}
public void hacerReserva(){
	System.out.println("Fecha: ");
	String fecha = teclado.next();
	System.out.println("Codigo habitacion: ");
	int codHabitacion = teclado.nextInt();
	System.out.println("DNI Cliente: ");
	String dni = teclado.next();
	try {
		central.hacerReserva(fecha, codHabitacion, dni);
		System.out.println("Reserva realizada con exito.");
	} catch (LogicaException e) {
		Loggerfichero.getInstance().writeSmg(e.toString());
	}
}
public void cancelarReserva(){
	System.out.println("Codigo reserva:");
	int codReserva = teclado.nextInt();
	try {
		central.cancelarReserva(codReserva);
	} catch (LogicaException e) {
		Loggerfichero.getInstance().writeSmg(e.toString());
	}
	
}
public void listarReservasCliente(){
	System.out.println("Listar reservas del cliente");
	System.out.println("DNI:");
	String dni = teclado.next();
	System.out.println(central.listarReservasDni(dni));
	
}
public void listarReservasHotel(){
	System.out.println("Listar reservas del hotel / Cod Hotel:");
	int codHotel = teclado.nextInt();
	System.out.println("Rango de fechas. Fecha inferior: ");
	String fechaInf = teclado.next();
	System.out.println("Rango de fechas. Fecha superior: ");
	String fechaSup = teclado.next();
	try {
		System.out.println(central.listarReservasHotel(codHotel, fechaInf, fechaSup));
	} catch (LogicaException e) {
		Loggerfichero.getInstance().writeSmg(e.toString());
	}
	
}
public void eliminarReservasHotelDia(){
	System.out.println("Listar reservas del hotel / Cod Hotel:");
	int codHotel = teclado.nextInt();
	System.out.println("Fecha: ");
	String fecha = teclado.next();
	try {
		int resul = central.eliminarReservasHotel(codHotel, fecha);
		System.out.println("Se han eliminado " + resul);
	} catch (LogicaException e) {
		System.out.println(e.getMessage());
		Loggerfichero.getInstance().writeSmg(e.toString());
	}
}
public void reubicarReservasHotelDia(){
	
}

}