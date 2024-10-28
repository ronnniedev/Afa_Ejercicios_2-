package Interfaz;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Logica.Sistema;
import Persistencia.GestorPersistencia;

public class Principal {
	
	
	private static Sistema sistema = new Sistema();
	private static Scanner keyboard= new Scanner(System.in);
	private static GestorPersistencia  gestor;
	public static void main(String[] args) {
		try {
			gestor 
			= new GestorPersistencia(sistema,new BufferedWriter(
					new FileWriter("Datos\\log_errores_entrega.txt")));
			gestor.cargarDatos();
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}
		mostrarMenu();
		int opcion = escogerOpcion();
		procesarOpcion(opcion);
		
		while(opcion != 0) {
			mostrarMenu();
			opcion = escogerOpcion();
			procesarOpcion(opcion);
			
		}
		
		gestor.guardarDatos();
		System.out.println("Cerrando sistema...");
	}
	
	private static void procesarOpcion(int opcion) {
		
		if(opcion < 0 || opcion > 3) {
			System.out.println("Introduce un numero de nuevo");
			return;
		}
	
		switch (opcion) {
        case 1:
        	System.out.println("Entra");
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

	private static void mostrarMenu() {
		String[] menu = {
				"\n-------------- GESTION DE FRANQUICIADO--------------",
				" 1.- Listar clientes", " 2.- ListarConsignas",
				" 3.- ListarReservas",
				" 0.- Salir", "----------------------------------------" };
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
	}
	
	private static int escogerOpcion() {
		int opcion = Integer.MAX_VALUE;
		try {
			System.out.println("Introduce un numero:");
			opcion = keyboard.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Error debes introducir un numero entero");
		}
		//Limpiamos el teclado para que no de un error infinito
		keyboard.nextLine();
		return opcion;
	}


}
