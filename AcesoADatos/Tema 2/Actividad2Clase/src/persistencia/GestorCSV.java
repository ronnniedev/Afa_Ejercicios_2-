package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import logica.Conjunto;
import logica.Restaurante;

public class GestorCSV {
	
	public GestorCSV() {
		
	}
	
	public String ejercicio1(String ruta, String ficheroOrigen) {
		File rutaFile = new File(ruta);
		if(!rutaFile.exists()) {
			return "ERROR La ruta no existe";
		}
		
		if(!rutaFile.isDirectory()) {
			return "ERROR la ruta no es un directorio";
		}
		
		File fichero = new File(ruta,ficheroOrigen);
		
		if(!fichero.exists()) {
			return "ERROR el fichero no existe";
		}
		
		if(!fichero.isFile()) {
			return "ERROR el ficheroOrigen no es fichero";
		}
		
		String texto = "lectura de fichero\n";
		BufferedReader buffer = null;
		
		try {
			buffer = new BufferedReader(new FileReader(fichero));
			
			int cont = 0;
			String linea = "";
			
			while((linea=buffer.readLine())!=null) {
				cont++;
				texto+="["+cont+"]\t"+linea+"\n";
			}
			
			texto+="Numero total de lineas: "+cont+"\n";
		} catch (IOException e) {
			System.out.println("Error fichero no encontrado");
		}finally {
			try {
				buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return texto;
	}

	public void cargarDatos(String ruta, String ficheroOrigen, Conjunto conjunto) {
	
		BufferedReader reader = null;
		String linea = "";
		int contlineas = 0;
		
		try {
			reader = new BufferedReader(new FileReader(new File(ruta,ficheroOrigen)));
			linea = reader.readLine();
			while((linea=reader.readLine())!=null) {
				contlineas++;
				String trozos[] = linea.split(",");
				if(trozos.length == 5) {
					Restaurante r = new Restaurante(trozos[0],trozos[1],
													trozos[2],trozos[3],trozos[4]);
					conjunto.addRestaurante(r);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la entrada salida");
		}
		
		
	}
	
	public void guardarDatos(String ruta,String ficheroDestino, Conjunto conjunto) {
		BufferedWriter buffer = null;
		
		try {
			buffer = new BufferedWriter(new FileWriter(new File (ruta,ficheroDestino)));
			Set<Restaurante> set = conjunto.getConjunto();
			String cabecera = "nombre;direccion;ciudad;provincia;cp\n";
			buffer.write(cabecera);
			for(Restaurante r:set) {
				String linea = r.getNombre() + ";"+ r.getDireccion() +";" + r.getCiudad() + ";" 
			+ r.getProvincia() + ";" + r.getCp() + "\n";
				buffer.write(linea);
			}
		} catch (IOException e) {
			System.out.println("Error en la escritura del fichero");
		}finally {
			try {
				buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al cerrar el fichero");
			}
		}
		
		
	}
	
	
}
