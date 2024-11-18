package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import excepciones.ExcepcionLogica;
import excepciones.PersistenciaException;
import logica.Taller;
import modelo.Mecanico;
import modelo.Reparacion;
import modelo.Vehiculo;

public class GestorPersistencia {

	private Taller taller;
	private Loggerfichero log;
	
	public GestorPersistencia(Taller taller) {
		this.log = Loggerfichero.getInstance();
		this.taller = taller;
	}

	public void cargarDatos(String ficheroDatos) throws FileNotFoundException {
		
		BufferedReader reader = null;
		int contLineas = 0;
		try {
			reader = new BufferedReader(new FileReader(ficheroDatos));
			String linea = "";
			while(reader.ready()) {
				try {
				linea = reader.readLine();
				categorizarLinea(linea);
				contLineas++;
				}catch (PersistenciaException e) {
					log.writeSmg("Linea : " + contLineas + " "+ e.getMessage());
				} catch (ExcepcionLogica e) {
					log.writeSmg("Linea : " + contLineas + " "+ e.getMessage());
				} 
			}
		}catch (IOException e) {
			log.writeSmg("Linea : " + contLineas + " "+ e.getMessage());
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("ERROR al cerrar el lector");
			}
		}
		
	}

	private void categorizarLinea(String linea) throws PersistenciaException, ExcepcionLogica {
		String trozos[] = linea.split("@");
		
		if(linea.length() == 0) {
			throw new PersistenciaException("ERROR linea vacia");
		}
		
		if(trozos[0].length() != 1 || !Character.isDigit(trozos[0].charAt(0))) {
			throw new PersistenciaException("ERROR cabeza de linea mal formada");
		}
		
		switch (trozos[0]) {
        case "1":
            Vehiculo v = Vehiculo.serializeVehiculo(linea);
            taller.addVehiculo(v);
            break;
        case "2":
        	Mecanico m = Mecanico.serializeMecanico(linea);
        	taller.addMecanico(m);
            break;
        case "3":
        	Reparacion r = Reparacion.serializeReparacion(linea);
        	taller.addReparacion(r);
            break;
        default:
            throw new PersistenciaException("Error numero de categoria no contemplado");
    }
		
	}

	public void guardarDatos(String ficheroSalida) {
		
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(ficheroSalida));
			
			for(Vehiculo v: taller.getVehiculos()) {
				writer.write(Vehiculo.serializeVehiculo(v));
			}
			for(Mecanico m: taller.getMecanicos()) {
				writer.write(Mecanico.serializeMecanico(m));
			}
			for(Reparacion r: taller.getReparaciones()) {
				writer.write(Reparacion.serializeReparacion(r));
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR al crear el archivo de salida");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				log.closeLog();
				writer.close();
			} catch (IOException e) {
				System.out.println("ERROR al cerrar el archivo");
			}
		}
		
	}



}
