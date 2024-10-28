package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import Excepciones.LogicaException;
import Excepciones.PersistenciaException;
import Logica.Sistema;
import Modelo.Cliente;
import Modelo.Consigna;
import Modelo.Email;
import Modelo.Reserva;

public class GestorPersistencia {
	
	private Sistema sistema;
	private BufferedWriter log;
	
	
	public GestorPersistencia(Sistema sistema,BufferedWriter log) {
		this.sistema = sistema;
		this.log = log;
		
	}

	public void cargarDatos() {
		BufferedReader reader = null;
		int contLineas = 1;
		try {
			reader = new BufferedReader(new FileReader("Datos\\entrada.csv"));
			String linea = "";
			while(reader.ready()) {
				linea = reader.readLine();
				try {
					categorizarLinea(contLineas ,linea);
				} catch (PersistenciaException | LogicaException e) {
					escribirError(contLineas + " : " + e.getMessage());
				}
				contLineas++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			System.out.println("Error en la lectura");
		} finally{
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("ERROR al cerrar el archivo");
			}
		}
		
	}

	private void categorizarLinea(int numLinea,String linea) 
			throws PersistenciaException, LogicaException {
		String trozos[] = linea.split(";");
		if(trozos[0].length() != 1 || !Character.isDigit(trozos[0].charAt(0))) {
			throw new PersistenciaException("Error cabecera mal hecha");
		}

        switch (trozos[0]) {
            case "1":
                Cliente c = Cliente.serializeCliente(linea);
                sistema.addCliente(c);
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                throw new PersistenciaException("Error numero no contemplado");
        }
		
		
	}

	public void guardarDatos() {
		try {
			log.close();
		} catch (IOException e) {
			System.out.println("ERROR al cerrar el log");
		}
		
	}
	
	private void escribirError(String sms) {
		try {
			log.write(sms + "\n");
		} catch (IOException e) {
			System.out.println("ERROR en la escritura");
		}
	}

}
