package ejercicio3;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Escribe la ruta del directorio:");
		String ruta = keyboard.nextLine();
		
		File f = new File(ruta);
		
		if(f.isDirectory()) {
			System.out.println("Directorio encontrado");
			String []elem = f.list();
			
			for(String e: elem) {
				/*
				 * Escribimos dos veces la barra \\ para que la ruta la lea sin caracter especial
				 * despues creamos un archivo y le indicamos que lea el nombre del mismo
				 */
				//if(e.contains(".") && !e.startsWith(".")) {
					//System.out.println(e.toString());	
				//}
				String rutaCompleta = ruta + '\\' + e;
				File archivo = new File(rutaCompleta);
				
				
				if(archivo.isFile()) {
					System.out.println(e.toString());
					
				}
				
				rutaCompleta = "";
			}
		}else {
			System.out.println("Esto no es un directorio");
			
		}

	}

}
