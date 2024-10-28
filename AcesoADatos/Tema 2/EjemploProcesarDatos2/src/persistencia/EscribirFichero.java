package persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirFichero {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Ruta del fichero: ");
		String ruta = keyboard.nextLine();
		BufferedWriter buffer;
		
		try {
			 buffer = new BufferedWriter(new FileWriter(ruta));
			for(int i = 0; i < 20; i++) {
				String linea = "Hola soy gorda\n";
				buffer.write(linea);
				
			}
			buffer.close();
		} catch (IOException e) {
			System.out.println("Error al abrir el fichero");
		}
		
		

	}

}
