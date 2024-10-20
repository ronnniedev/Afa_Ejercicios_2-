package ejercicio6;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Escribe la ruta donde buscaremos el fichero:");
		String ruta = keyboard.nextLine();
		
		File f = new File(ruta);
		String []files = f.list();
		
		for(String file: files) {
			File archivo = new File(ruta + '\\' + file);
			if(archivo.isDirectory()) {
				System.out.println("D-"+file);
			}else {
				if(archivo.canWrite()&&archivo.canRead()) {
					System.out.println("F-"+file+" (L/E)");
					
				}else if(archivo.canWrite()){
					System.out.println("F-"+file+" (E)");
					
				}else {
					System.out.println("F-"+file+" (L)");
				}
			}
		}
	}

}
