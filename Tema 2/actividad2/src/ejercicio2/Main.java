package ejercicio2;

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
				String []trozos = linea.split(",");
				indice++;
				for(int i = 0;i < trozos.length;i++) {
					//los codigos postales tienen que tener 5 numeros SIEMPRE
					if(trozos[i].length() == 5) {
						//establecemos el booleano para ver si es el zip
						boolean correcto = true;
						for(int j = 0 ; j < trozos[i].length(); j++) {
							//si el caracter es alfabetico no leemos la linea
							if(Character.isAlphabetic(trozos[i].charAt(j))) {
								correcto = false;
								
							}
						}
						//si todo son numeros y comienza con 6 leemos la linea
						if(correcto && trozos[i].startsWith("6")) {
							System.out.println("-" + indice + " "+ linea);
							
						}
					}
					
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
