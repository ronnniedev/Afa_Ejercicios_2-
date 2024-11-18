package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import excepciones.LogicaException;
import excepciones.PersistenciaException;
import logica.CentralReservas;
import java.io.FileWriter;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Reserva;
import modelo.Zona;

public class GestorPersistencia {

	private CentralReservas central;
	private Loggerfichero log;

	public GestorPersistencia(CentralReservas central) {
		this.log = Loggerfichero.getInstance();
		this.central = central;
	}

	public void cargarDatos() {

		BufferedReader reader = null;
		int contLineas = 0;
		try {
			reader = new BufferedReader(new FileReader("Datos\\CentralReservas.txt"));
			String linea = "";

			while (reader.ready()) {
				try {
					linea = reader.readLine();
					contLineas++;
					categorizarLinea(linea);
				} catch (PersistenciaException e) {
					log.writeSmg("Linea " + contLineas+ ": "+ e.getMessage());
				} catch (LogicaException e) {
					log.writeSmg("Linea " + contLineas+ ": "+ e.getMessage());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error al encontrar el archivo");
		} catch (IOException e) {
			System.out.println(contLineas + e.getMessage());
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("ERROR al cerrar el lector");
			}
		}

	}

	private void categorizarLinea(String linea) throws PersistenciaException, LogicaException {
		String trozos[] = linea.split("\t");

		if (trozos[0].length() < 1 || !Character.isDigit(trozos[0].charAt(0))) {
			throw new PersistenciaException("Error linea mal categorizada");
		}

		int categoria = Integer.parseInt(trozos[0]);

		switch (categoria) {
		case 1:
			Zona z = Zona.serialize(linea);
			central.addZona(z);
			break;
		case 2:
			Hotel h = Hotel.serialize(linea);
			central.addHotel(h);
			break;
		case 3:
			Habitacion hab = Habitacion.serialize(linea);
			central.addHabitacion(hab);
			break;
		case 4:
			Reserva r = Reserva.serialize(linea);
			central.addReserva(r);
			break;
		default:
			throw new PersistenciaException("Error el numero de categoria debe " + "estar entre el 1 y el 4");
		}
	}

	public void guardarDatos() {
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter("Datos\\salida.txt"));
			for(Zona z: central.getZonas()) {
				writer.write(Zona.serialize(z));
			}
			
			for(Hotel h: central.getHoteles()) {
				writer.write(Hotel.serialize(h));
			}
			
			for(Habitacion hab: central.getHabitaciones()) {
				writer.write(Habitacion.serialize(hab));
			}
			
			for(Reserva r: central.getReservas()) {
				writer.write(Reserva.serialize(r));
			}
		} catch (IOException e) {
			System.out.println("ERROR al abrir el escritor");
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println("ERROR al cerrar el escritor");
			}
		}
		
		log.closeLog();
		
	}

}
