package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import principal.Coche;
import principal.FormatException;

public class Persistencia {

	public static void leerCoches(String nombreFichero,List<principal.Coche> listaCoches) {
		BufferedReader reader = null;
				
		
				try {
					reader = new BufferedReader(new FileReader(nombreFichero));
					String linea = reader.readLine();
					while((linea = reader.readLine()) != null) {
						 Coche c = new Coche(linea);
						 listaCoches.add(c);
					}
				} catch (FileNotFoundException e) {
					System.out.println("Error al leer el archivo");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
	}
	
	public static void escribirCoches(String nombreFichero,List<principal.Coche> listaCoches) {
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter (new FileWriter(nombreFichero));
			String contenido = "ID;MARCA;MODELO\n";
			
			for(Coche c : listaCoches) {
				contenido = contenido + c.serialize();
			}
			
			writer.write(contenido);
			System.out.println(contenido);
				
			}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
