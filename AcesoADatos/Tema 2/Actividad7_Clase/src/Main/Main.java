package Main;


import java.io.*;
import java.util.Scanner;

import Excepciones.PersistenciaException;
import Logica.CentralReservas;
import Persistencia.GestorTXT;
import Persistencia.Loggerfichero;



public class Main {
	
   public static Scanner teclado=new Scanner(System.in);	
   private CentralReservas central=new CentralReservas();
   
   private String ruta;
   
   public Main() throws IOException{
	   ruta = System.getProperty("user.dir");
	   String fichero = ruta + "\\Datos\\CentralReservas.txt";
	   GestorTXT gestor = new GestorTXT();
	   gestor.cargarDatos(central,fichero);
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
			showMenu();
			opcion = showMenu();
			processOpcion(opcion);
		} while (opcion != 0);
		System.out.print("FIN");
	}

	private int showMenu() {
		String[] opciones = {
			"------ CONTROL de RESERVAS ------",
			"1.- Listar Zonas ",
			"2.- Listar todos los hoteles ",
			"3.- Listar Habitaciones disponibles en fecha en una Zona",
			"4.- Hacer reserva",
			"5.- Cancelar reserva",
			"5.- Listar Reservas de un cliente",
			"6-  Listar reservas de una cliente",
			"7.- Listar reservas de un hotel",
			"8.- Emergencia Eliminar todas las reservas de un hotel en un dia",
			"9.- Emergencia REubicar todas las reservas de un hotel en un dia",
			"--------------" 
		};
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

public void listarZonas(){
	
}
public void listarTodosHoteles(){
	
}
public void listasHabitacionesDisponiblesfechaZona(){
	
}
public void hacerReserva(){
	
}
public void cancelarReserva(){
	
}
public void listarReservasCliente(){
	
}
public void listarReservasHotel(){
	
}
public void eliminarReservasHotelDia(){
	
}
public void reubicarReservasHotelDia(){
	
}

}