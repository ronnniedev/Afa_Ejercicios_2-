package Persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import Logica.Coche;

public class GestorCSV2 {

	public void leerFichero(String nombreFicheroOrigen, List<Coche> coches) {

		int contLineas = 1;
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(nombreFicheroOrigen));
			String linea = buffer.readLine();
			while ((linea = buffer.readLine()) != null) {
					contLineas++;
					String trozos[] = linea.split(";");
					if (trozos.length != 3) {
						throw new ExcepcionPersistencia("ERROR " +contLineas 
								+" :faltan parametros");
					}
					try {
						int id = Integer.parseInt(trozos[0]);
						String marca = trozos[1];
						String modelo = trozos[2];

						coches.add(new Coche(id, marca, modelo));
					} catch (Exception e) {
						throw new ExcepcionPersistencia("Error " +contLineas 
								+" : el campo id no es un numero");
					}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR en la lectura del fichero");
		} catch (ExcepcionPersistencia e) {
			System.out.println(e.getMessage());
			coches.clear();
			System.out.println("Vaciando lista");
		}
	}
}
