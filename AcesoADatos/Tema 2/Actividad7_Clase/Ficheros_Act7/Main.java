package mp.p9.ui;


import java.io.*;



public class Main {
	
   public static Scanner teclado=new Scanner(System.in);	
   private CentralReservas central=new CentralReservas();
	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		int opcion;
		do {
			showMenu();
			opcion = Util.getMenuOption(7);
			processOpcion(opcion);
		} while (opcion != 0);
		System.out.print("FIN");
	}

	private void showMenu() {
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