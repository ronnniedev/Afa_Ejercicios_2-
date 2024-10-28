package ejercicio1;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Escribe la ruta absoluta: ");
		String ruta = keyboard.nextLine();
		
		File f = new File(ruta);
		
		if(f.isDirectory()) {
			System.out.println("El directorio existe");
			String []elem = f.list();
			for(String e: elem) {
				System.out.println(e.toString());
				
			}
		}else {
			System.out.println("No es un directorio");
		}

	}

}
