package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import logica.Persona;


public class FicherosCsv {
	
	public boolean cargarFichero(String nombreFichero) {
		BufferedReader buffer= null;
		
		try {
			buffer = new BufferedReader(new FileReader (nombreFichero));
			String linea = buffer.readLine();
			System.out.println(linea);
			
			while((linea = buffer.readLine()) != null) {
				// System.out.println("Linea: " + linea);
				String []trozos = linea.split(",");
				Persona p = new Persona(trozos[0],trozos[1],trozos[2],trozos[3]);
				
				System.out.println(p.toString());
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("Error fichero no encontrado");
			return false;
		}catch (IOException e) {
			System.out.println("Error fichero no encontrado");
			return false;
		}finally {
			try {
				buffer.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
			}
		}
		return true;
		
	}
}
