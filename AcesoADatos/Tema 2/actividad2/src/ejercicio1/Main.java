package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		File fichero = new File("Ficheros_Act2//restaurantes.csv");
		int indice = 0;
		try {
			FileReader reader = new FileReader(fichero);
			BufferedReader buffer = new BufferedReader(reader);
			
			String linea = "";
			while((linea = buffer.readLine()) != null) {
				indice++;
				System.out.println(indice + "- " + linea);
			}
			buffer.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la lectura del fichero");
		}
		

	}

}
