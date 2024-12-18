package ejercicio4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println("Escribe la ruta del directorio:");
		String ruta = keyboard.nextLine() + '\\'; 
		
		
		System.out.println(ruta);
	
		creaDirectorio(ruta + "pruebas");
		creaDirectorio(ruta + "pruebas\\bin");
		creaArchivo(ruta + "pruebas\\bin\\rm.txt");
		creaArchivo(ruta + "pruebas\\bin\\ls.txt");
		creaArchivo(ruta + "pruebas\\bin\\cat.txt");
		creaDirectorio(ruta + "pruebas\\usr");
		creaDirectorio(ruta + "pruebas\\usr\\dan");
		creaDirectorio(ruta + "pruebas\\usr\\bill");
		creaArchivo(ruta + "pruebas\\usr\\bill\\file1.txt");
		creaArchivo(ruta + "pruebas\\usr\\bill\\file2.txt");
		creaArchivo(ruta + "pruebas\\usr\\bill\\file3.txt");
		creaDirectorio(ruta + "pruebas\\usr\\gord");
		
		
		
		System.out.println("Programa finalizado con exito");
		
		
	}
	
	public static void crearSistemaPruebas(String ruta) {
		
		creaDirectorio(ruta + "pruebas");
		creaDirectorio(ruta + "pruebas\\bin");
		creaArchivo(ruta + "pruebas\\bin\\rm.txt");
		creaArchivo(ruta + "pruebas\\bin\\ls.txt");
		creaArchivo(ruta + "pruebas\\bin\\cat.txt");
		creaDirectorio(ruta + "pruebas\\usr");
		creaDirectorio(ruta + "pruebas\\usr\\dan");
		creaDirectorio(ruta + "pruebas\\usr\\bill");
		creaArchivo(ruta + "pruebas\\usr\\bill\\file1.txt");
		creaArchivo(ruta + "pruebas\\usr\\bill\\file2.txt");
		creaArchivo(ruta + "pruebas\\usr\\bill\\file3.txt");
		creaDirectorio(ruta + "pruebas\\usr\\gord");
		
		
		System.out.println("Programa finalizado con exito");
	}
	
	public static void creaDirectorio(String ruta) {
		File f = new File(ruta);
		
		if(f.isDirectory()) {
			System.out.println(f.getName() + " ya existe");
			
		}else {
			f.mkdir();
		}
		
	}
	
	public static void creaArchivo(String ruta) {
		File f = new File(ruta);
		
		if(f.isFile()) {
			System.out.println(f.getName() + " ya existe");
		}else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Algo inesperado ha ocurrido");
				System.out.println(e.getMessage());
			}
		}
		
	}

}
