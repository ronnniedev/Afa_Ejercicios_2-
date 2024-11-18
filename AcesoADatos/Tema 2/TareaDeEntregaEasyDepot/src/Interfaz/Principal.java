package Interfaz;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Excepciones.LogicaException;
import Logica.Sistema;
import Modelo.Cliente;
import Modelo.Consigna;
import Modelo.Email;
import Modelo.Reserva;
import Persistencia.GestorPersistencia;
import Persistencia.Loggerfichero;

public class Principal {

	private static Sistema sistema = new Sistema();
	private static Scanner keyboard = new Scanner(System.in);
	private static GestorPersistencia gestor;
	
	public static void main(String[] args) {
		
		try {
			run();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
	
	/**
	 * Ejecuta la funcion principal del sistema y gestiona toda las actividades del mismo
	 * @throws IOException
	 */
	private static void run() throws IOException {

		gestor = new GestorPersistencia
				(sistema);
		System.out.println("Escribe uno de los dos ficheros para cargarlo:");
		System.out.println("-> ficheros.csv (Carga de datos sin errores)");
		System.out.println("-> pruebaErrores.csv (Carga de datos con errores)");
		String ficheros = pedirString();
		gestor.cargarDatos(ficheros);

		mostrarMenu();
		int opcion = escogerOpcion();
		procesarOpcion(opcion);
		while (opcion != 0) {
			mostrarMenu();
			opcion = escogerOpcion();
			procesarOpcion(opcion);

		}
		gestor.guardarDatos(ficheros);
		System.out.println("Cerrando sistema...");

	}

	
	/**
	 * Procesa la opcion escogida 
	 * @param opcion : int
	 */
	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			while (opcion != 0) {
				mostrarMenuListar();
				opcion = escogerOpcion();
				procesarOpcionListar(opcion);
			}
			break;
		case 2:
			while (opcion != 0) {
				mostrarMenuBuscar();
				opcion = escogerOpcion();
				procesarOpcionBuscar(opcion);
			}
			break;
		case 3:
			while (opcion != 0) {
				mostrarMenuCrear();
				opcion = escogerOpcion();
				procesarOpcionCrear(opcion);
			}
			break;
		case 4:
			while (opcion != 0) {
				mostrarMenuEliminar();
				opcion = escogerOpcion();
				procesarOpcionEliminar(opcion);
			}
			break;
		case 5:
			while (opcion != 0) {
				mostrarMenuModificar();
				opcion = escogerOpcion();
				procesarOpcionModificar(opcion);
			}
			break;
		case 6:
			hacerReserva();
			break;
		case 7:
			cerrarReserva();
			break;
		case 8:
			while (opcion != 0) {
				mostrarMenuIncidencias();
				opcion = escogerOpcion();
				procesarOpcionIncidencias(opcion);
			}
			break;
		case 0:
			break;
		default:
			System.out.println("Introduce un numero de los que se muestran en la lista");
			break;
		}

	}

	/**
	 * Procesa la opcion escogida en el menu modificar
	 * @param opcion : int
	 */
	private static void procesarOpcionModificar(int opcion) {
		switch (opcion) {
		case 1:
			try {
				System.out.println("Introduce el email del cliente a modificar");
				String email = pedirString();
				Cliente c = sistema.buscarCliente(email);
				while (opcion != 0) {
					System.out.println("Este es el cliente a cambiar:");
					System.out.println(c.toString());
					System.out.println("¿Que quieres cambiar?");
					mostrarMenuModificarCliente();
					opcion = escogerOpcion();
					procesarOpcionModificarCliente(opcion,c);
				}
			} catch (LogicaException e) {
				System.out.println(e.getMessage());
			}
			
			break;
		case 2:
			modificarDireccionConsigna();
		case 0:
			break;
		default:
			System.out.println("Introduce un numero de los que se muestran en la lista");
			break;
		}
		
	}
	
	/**
	 * Procesa la opcion modificar cliente del menu Modificar cliente
	 * @param opcion : int
	 * @param c : Cliente
	 */
	private static void procesarOpcionModificarCliente(int opcion,Cliente c) {
		switch (opcion) {
		case 1:
			System.out.print("Introduce el nuevo nombre:");
			String nombre = pedirString();
			keyboard.nextLine();
			System.out.print("Introduce los nuevos apellidos:");
			String apellidos = keyboard.nextLine();
			sistema.cambiarNombreApellidos(nombre,apellidos,c);
			break;
		case 2:
			System.out.println("Introduce un nuevo email:");
			String email = pedirString();
			modificarEmail(c,email);
			break;
		case 3:
			System.out.print("Introduce la nueva contraseña: ");
			String contraseña = pedirString();
			sistema.cambiarContraseña(c, contraseña);
			break;
		case 4:
			System.out.println("Introduce el nuevo telefono, "
					+ "debe tener 9 cifras y ser todas numericas:");
			String telefono = keyboard.next();
			while (!sistema.comprobarTelefono(telefono)) {
				System.out.println("Dinos tu telefono");
				telefono = pedirString();
			}
			sistema.cambiarTelefono(c,telefono);
			break;
		case 0:
			break;
		default:
			System.out.println("Introduce un numero de los que se muestran en la lista");
			break;
		}
		
	}

	
	/**
	 * Procesa los datos recogidos en el menu de modificarCliente y los manda al sistema
	 * @param c : Cliente
	 * @param email : String
	 */
	private static void modificarEmail(Cliente c, String email) {
		try {
			sistema.comprobarSiEmailEstaGuardado(email);
			sistema.cambiarEmail(c,email);
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}
		
	}

	/**
	 * Pide los datos pertinenetes para la busqueda de y cambio de la direccion consigna, da , imprime
	 * un avisos si no se encuentra la consigna
	 */
	private static void modificarDireccionConsigna() {
		System.out.println("De las siguiente consignas escribe la id de la consigna "
				+ "que quieres cambiarle la direccion:");
		System.out.println(sistema.listarConsignas());
		System.out.println("Escribe aqui la id de la consigna a editar:");
		try {
			int id = keyboard.nextInt();
			Consigna c = sistema.buscarConsigna(id);
			if(c == null) {
				System.out.println("No se ha encontrado la consigna ");
				return;
			}
			System.out.println("------Consigna seleccionada------");
			System.out.println(c.toString());
			System.out.print("Escribe aqui la nueva direccion de la consigna:");
			keyboard.nextLine();
			String direccion = keyboard.nextLine();
			sistema.cambiarDireccionConsigna(c , direccion);
			System.out.println("Direccion cambiada con exito, compruebela a continuacion:");
			System.out.println(c.toString());
		} catch (InputMismatchException e) {
			System.out.println("Escribe el numero de manera correcta, " + "vuelve a seleccionar buscar consigna");
			keyboard.nextLine();
		}
		
	}

	/**
	 * Muestra las opciones del menu de modificación
	 */
	private static void mostrarMenuModificar() {
		String[] menu = { "\n-------------- GESTION DE MODIFICACION--------------", 
				" 1.- Modificar Cliente",
				" 2.- Modificar direccion Consigna", 
				" 0.- Salir"
				, "----------------------------------------" };
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
		
	}

	/**
	 * Procesa la opción escogida en el menu de eliminación
	 * @param opcion : int 
	 */
	private static void procesarOpcionEliminar(int opcion) {
		
		switch (opcion) {
		case 1:
			eliminarConsigna();
			break;
		case 2:
			eliminarCliente();
			break;
		case 3:
			eliminarReserva();
			break;
		case 0:
			break;
		default:
			System.out.println("Introduce un numero de los que se muestran en la lista");
			break;
		}
		
	}

	

	/**
	 * Pide la información pertinente para eliminar un cliente y la manda al sistema
	 */
	private static void eliminarCliente() {
		System.out.println("A continuacion se muestran los clientes");
		System.out.println(sistema.listarClientes());
		System.out.print("Escribe la id del cliente a eliminar"
				+ ", en las reservas dejara de figurar su email):");
		String idCliente = pedirString();
		try {
			sistema.eliminarCliente(idCliente);
			System.out.println("Borrado con exito");
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}
		
	}

	/**
	 * Pide la información pertinente para eliminar una consigna y la manda al sistema
	 */
	private static void eliminarConsigna() {
		System.out.println("A continuacion se muestran las consignas en el sistema:");
		System.out.println(sistema.listarConsignas());
		System.out.println("Escriba a continuacion la id de la consigna que quiere eliminar "
				+ "(tenga en cuenta que esto eliminar las reservas alojadas en la consigna tambien):");
		
		try {
			int id = keyboard.nextInt();
			Consigna c = sistema.buscarConsigna(id);
			if(c == null) {
				System.out.println("Esta consigna no figura en el sistema");
				return;
			}
			sistema.eliminarConsigna(c);
			System.out.println("Borrado con exito");
		} catch (InputMismatchException e) {
			System.out.println("ERROR debe escribir un numero");
			keyboard.nextLine();
		}
		
		
	}
	
	/**
	 * Pide la información pertinente para eliminar la reserva y la manda al sistema
	 */
	private static void eliminarReserva() {
		System.out.println("A continuacion se muestran las reservas en el sistema:");
		System.out.println(sistema.listarReservas());
		System.out.println("Escribe la id de la reserva que quieres eliminar:");
		String idReserva = pedirString();
		try {
			Reserva r = sistema.buscarReserva(idReserva);
			sistema.eliminarReserva(r);
			System.out.println("Eliminado con exito");
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	/**
	 * Procesa la opcion de incidencias recogida en el menu de incidencias
	 * @param opcion : int
	 */
	private static void procesarOpcionIncidencias(int opcion) {

		switch (opcion) {
		case 1:
			abrirIncidencia();
			break;
		case 2:
			cerrarIncidencia();
			break;
		case 0:
			break;
		default:
			System.out.println("Introduce un numero de los que se muestran en la lista");
			break;
		}

	}
	
	/**
	 * Procesa la opcion escogida en el menu de Crear y escoge la funcion pertinente
	 * @param opcion : int
	 */
	private static void procesarOpcionCrear(int opcion) {

		switch (opcion) {
		case 1:
			crearConsigna();
			break;
		case 2:
			crearCliente();
			break;
		case 0:
			break;
		default:
			System.out.println("Introduce un numero de los que se muestran en la lista");
			break;
		}
	}

	/**
	 * Recoge la informacion pertinenete para cerrar una incidencia y la manda al sistema
	 */
	private static void cerrarIncidencia() {
		System.out.println("Estas son actualmente las reservas con incidencias abiertas: ");
		try {
			System.out.println(sistema.mostrarIncidenciasAbiertas());
			System.out.println("Escoga la incidencia que quiere cerrar "
					+ "seleccionando la id (recuerde que debe ser con el formato N-N) " + "de la reserva");
			Reserva r = sistema.buscarReserva(pedirString());
			System.out.println("Escriba a continuacion la resolucion a reportar");
			keyboard.nextLine();
			String resolucion = keyboard.nextLine();
			sistema.cerrarIncidencia(r, resolucion + new Date().toString());
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Recoge la información pertinente para abrir una Incidencia y la manda al sistema
	 */
	private static void abrirIncidencia() {
		System.out.println("Estas son actualmente las reservas sin incidencias: ");
		try {
			System.out.println(sistema.mostrarIncidenciasCerradas());
			System.out.println("Escoga la incidencia que quiere abrir "
					+ "seleccionando la id (recuerde que debe ser con el formato N-N) " + "de la reserva");
			Reserva r = sistema.buscarReserva(pedirString());
			System.out.println("Escriba a continuacion la incidencia a reportar");
			keyboard.nextLine();
			String incidencia = keyboard.nextLine();

			sistema.abrirIncidencia(r, incidencia + new Date().toString());
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Recoge la información pertinente para cerrar una Incidencia reserva y la manda al sistema
	 */
	private static void cerrarReserva() {
		System.out.println("Escribe el email del cliente que va a cerrar la reserva: ");
		String email = pedirString();
		try {
			Cliente c = sistema.buscarCliente(email);
			System.out.println(sistema.mostrarReservasAbiertasCliente(c));
			System.out.println("Escribe la id de la reserva que buscas: ");
			String reservaId = pedirString();
			sistema.cerrarReserva(reservaId);
			System.out.println("Reserva cerrada con exito, se muestra a continuacion");
			System.out.println(sistema.buscarReserva(reservaId).toString());
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}

	}
	

	/**
	 * Recoge la informacion pertinente para crear una reserva y la manda al sistema
	 */
	private static void hacerReserva() {
		System.out.println("Escribe el email del cliente: ");
		String email = pedirString();
		try {
			Cliente c = sistema.buscarCliente(email);
			System.out.println("Escribe la id de la consigna donde quieres hacer la reserva");
			System.out.println(sistema.listarConsignas());
			System.out.println("Escribe la consigna donde quieres hacer la reserva: ");
			int id = keyboard.nextInt();
			Consigna con = sistema.buscarConsigna(id);
			if (con == null) {
				System.out.println("La consigna no ha sido encontrada");
				return;
			}
			Reserva r = new Reserva(c.getEmail(), con);
			sistema.addReserva(r);
			System.out.println("Añadido con exito\n Se muestra a continuacion:\n" + r.toString());
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Escribe un numero apra la consigna, volviendo al menu");
		}

	}

	/**
	 * Recoge la información pertinente para crear un cliente y la manda al sistema
	 */
	private static void crearCliente() {
		System.out.println("-------CREACION DE CLIENTES--------");
		System.out.println("Dinos tu nombre:");
		String nombre = keyboard.nextLine();
		System.out.println("Dinos tus apellidos:");
		String apellidos = keyboard.nextLine();
		System.out.println("Dinos tu telefono");
		String telefono = pedirString();
		while (!sistema.comprobarTelefono(telefono)) {
			System.out.println("Dinos tu telefono");
			telefono = pedirString();
		}
		System.out.println("Dinos tu email:");
		String email = pedirString();
		System.out.println("Escribe una contraseña:");
		String contraseña = pedirString();
		Cliente c = new Cliente(nombre, apellidos, telefono, email, contraseña);
		try {
			sistema.addCliente(c);
			System.out.println("Añadido con exito");
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
			System.out.println("Abortando creacion de cliente " + ", vuelve a seleccionar esta opcion desde el menu");
		}

	}

	/**
	 * Recoge toda la información pertinente para crear una consigna y la manda al sistema
	 */
	private static void crearConsigna() {
		System.out.println("-------CREACION DE CONSIGNAS--------");
		System.out.println("Introduce la nueva id para la consigna, " + "observa que no exista ya la id "
				+ "(debe ser numerica y menor de 100 y mayor que 0)");
		System.out.println("Las consignas registradas son las siguientes:");
		System.out.println(sistema.listarConsignas());
		System.out.print("Escribe aqui la id de la nueva consigna");
		int id = Integer.MAX_VALUE;
		while (id <= 0 || id > 100) {
			try {
				id = keyboard.nextInt();
				if (id <= 0 || id > 100) {
					System.out.println("Escribe un valor superior a 0 y menor o igual que 100");
				}
				if (sistema.buscarConsigna(id) == null) {
					System.out.print("Escribe la direccion de la consigna: ");
					keyboard.nextLine();
					String direccion = keyboard.nextLine();
					Consigna c = new Consigna(id, direccion);
					try {
						sistema.addConsigna(c);
					} catch (LogicaException e) {
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("Ya existe esta consigna");
					return;
				}
			} catch (InputMismatchException e) {
				System.out.println("ERROR debe escribir un numero, volviendo al menu");
			}
		}
	}

	/**
	 * Recoge la opción que escogimos en el menu buscar y deriva a la funcion pertinente
	 * @param opcion : int
	 */
	private static void procesarOpcionBuscar(int opcion) {
		mostrarMenuBuscar();

		switch (opcion) {
		case 1:	
			visualizarCliente();
			break;
		case 2:
			visualizarConsigna();
			break;
		case 3:
			visualizarReserva();
			break;
		case 0:
			break;
		default:
			System.out.println("Opción no válida. Por favor selecciona una opción entre 1 y 3.");
			break;
		}

	}

	/**
	 * Pide los datos pertinentes para buscar una Reserva y la visualiza
	 */
	private static void visualizarReserva() {
		System.out.println("Escribe la id de la consigna donde esta la reserva: ");
		System.out.println(sistema.listarConsignas());
		System.out.print("Escribe aqui la id:");
		try {
			int idConsigna = keyboard.nextInt();
			Consigna c = sistema.buscarConsigna(idConsigna);
			if (c == null) {
				System.out.println("ERROR consigna no encontrada");
				return;
			}
			System.out.println("A continuacion se muestras las reservas dentro de esta consigna");
			System.out.println(c.listarReservas());
			System.out.print("Escribe aqui la id:");
			String idReserva = pedirString();
			Reserva r = c.buscarReserva(idReserva);
			System.out.println(r.toString());
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Escribe el numero de manera correcta, " + "vuelve a seleccionar buscar consigna");
			keyboard.nextLine();
		}
	}

	/**
	 * Pide los datos pertinentes para visualizar una consigna y la muestra por pantalla
	 */
	private static void visualizarConsigna() {
		System.out.println("Escribe la id  pertinente entre los siguientes: ");
		System.out.println(sistema.listarConsignas());
		System.out.print("Escribe aqui un numero:");
		try {
			int id = keyboard.nextInt();
			Consigna c = sistema.buscarConsigna(id);
			if (c != null) {
				System.out.println(sistema.buscarConsigna(id).toString());
			} else {
				System.out.println("Consigna no encontrada");
			}
		} catch (InputMismatchException e) {
			System.out.println("Escribe el numero de manera correcta, " 
					+ "vuelve a seleccionar buscar consigna");
			keyboard.nextLine();
		}
	}

	/**
	 * Pide los datos pertinentes para visualizar un cliente y los muestra por pantalla
	 */
	private static void visualizarCliente() {
		System.out.println("Escribe el email pertinente entre los siguientes: ");
		System.out.println(sistema.listarClientes());
		System.out.print("Escribe aqui el email:");
		String email = pedirString();
		System.out.println();
		try {
			Cliente c = sistema.buscarCliente(email);
			System.out.println(c.toString());
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Pride y retorna un String
	 * @return String
	 */
	private static String pedirString() {
		return keyboard.next();
	}

	/**
	 * Procesa la opcion seleccionada en el menu Listar
	 * @param opcion : int
	 */
	private static void procesarOpcionListar(int opcion) {

		switch (opcion) {
		case 1:
			System.out.println(sistema.listarClientes());
			break;
		case 2:
			System.out.println(sistema.listarConsignas());
			break;
		case 3:
			System.out.println(sistema.listarReservas());
			break;
		case 0:
			break;
		default:
			System.out.println("Opción no válida. Por favor selecciona una opción entre 1 y 3.");
			break;
		}

	}
	
	/**
	 * Muestra el menu eliminar por pantalla
	 */
	private static void mostrarMenuEliminar() {
		String[] menu = { "\n-------------- GESTION DE ELIMINACION--------------", 
				" 1.- Eliminar Consigna",
				" 2.- Eliminar Cliente", 
				" 3.- Eliminar reserva", 
				" 0.- Salir", "----------------------------------------" };
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
		
	}

	/**
	 * Muestra el menu principal por pantalla
	 */
	private static void mostrarMenu() {
		String[] menu = { "\n-------------- GESTION DE FRANQUICIADO--------------", " 1.- Listar elementos",
				" 2.- Buscar elementos", " 3.- Crear Elemento", " "
				+ "4.- Eliminar Elementos", " 5.- Modificar Elemento",
				" 6.- Hacer reserva", " 7.- Cerrar reserva", 
				" 8.- Gestionar incidencias", " 0.- Salir",
				"----------------------------------------" };
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
	}

	/**
	 * Muestra el menu crear por pantalla
	 */
	private static void mostrarMenuCrear() {
		String[] menu = { "\n-------------- GESTION DE CREACION--------------", " 1.- Crear Consigna",
				" 2.- Crear Cliente", " 0.- Salir", "----------------------------------------" };
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
	}

	/**
	 * Muestra el menu buscar por pantalla
	 */
	private static void mostrarMenuBuscar() {
		String[] menu = { "\n-------------- GESTION DE BUSQUEDAS--------------", " 1.- Buscar Clientes",
				" 2.- Buscar Consignas", " 3.- Buscar Reservas", " 0.- Salir",
				"----------------------------------------" };
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}

	}

	/**
	 * Muestra el menu listar por pantalla
	 */
	private static void mostrarMenuListar() {
		String[] menu = { "\n--------------¿Que quieres ver?--------------", " 1.- Listar Clientes",
				" 2.- ListarConsignas", " 3.- ListarReservas", " 0.- Salir",
				"----------------------------------------" };
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}

	}

	/**
	 * Muestra el menu incidencias por pantalla
	 */
	private static void mostrarMenuIncidencias() {
		String[] menu = { "\n--------------Gestion Incidencias--------------", " 1.- Abrir incidencias",
				" 2.- Cerrar Incidencias", " 0.- Salir", "----------------------------------------" };
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
	}
	
	/**
	 * Muestra el menu modificar por pantalla
	 */
	private static void mostrarMenuModificarCliente() {
		String[] menu = { "\n-------------- Modificar Cliente--------------"
				, " 1.- Cambiar Nombre Y apellidos",
				" 2.- Cambiar email"
				," 3.- Cambiar contraseña"
				, " 4.-Cambiar Telefono"," 0.- Salir", 
				"----------------------------------------" };
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
	}
	
	/**
	 * Pide un Int para escoge la opcion en los distinto menus
	 * @return Int
	 */
	private static int escogerOpcion() {
		int opcion = Integer.MAX_VALUE;
		try {
			System.out.println("Introduce un numero:");
			opcion = keyboard.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error debes introducir un numero entero");
		}
		// Limpiamos el teclado para que no de un error infinito
		keyboard.nextLine();
		return opcion;
	}

}
