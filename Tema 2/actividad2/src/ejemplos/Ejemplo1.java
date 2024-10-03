package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejemplo1 {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Introduce la ruta del fichero: ");
		String ruta = keyboard.nextLine();
		BufferedReader buffer = null;
		
		try {
			buffer = new BufferedReader(new FileReader(ruta));
			String linea = buffer.readLine();
			while(linea!=null) {
				System.out.println("Linea: "+linea);
				linea = buffer.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error File not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				buffer.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
			}
			
		}
		System.out.println("Adios");
	}

}
