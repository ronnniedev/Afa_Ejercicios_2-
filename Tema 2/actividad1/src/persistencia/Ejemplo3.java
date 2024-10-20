package persistencia;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejemplo3 {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Introduce ruta: ");
		String ruta = keyboard.nextLine();
		
		File dir = new File(ruta);
		System.out.println(dir.getAbsolutePath());
		
		
		if(!dir.exists()) {
			// no ha encontrado nada
			dir.mkdir();
			System.out.println("Directorio creado");
			File fich = new File(ruta,"datos.txt");
			try {
				fich.createNewFile();
			} catch (IOException e) {
				System.out.println("Error al crear el fichero");
			}
		}else {
			if(dir.isDirectory()) {
				String ficheros[]= dir.list();
				boolean encontrado = false;
				for(int i = 0;i < ficheros.length;i++) {
					if(ficheros[i].compareTo("datos.txt")==0) {
						System.out.println(ficheros[i]);
						encontrado=true;
					}
				}
				if(encontrado) {
					System.out.println("Ficheros encontrado");
					File fichero = new File(ruta,"datos.txt");
					System.out.println(fichero.length());
				}else {
					System.out.println("Fichero no encontrado");
					File fichero = new File(ruta, "datos.txt");
					try {
						fichero.createNewFile();
						System.out.println("Fichero creado");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
			}else {
				System.out.println("Directorio no encontrado");
				
			}
			
		}
		
	}
}
