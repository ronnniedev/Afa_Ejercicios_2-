package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import excepciones.ExcepcionExamen;
import excepciones.PersistenciaException;
import modelo.Cliente;
import modelo.LogicaException;
import modelo.Pelicula;
import modelo.Sistema;

public class GestorPersistencia {
	
	private Sistema sistema;
	private BufferedWriter log;

	public GestorPersistencia(Sistema sistema, BufferedWriter log) {
		this.sistema = sistema;
		this.log = log;
	}

	public void cargarTxt() {
		File entrada = new File("src\\datos\\Ficheros Act5\\archivoResultante.txt");
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(entrada));
			while(reader.ready()) {
				String linea = reader.readLine();
				analizarCategoria(linea);
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR al encontrar el reader");
		} catch (IOException e) {
			System.out.println("ERROR en la lectura");
		}
		
		
	}
	
	public void analizarCategoria(String linea){
		
		String trozos[] = linea.split("@");
		
		try {
			System.out.println(trozos.length);
			if(trozos.length == 1) {
				throw new PersistenciaException("Linea vacia");
			}
			
			if(trozos[0].length() != 1) {
				throw new PersistenciaException("Categoria mal formada");
			}
			if(linea.startsWith("1")) {
				Cliente c;
				c = Cliente.serialize(linea);
				sistema.añadirCliente(c);
				return;
			}else if(linea.startsWith("2")) {
				Pelicula p = Pelicula.serialize(linea);
				sistema.añadirPelicula(p);
				return;
			}else if(linea.startsWith("3")) {
				sistema.añadirAlquiler(linea);
				return;
			}
			throw new PersistenciaException("Caracter desconocido al inicio");
		}catch (PersistenciaException | LogicaException e) {
			try {
				log.write(e.getMessage() + ": " + linea + "\n");
			} catch (IOException e1) {
				System.out.println("Error al escribir");
			}
		} catch (ExcepcionExamen e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NumberFormatException e) {
			try {
				log.write(e.getMessage() + ": " + linea + "\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}

	public void grabarTxt() {
		List <Cliente> clientes= sistema.getClientes();
		List <Pelicula> peliculas = sistema.getPeliculas();
		File f = new File("src\\datos\\Ficheros Act5\\archivoResultante.txt");
		
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(f));
			String linea= "";
			for(Cliente c:clientes) {
				linea = Cliente.serialize(c);
				writer.write(linea);
			}
			
			for(Pelicula p: peliculas) {
				linea = Pelicula.serialize(p);
				writer.write(linea);
			}
			
			for(Cliente c:clientes) {
				List  <Pelicula> peliculasAlquiladas = c.getPeliculasAlquiladas();
				for(Pelicula p: peliculasAlquiladas) {
					writer.write("3@" + c.getDni() + "@" + p.getCodigo() + "\n");
				}
			}
			
		} catch (IOException e) {
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

	public void grabarCryptor() {
		
		
	}


}
