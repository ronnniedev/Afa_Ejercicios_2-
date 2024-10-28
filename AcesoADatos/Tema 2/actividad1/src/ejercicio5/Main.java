package ejercicio5;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Escribe la ruta donde buscaremos el fichero:");
		String ruta = keyboard.nextLine();

		File f = new File(ruta);
		
		if(f.exists() && f.isDirectory()) {
			System.out.println("Este directorio existe");
			
		}else {
			System.out.println("Este directorio no existe");
			
		}
	}

}