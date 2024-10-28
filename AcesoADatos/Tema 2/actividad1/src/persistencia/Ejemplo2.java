package persistencia;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejemplo2 {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Introduce ruta: ");
		String ruta = keyboard.next();
		
		File dir = new File(ruta);
		
		if(dir.isDirectory()) {
			System.out.println("Directorio ya creado");
		}else {
			if(dir.isFile()) {
				System.out.println("Error no me has pasado un directorio");
				
			}else {
				boolean resul = dir.mkdir();
				if(resul== false) {
					System.out.println("Error al crear el directorio");
				}else {
					System.out.println("Directorio creado");
					File fich = new File("prueba.txt");
					try {
						fich.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		}
		
	}

}
