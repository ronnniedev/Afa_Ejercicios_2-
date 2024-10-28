package Persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import Logica.Coche;
import Logica.ExcepcionLogica;

public class GestorCSV {

	public void leerFichero(String nombreFicheroOrigen, List<Coche> coches) {

		int contLineas = 1;
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(nombreFicheroOrigen));
			String linea = buffer.readLine();
			while ((linea = buffer.readLine()) != null) {
				try {
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
						try {
							validarClave(coches,id);
							coches.add(new Coche(id, marca, modelo));
						}catch(ExcepcionLogica e) {
							System.out.println("ERROR " + contLineas + e.getMessage());
						}
						
					} catch (Exception e) {
						throw new ExcepcionPersistencia("Error " +contLineas 
								+" : el campo id no es un numero");
					}

				} catch (ExcepcionPersistencia e) {
					System.out.println(e.getMessage());
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR en la lectura del fichero");
		}
	}

	private void validarClave(List<Coche> coches, int id) throws ExcepcionLogica {
		boolean encontrado = false;
		
		for(int i = 0; i<coches.size();i++) {
			Coche c = coches.get(i);
			if(c.getId() == id) {
				encontrado = true;
			}
		}
		
		if(encontrado) {
			throw new ExcepcionLogica("Error id duplicado");
		}
		
	}
}
