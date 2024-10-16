package ejercicio4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String ruta = "Ficheros_Act2//restaurantes.csv";
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			reader = new BufferedReader(new FileReader(ruta));
			writer = new BufferedWriter(new FileWriter("Ficheros_Act2//Restaurants2.csv"));
			String linea = "";
			
			while((linea = reader.readLine()) != null) {
				if(analizarZipcode(linea)) {
					writer.write(linea);
					writer.newLine();
				}
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("Acabado");
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static boolean analizarZipcode (String linea) {
		boolean correcto = true;
		
		String []trozos = linea.split(",");
		for(int i = 0;i < trozos.length;i++) {
		//los codigos postales tienen que tener 5 numeros SIEMPRE
		if(trozos[i].length() == 5) {
			boolean hayLetra = false;
			//establecemos el booleano para ver si es el zip
			for(int j = 0 ; j < trozos[i].length(); j++) {
				//si el caracter es alfabetico no leemos la linea
				if(Character.isAlphabetic(trozos[i].charAt(j))) {
					hayLetra = true;
					
				}
				if(!hayLetra && trozos[i].startsWith("6")) {
					correcto = false;
					return correcto;
				}
			}
		}
		
	}
		return correcto;
	}

}
