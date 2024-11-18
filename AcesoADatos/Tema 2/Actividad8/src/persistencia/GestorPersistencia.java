package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import excepciones.LogicaException;
import excepciones.PersistenciaException;
import logica.GestorAeropuerto;
import modelo.Compañia;
import modelo.Pasajero;
import modelo.Vuelo;

public class GestorPersistencia {
	
	private GestorAeropuerto ga;
	private Loggerfichero log;

	public GestorPersistencia(GestorAeropuerto gestorAeropuerto) {
		this.ga = gestorAeropuerto;
		this.log = Loggerfichero.getInstance();
	}

	public void cargarDatos(String fichero) throws IOException {
		
		BufferedReader reader= null;
		
		reader = new BufferedReader(new FileReader(fichero));
		String linea = "";
		int contLineas = 0;
		while(reader.ready()) {
			contLineas++;
			linea = reader.readLine();
			try {
				categorizarLinea(linea);
			} catch (PersistenciaException e) {
				log.writeSmg("Linea " + contLineas +" "+ e.getMessage());
			} catch (LogicaException e) {
				log.writeSmg("Linea " + contLineas +" "+ e.getMessage());
			}
		}
		
		try {
			reader.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar el lector");
		}
		
	}

	private void categorizarLinea(String linea) throws PersistenciaException, LogicaException {
		String trozos[] = linea.split("\t");
		if(trozos.length == 1) {
			throw new PersistenciaException("Error linea vacia");
		}else if(trozos[0].length() != 1 || !Character.isDigit(trozos[0].charAt(0))) {
			throw new PersistenciaException("Error cabecera mal formada");
		}
		
		int numero = Integer.parseInt(trozos[0]);
		
		switch (numero) {
		case 1:
			Compañia c = Compañia.serializeCompañia(trozos);
			ga.addCompañia(c);
			break;
		case 2:
			Vuelo v = Vuelo.serializeVuelo(trozos);
			ga.addVuelo(v);
			break;
		case 3:
			Pasajero p = Pasajero.serializePasajero(trozos);
			ga.addPasajero(p);
			break;
		default:
			throw new PersistenciaException("Error el numero de categoria debe "
					+ "estar entre el 1 y el 3");
		}
	}


	public void guardarDatos(String fichero) {
		
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(fichero));
			for(Compañia c: ga.getCompañias()) {
				writer.write(c.serializeCompañia()  + "\n");
			}
			for(Compañia c: ga.getCompañias()) {
				for(Vuelo v: c.getVuelos()) {
					writer.write(v.serializeVuelo()  + "\n");
				}
			}
			for(Compañia c: ga.getCompañias()) {
				for(Vuelo v: c.getVuelos()) {
					for(Pasajero p: v.getPasajeros()) {
						writer.write(p.serializePasajero() + "\n");
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error al abrir el escritor");
		}finally{
			try {
				writer.close();
				log.closeLog();
			} catch (IOException e) {
				System.out.println("Error al cerrar el escritor");
			}
		}
		
		
		
	}

}
