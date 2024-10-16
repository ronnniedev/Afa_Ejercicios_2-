package Persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import Logica.Coche;

public class GestorCSV {

	public void leerFichero(String nombreFicheroOrigen,List<Coche>coches) {
		
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(nombreFicheroOrigen));
			String linea = buffer.readLine();
			while((linea=buffer.readLine())!= null) {
				String trozos[]= linea.split(";");
				int id = Integer.parseInt(trozos[0]);
				String marca = trozos[1];
				String modelo = trozos[2];
				coches.add(new Coche(id,marca,modelo));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR fichero origen no encontrado");
		}
	}
}
