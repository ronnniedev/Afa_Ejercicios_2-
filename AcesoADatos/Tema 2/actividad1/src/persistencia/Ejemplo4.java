package persistencia;

import java.io.File;
import java.util.Scanner;

public class Ejemplo4 {
	static Scanner keyboard = new Scanner (System.in);
	public static void main(String[] args) {
		
		System.out.println("Introduce ruta completa");
		String ruta = keyboard.next();
		
		File fich = new File(ruta);
		
		if(!fich.exists()) {
			System.out.println("Error fichero no existe");
			
		}else {
			if(fich.isDirectory()) {
				System.out.println("Error es un directorio");
			}else {
				if(fich.delete()) {
					System.out.println("Fichero borrado con exito ");
				}else {
					System.out.println("Error al borrar el fichero");
				}
			}
			
		}

	}

}
