package persistencia;

import java.io.File;
import java.util.Scanner;

public class Ejemplo {

	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Introduce ruta: ");
		String ruta = keyboard.nextLine();
		
		File dir = new File(ruta);
		
		System.out.println(ruta);
		
		if(dir.isDirectory()) {
			System.out.println("Es un directorio.");
			String [] ficheros = dir.list();
			for(String elem: ficheros) {
				System.out.println(elem.toString());
			}
		}else {
			System.out.println("ERROR!!!");
			
		}
		
		
		

	}

}
