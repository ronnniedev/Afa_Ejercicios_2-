package interfaz;

import java.io.*;

import Logica.Sistema;
import Modelo.Cliente;
import Persistencia.GestorPersistencia;



public class Principal {

	private Sistema sistema = new Sistema();

	private BufferedWriter log;

	private GestorPersistencia gestor;

	public void run() {
		int opcion;
		try {
			log = new BufferedWriter(new FileWriter("log_examen.txt"));
		} catch (IOException e) {
			System.out.print("Error en el log\n");
		}
		gestor = new GestorPersistencia(sistema, log);
		cargarDatosIniciales();
		do {
			mostrarMenu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);
		} while (opcion != 0);
		System.out.println("Fin del programa");
		guardarDatosFinales();
		try {
			log.close();
		} catch (IOException e) {
			try {
				log.write(e.getMessage());
				log.newLine();
			} catch (IOException e1) {
			}
		}
	}

	public void cargarDatosIniciales()  {
		try {gestor.cargarTxt();}
		catch(Exception e){
			System.out.println("Error al cargar el archivo");
		}
		
	}

	public void guardarDatosFinales() {
		try {
			gestor.grabarTxt();
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}
		// gestor.grabarCryptor();
	}

	private void mostrarMenu() {
		String[] menu = {
				"\n-------------- GESTION DE MI VIDEOCLUB --------------",
				" 1.- Listar clientes", " 2.- Listar videos",
				" 3.- Alta de cliente", " 4.- Alquilar video",
				" 5.- Devolver video",
				" 6.- Listar videos alquilados por un cliente", "",
				" 0.- Salir", "----------------------------------------" };
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
	}

	private void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			listarClientes();
			break;
		case 2:
			listarVideos();
			break;
		case 3:
			altaCliente();	
			break;
		case 4:
			alquilarVideo();
			break;
		case 5:

			break;
		case 6:
			listarVideosCliente();
			break;
			}
			
		}

	private int pedirOpcion() {
		int opcion = -1;
		do {
			try {
				opcion = this.pedirEntero(" opcion: ");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} while ((opcion < 0) || (opcion > 12));
		return opcion;
	}

	/**
	 * pide un entero por teclado.
	 * 
	 * @param mensaje
	 *            mensjae que muestra por consola para pedir la entrada
	 * @return entero introducido
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private int pedirEntero(String mensaje){
		System.out.print(mensaje + "\n");
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int value = 0;
		try {
			value = Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * pide un string por teclado
	 * 
	 * @param mensaje
	 *            mensjae que muestra por consola para pedir la entrada
	 * @return string introducida
	 */
	private String pedirString(String mensaje) {
		System.out.print(mensaje + "\n");
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			return teclado.readLine();
		} catch (IOException e) {
			try {
				log.write("Excepcion entrada/salida");
				log.newLine();
			} catch (IOException e1) {
			}
		}
		return "";
	}

	/**
	 * pide por teclado los datos de un nuevo cliente y lo introduce en la
	 * aplicacion
	 * @throws ExcepcionExamen 
	 * @throws LogicaException 
	 */
	private void altaCliente(){
		String dni = pedirString("Introduce el dni:");
		String apellido = pedirString("Introduce el apellido:");
		String nombre = pedirString("Introduce el nombre:");
		String telefono = pedirString("Introduce el telefono");
		sistema.añadirCliente(new Cliente(dni, apellido, nombre, telefono));
	}

	/**
	 * lista todos los clientes Ordenados por apellidos en orden ascendente Una
	 * fila por cada cliente en la que aparecer�n todos sus datos excepto los
	 * alquileres
	 * 
	 */
	private void listarClientes() {
		System.out.println(sistema.listarClientes());
	}

	/**
	 * lista todos los videos Ordenados por T�tulo en orden ascendente Una fila
	 * por cada video en la que aparecer�n todos sus datos
	 */
	private void listarVideos() {
		System.out.println(sistema.listarVideos());
	}

	/**
	 * se piden los datos del cliente que alquila el video y del video que desea
	 * alquilar, y se a�ade el video a la lista de alquileres del cliente
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * @throws ExcepcionExamen 
	 * 
	 */
	private void alquilarVideo(){
		System.out.println("Lista de clientes:\n"+sistema.listarClientes());
		System.out.println("Lista de videos:\n"+sistema.listarVideos());
		String dni = pedirString("Introduce el dni:");
		int codigo = pedirEntero("Intriduce el codigo del libro:");
		sistema.añadirAlqui(dni, codigo);
	}

	/**
	 * se piden por teclado los datos del cliente y video y se elimina el video
	 * de la lista de alquileres del cliente
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * @throws ExcepcionExamen 
	 */
	private void devolverVideo(){
		System.out.println("Lista de clientes:\n\n" + sistema.listarClientes());
		System.out.println("Lista de videos:\n\n"+sistema.listarVideos());
		String dni = pedirString("Introduce el dni:");
		int codigo = pedirEntero("Intriduce el codigo del libro:");
		sistema.borrarAlqui(dni, codigo); 
	}

	/**
	 * se listan todos los videos alquilados por el cliente cuyo DNI se pide por
	 * teclado
	 */
	private void listarVideosCliente() {
		String dni = pedirString("Introduce el dni:");
		sistema.listarAlquileres(dni);
	}

	public static void main(String[] args) {
		new Principal().run();
	}

}
