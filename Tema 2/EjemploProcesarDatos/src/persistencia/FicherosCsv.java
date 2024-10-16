package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import logica.Agenda;
import logica.Persona;


public class FicherosCsv {
	
	public boolean cargarFichero(String nombreFichero,Agenda a) {
		BufferedReader buffer= null;
		
		try {
			buffer = new BufferedReader(new FileReader (nombreFichero));
			String linea = buffer.readLine();
			System.out.println(linea);
			
			while((linea = buffer.readLine()) != null) {
				// System.out.println("Linea: " + linea);
				String []trozos = linea.split(",");
				Persona p = new Persona(trozos[0],trozos[1],trozos[2],trozos[3]);
				
				a.addPersona(p);
				
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

	public static boolean  escribirFichero(String ficheroDestino, Agenda agenda) {
		BufferedWriter buffer = null;
		try {
			buffer =
					new BufferedWriter (
							new FileWriter(ficheroDestino));
			List<Persona> personas = agenda.getPersonas();
			for(int i = 0;i<personas.size();i++) {
				Persona p = personas.get(i);
				//serializamos el objeto
				String linea = serialice(p);
				buffer.write(linea);
				
			}
			
		} catch (IOException e) {
			System.out.println("Error en la escritura del fichero");
			return false;
		}finally {
			try {
				buffer.close();
			} catch (IOException e) {
				System.out.println("ERROR al cerrar el fichero");
				return false;
			}
			
		}
		return true;
	}
	
	public static String serialice(Persona p) {
		return p.getNombre() + ";" + p.getApe1() + ";" + p.getApe2() + ";" + p.getTel() + "\n";
	}
	
	public Persona serialice(String cadena) {
		String [] trozos = cadena.split(";");
		Persona p = new Persona(trozos[0],trozos[1],trozos[2],trozos[3]);
		return null;
		
		
	}
}
