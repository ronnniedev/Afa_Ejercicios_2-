package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Excepciones.Loggerfichero;
import Excepciones.LogicaException;
import Excepciones.PersistenciaException;
import logica.CentralReservas;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Reserva;
import modelo.Zonas;

public class GestorTXT {

	public void cargarDatos(CentralReservas central, String fichero) 
														throws IOException{
		BufferedReader buffer = null;
		
		buffer = new BufferedReader(new FileReader(fichero));
		int contLineas = 1;
		while(buffer.ready()) {
			String linea = buffer.readLine();
			contLineas ++;
			try {
				char tipo = linea.charAt(0);
				if (tipo == '1') tratarZona(linea, central);
				if (tipo == '2') tratarHotel(linea, central);
				if(tipo == '3') tratarHabitacion(linea, central);
				if(tipo == '4') tratarReserva(linea, central);
				
				if(tipo < '1' || tipo > '4') {
					throw new PersistenciaException("ERROR de tipo");
				}
			}catch (Exception e) {
				Loggerfichero.getInstance().writeSmg("Linea " + contLineas + ": " + e.getMessage());
			}
			
		}
		
	}

	private void tratarReserva(String linea, CentralReservas central) 
			throws PersistenciaException, LogicaException {
		String [] trozos = linea.split("\t");
		if (trozos.length != 5) {
			throw new PersistenciaException("ERROR. Registro reserva mal formado");
		}
		try {
			int codReserva = Integer.parseInt(trozos[1]);
			if (central.buscarReserva(codReserva) != null) {
				throw new LogicaException("ERROR. Codigo reserva duplicado");
			}
			int codHabitacion = Integer.parseInt(trozos[2]);
			if (central.buscarHabitacion(codHabitacion) == null) {
				throw new LogicaException("ERROR. Codigo habitacion no existe");
			}
			String dni = trozos[3];
			String fecha = trozos[4];
			
			Reserva r = new Reserva(codReserva, codHabitacion, dni, fecha);
			central.addReserva(r);
			
		}catch (NumberFormatException e) {
			throw new PersistenciaException("ERROR. Registro zona. Codigo invalido.");
		}
		
	}

	private void tratarHabitacion(String linea, CentralReservas central) 
													throws PersistenciaException, LogicaException {
		String [] trozos = linea.split("\t");
		if (trozos.length != 6) {
			throw new PersistenciaException("ERROR. Registro habitacion mal formado");
		}
		try {
			int codHabitacion = Integer.parseInt(trozos[1]);
			if (central.buscarHabitacion(codHabitacion) != null) {
				throw new LogicaException("ERROR. Codigo habitacion duplicado");
			}
			int codHotel = Integer.parseInt(trozos[2]);
			if (central.buscarHotel(codHotel) == null) {
				throw new LogicaException("ERROR. Codigo hotel no existe");
			}
			int planta = Integer.parseInt(trozos[3]);
			int ocupacioMax = Integer.parseInt(trozos[4]);
			double precio = Double.parseDouble(trozos[5]);
			
			Habitacion h = new Habitacion(codHabitacion, codHotel, planta, ocupacioMax, precio);
			central.addHabitacion(h);
			
		}catch (NumberFormatException e) {
			throw new PersistenciaException("ERROR. Registro zona. Codigo invalido.");
		}
		
	}

	private void tratarHotel(String linea, CentralReservas central) 
													throws PersistenciaException, LogicaException {
		String [] trozos = linea.split("\t");
		if (trozos.length != 6) {
			throw new PersistenciaException("ERROR. Registro hotel mal formado");
		}
		try {
			int codHotel = Integer.parseInt(trozos[1]);
			if (central.buscarHotel(codHotel) != null) {
				throw new LogicaException("ERROR. Codigo zona duplicado");
			}
			int codZona = Integer.parseInt(trozos[2]);
			if (central.buscarZona(codZona) == null) {
				throw new LogicaException("ERROR. Codigo zona no existe");
			}
			String nombre = trozos[3];
			char tipo = trozos[4].charAt(0);
			int estrellas = Integer.parseInt(trozos[5]);
			if (estrellas <1 || estrellas > 5) {
				throw new PersistenciaException("ERROR. Registro hotel. Valor estrellas incorrecto");
			}
			central.addHoteles(new Hotel(codHotel, codZona, nombre, tipo, estrellas));	
		}catch (NumberFormatException e) {
			throw new PersistenciaException("ERROR. Registro zona. Codigo invalido.");
		}
		
	}

	private void tratarZona(String linea, CentralReservas central) 
					throws PersistenciaException, LogicaException {
		String [] trozos = linea.split("\t");
		if (trozos.length != 4) {
			throw new PersistenciaException("ERROR. Registro zona mal formado");
		}
		try {
			int codZona = Integer.parseInt(trozos[1]);
			if (central.buscarZona(codZona) != null) {
				throw new LogicaException("ERROR. Codigo zona duplicado");
			}
			String nombre = trozos[2];
			String descripcion = trozos[3];
			
			Zonas z = new Zonas(codZona, nombre, descripcion);
			central.addZonas(z);
			
		}catch (NumberFormatException e) {
			throw new PersistenciaException("ERROR. Registro zona. Codigo invalido.");
		}	
	}

}
