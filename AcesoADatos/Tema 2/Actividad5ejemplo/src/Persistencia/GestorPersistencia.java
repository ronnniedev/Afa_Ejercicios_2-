package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Excepciones.LogicaExcepcion;
import Excepciones.PersistenciaException;
import Logica.Sistema;
import Modelo.Cliente;
import Modelo.Video;

public class GestorPersistencia {
	
	private Sistema sistema;
	private BufferedWriter log;

	public GestorPersistencia(Sistema sistema, BufferedWriter log) {
		this.sistema = sistema;
		this.log = log;
	}

	public void cargarTxt() throws IOException {
		String ficheros = "Datos\\entrada_errores.txt";
		
		BufferedReader buffer = null;
		
		try {
			buffer = new BufferedReader(new FileReader(ficheros));
			int contLineas = 0;
			while(buffer.ready()) {
				String linea = buffer.readLine();
				contLineas++;
				try {
				tratarLinea(linea);
				}catch (Exception e) {
					log.write(contLineas + " : " + e.getMessage() + "\n");
				}
			}
		} catch (FileNotFoundException e) {
			log.write("Fichero no encontrado \n");
		} catch (IOException e) {
			log.write("ERROR entrada salida \n");
		}finally{
			try {
				buffer.close();
			} catch (IOException e) {
				log.write("ERROR al cerrar \n");
			}
		}
		
	}

	private void tratarLinea(String linea) throws PersistenciaException, LogicaExcepcion {
		String trozos[] = linea.split("@");
		if(trozos[0].compareTo("1")==0) {
			Cliente c = new Cliente();
			c = (Cliente) c.serialize(linea);
			
			if(sistema.buscarCliente(c.getDNI())!= null) {
				throw new LogicaExcepcion("ERROR dni publicado");
			}
			
			
			sistema.añadirCliente(c);
			
		}else if(trozos[0].compareTo("2")==0) {
			Video v = new Video();
			v = (Video) v.serialize(linea);
			
			if(sistema.buscarVideo(v.getCodigo())!=null) {
				throw new LogicaExcepcion("ERROR cod video duplicado");
				
			}
			sistema.addVideo(v);
		}else if(trozos[0].compareTo("3")==0) {
			
			if(trozos.length !=3) {
				throw new PersistenciaException("ERROR registro alquiler incorrecto");
			}
			
			try {
				String dni = trozos[1];
				int codigo = Integer.parseInt(trozos[2]);
				Video v = sistema.buscarVideo(codigo);
				if(sistema.buscarVideo(codigo)==null) {
					throw new PersistenciaException("ERROR codigo video duplicado");
				}
				if(v == null) {
					throw new PersistenciaException("ERROR video no "
													+ "encontrado para hacer alquiler");
				}
				Cliente c = sistema.buscarCliente(dni);
				if(c == null) {
					throw new PersistenciaException("ERROR cliente no "
													+ "encontrado para hacer alquiler");
				}
				c.addAlquiler(v);
			}catch(Exception e) {
				throw new PersistenciaException("Error codigo mal formado");
			}
			
		}else {
			throw new PersistenciaException("ERROR registro no identificado");
		}
		
	}

	public void grabarTxt() throws IOException {
		String fichero = "Datos\\salida.txt";
		
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(fichero));
			for(Cliente c: sistema.getClientes()) {
				String linea = c.serialize(c);
				writer.write(linea);
			}
			
			for(Video v: sistema.getVideos()) {
				String linea = v.serialize(v);
				writer.write(linea);
			}
			for(Cliente c: sistema.getClientes()) {
				for(Video v: c.getVideos()) {
					writer.write("3@" + c.getDNI() + "@" + v.getCodigo() + "\n");
				}
			}
		} catch (IOException e) {
			log.write("ERROR I/O en fichero salida\n");
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				log.write("ERROR en el cierre de fichero\n");
			}
		}
		
	}


}
