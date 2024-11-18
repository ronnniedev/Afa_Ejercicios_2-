package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import excepciones.LogicaException;
import excepciones.PersistenciaException;
import logica.Aeropuerto;
import modelo.Compañia;
import modelo.Pasajero;
import modelo.Vuelo;

public class GestorCsv {

	public void cargar(String fichero, Aeropuerto aeropuerto) throws IOException {
		BufferedReader br = null;

		br = new BufferedReader(new FileReader(fichero));
		int conLinea = 0;

		while (br.ready()) {
			try {
				String linea = br.readLine();
				String trozos[] = linea.split("\t");
				int tipo = Integer.parseInt(trozos[0]);
				if (tipo == 1) {
					tratarCompañia(linea, aeropuerto);
				} else if (tipo == 2) {
					tratarVuelo(linea, aeropuerto);
				} else if (tipo == 3) {
					tratarPasajero(linea,aeropuerto);
				}
			} catch (PersistenciaException e) {
				//log
			} catch (LogicaException e) {
				//log
			}
		}
	}

	private void tratarPasajero(String linea, Aeropuerto aeropuerto) throws PersistenciaException {
		
		String trozos[]  = linea.split(linea);
		
		if(trozos.length != 7) {
			throw new PersistenciaException("ERROR Pasajero tiene error de info");
		}
		
		String codVuelo = trozos[1];
		String dni = trozos[2];
		String nombre = trozos[3];
		String direccion = trozos[4];
		String telefono = trozos[5];
		String clase = trozos[6];
		
		Vuelo v = aeropuerto.buscarVuelo(codVuelo);
		
		if(v == null) {
			throw new PersistenciaException("ERROR Vuelo no existe");
		}
		
		v.addPasajero(new Pasajero(codVuelo,dni,nombre,direccion,telefono,clase));
		
	}

	private void tratarVuelo(String linea, Aeropuerto ga) 
			throws PersistenciaException, LogicaException {
		String trozos[] = linea.split("\t");

		if (trozos.length != 7) {
			throw new PersistenciaException("ERROR info vuelo");
		}

		String codigo = trozos[1];
		String compañia = trozos[2];
		String destino = trozos[3];
		String horaSalida = trozos[4];
		String horaLLegada = trozos[5];
		char puerta = trozos[6].charAt(0);

		if (ga.buscarCompañia(compañia) != null) {
			throw new PersistenciaException("ERROR Compañia no existe");
		}

		Vuelo v = new Vuelo(codigo, compañia, destino, horaSalida, horaLLegada, puerta);
		ga.addVuelo(v);

	}

	private void tratarCompañia(String linea, Aeropuerto ga) throws PersistenciaException, LogicaException {
		String trozos[] = linea.split("\t");
		if (trozos.length != 3) {
			throw new PersistenciaException("Error info Compañia");
		}

		String nombre = trozos[1];
		if (ga.buscarCompañia(nombre) != null) {
			throw new PersistenciaException("ERROR compañia duplicada");
		}
		String destinos = trozos[2];
		Compañia c = new Compañia(nombre, destinos);
		ga.addCompañia(c);

	}
}
