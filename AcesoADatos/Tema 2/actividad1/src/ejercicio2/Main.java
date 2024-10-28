package ejercicio2;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Escribe la ruta del directorio:");
		String ruta = keyboard.nextLine();
		
		File f = new File(ruta);
		
		if(f.isDirectory() || f.isFile()) {
			System.out.println("Directorio encontrado");
			f.delete();
			System.out.println("Directorio borrado");
			System.out.println("Fin del programa");
		}else {
			System.out.println("Directorio no encontrado");
		}
		
	}

}