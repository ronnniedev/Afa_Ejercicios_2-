package Persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Excepciones.LogicaException;
import Excepciones.PersistenciaException;
import Logica.CentralReservas;
import Modelo.Habitacion;
import Modelo.Hotel;
import Modelo.Reserva;
import Modelo.Zonas;

public class GestorTXT {

	public void cargarDatos(CentralReservas central, String fichero) 
			throws IOException {
		
		
		BufferedReader reader = null;
		
		reader = new BufferedReader(new FileReader(fichero));
		int contLineas = 1;
		while(reader.ready()) {
			String linea = reader.readLine();
			contLineas++;
			char tipo = linea.charAt(0);
			try {
			if(tipo== '1' ) {
				tratarZona(linea,central);
			}
			if(tipo== '2' ) {
				tratarHotel(linea,central);
			}
			if(tipo== '3' ) {
				tratarHabitacion(linea,central);
			}
			if(tipo== '4' ) {
				tratarReserva(linea,central);
			}
			
			if(tipo < '1' || tipo > '4') {
				throw new PersistenciaException("Linea : " + contLineas + " ERROR de tipo");
			}
				}catch(PersistenciaException | LogicaException e) {
					System.out.println(contLineas + " : " + e.getMessage());
				}
			
			
			
		}
	
	}

	private void tratarReserva(String linea, CentralReservas central) 
			throws PersistenciaException, LogicaException {
		String trozos[] = linea.split("\t");
		if(trozos.length != 5) {
			throw new PersistenciaException("ERROR reg Reserva mal formado");
		}
		
		try {
			int codReserva= Integer.parseInt(trozos[1]);
			
			if(central.buscarReserva(codReserva) != null) {
				throw new LogicaException("ERROR codigo reserva duplicado");
			}
			int codHabitacion = Integer.parseInt(trozos[2]);
			if(central.buscaHabitacion(codHabitacion) == null) {
				throw new LogicaException("ERROR codigo habitacion no existente");
			}
			
			String dni = trozos[3];
			String fecha = trozos[4];
			Reserva r = new Reserva(codReserva,codHabitacion,dni,fecha);
			central.addReserva(r);
		}catch(NumberFormatException e) {
			throw new PersistenciaException("ERROR reg zona cod invalido");
		}
		
	}

	private void tratarHabitacion(String linea, CentralReservas central) 
			throws PersistenciaException, LogicaException {
		String trozos[] = linea.split("\t");
		if(trozos.length != 6) {
			throw new PersistenciaException("ERROR reg habitacion mal formado");
		}
		
		try {
			int codHabitacion= Integer.parseInt(trozos[1]);
			
			if(central.buscaHabitacion(codHabitacion) != null) {
				throw new LogicaException("ERROR codigo habitacion duplicado");
			}
			int codHotel = Integer.parseInt(trozos[2]);
			if(central.buscarHotel(codHotel) == null) {
				throw new LogicaException("ERROR codigo hotel no existente");
			}
			
			int planta = Integer.parseInt(trozos[3]);
			int ocupacionMax = Integer.parseInt(trozos[4]);
			double precio = Double.parseDouble(trozos[5]);
			
			Habitacion h = new Habitacion(codHabitacion,codHotel,planta,ocupacionMax,precio);
			central.addHabitacion(h);
		}catch(NumberFormatException e) {
			throw new PersistenciaException("ERROR reg zona cod invalido");
		}
		
	}

	private void tratarHotel(String linea, CentralReservas central) 
			throws PersistenciaException, LogicaException {
		String trozos[] = linea.split("\t");
		if(trozos.length != 6) {
			throw new PersistenciaException("ERROR reg hotel mal formado");
		}
		
		try {
			int codHotel = Integer.parseInt(trozos[1]);
			
			if(central.buscarHotel(codHotel) != null) {
				throw new LogicaException("ERROR hotel duplicado");
			}
			int codZona = Integer.parseInt(trozos[2]);
			if(central.buscarZona(codZona) == null) {
				throw new LogicaException("ERROR cod zona no existe");
			}
			
			String nombre = trozos[3];
			char tipo = trozos[4].charAt(0);
			int estrellas = Integer.parseInt(trozos[5]);
			if(estrellas < 1 || estrellas > 5) {
				throw new LogicaException("ERROR reg hotel estrellas inv");
			}
			Hotel h = new Hotel(codHotel,codZona,nombre,tipo,estrellas);
			central.addHotel(h);
		}catch(NumberFormatException e) {
			throw new PersistenciaException("ERROR reg zona cod invalido");
		}
		
	}

	private void tratarZona(String linea, CentralReservas central) 
			throws PersistenciaException, LogicaException {
		String trozos[] = linea.split("\t");
		if(trozos.length != 4) {
			throw new PersistenciaException("ERROR reg zona mal formado");
		}
		
		try {
			int codReserva = Integer.parseInt(trozos[1]);
			
			if(central.buscarZona(codReserva) != null) {
				throw new LogicaException("ERROR codigo zona duplicada");
			}
			String nombre = trozos[2];
			String descripcion = trozos[3];
			Zonas z = new Zonas(codReserva,nombre,descripcion);
			central.addZonas(z);
		}catch(NumberFormatException e) {
			throw new PersistenciaException("ERROR reg zona cod invalido");
		}
		
	}

}
