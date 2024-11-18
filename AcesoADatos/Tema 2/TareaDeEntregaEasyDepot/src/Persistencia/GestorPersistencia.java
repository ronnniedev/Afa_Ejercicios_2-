package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
import Persistencia.Loggerfichero;

public class GestorPersistencia {
	
	private Sistema sistema;
	
	
	/**
	 * Constructor de un parametro de la clase GgestorPersitencia
	 * @param sistema : Sistema
	 */
	public GestorPersistencia(Sistema sistema) {
		this.sistema = sistema;
		
	}
	
	/**
	 * Constructor de GestorPersistencia para realizar testeos
	 */
	public GestorPersistencia() {
	}



	/**
	 * /**
	 * Carga los datos alojados dentro del archivo csv, en caso de error escribe el error en el log
	 * singleton y ignora la linea
	 * @return boolean
	 * @throws IOException
	 */
	public boolean cargarDatos(String fichero) throws IOException {
		BufferedReader reader = null;
		int contLineas = 1;
		try {
			reader = new BufferedReader(new FileReader("Datos\\" + fichero));
			String linea = "";
			while(reader.ready()) {
				linea = reader.readLine();
				try {
					categorizarLinea(contLineas ,linea);
				} catch (PersistenciaException | LogicaException e) {
					escribirError( " Linea " + contLineas + " : " + e.getMessage());
				}
				contLineas++;
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Archivo no encontrado , abortando apertura de programa");
		} catch (IOException e) {
			throw new IOException("Error en la lectura");
		} finally{
			try {
				if(reader!= null) {
					reader.close();
				}
			} catch (IOException e) {
				System.out.println("ERROR al cerrar el archivo");
			}
		}
		
		return true;
	}

	/**
	 * Diversifica el comportamiento del procesador dependienco de la linea proporcionada, lee el 
	 * inicio de la linea y en funcion de ello serializa los datos de una manera concreta, en caso
	 * de estar mal escrito, tener datos corruptos,etc. Arroja un error de persistencia o logica
	 * @param numLinea : int
	 * @param linea : String
	 * @throws PersistenciaException
	 * @throws LogicaException
	 */
	public boolean categorizarLinea(int numLinea,String linea) 
			throws PersistenciaException, LogicaException {
		String trozos[] = linea.split(";");
		
		if(linea.compareTo("--Clientes--") == 0 || 
		linea.compareTo("categoria;nombre;apellidos;numero;"
				+ "email;contraseña;numeroReservas;puntosTienda") == 0 ||
		linea.compareTo("--Consignas--") == 0 ||
		linea.compareTo("categoria;id;direccion") == 0 ||
		linea.compareTo("--Reservas--") == 0 ||
		linea.compareTo("categoria;emailCliente;id;fechaInicio;fechaFinal"
				+ ";ReservaFinalizada;Incidencia;DescripcionIncidencia") == 0) {
			return true;
		}
		
		if(trozos[0].length() != 1 || !Character.isDigit(trozos[0].charAt(0))) {
			throw new PersistenciaException("Error categoria mal hecha, "
					+ "debe ser un digito y un solo caracter");
		}

        switch (trozos[0]) {
            case "1":
                Cliente c = Cliente.serializeCliente(linea);
                sistema.addCliente(c);
                break;
            case "2":
            	Consigna con = Consigna.serializeConsigna(linea);
                sistema.addConsigna(con);
                break;
            case "3":
            	Reserva r = Reserva.serializeReserva(linea);
            	sistema.addReserva(r);
                break;
            default:
                throw new PersistenciaException("Error numero de categoria no contemplado");
        }
		
		return true;
	}

	/**
	 * Guarda los datos escribiendo en el documento proporcionado, arroja error en caso de algun 
	 * problema en el cierre
	 * @throws IOException
	 */
	public void guardarDatos(String fichero) throws IOException {
		
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter("Datos\\" + fichero));
			writer.write("--Clientes--\ncategoria;nombre;apellidos;numero;email"
					+ ";contraseña;numeroReservas;puntosTienda\n");
			String linea = "";
			for(Cliente c: sistema.getClientes().values()) {
				linea = Cliente.serializeCliente(c);
				writer.write(linea);
			}
			writer.write("--Consignas--\ncategoria;id;direccion\n");
			for(Consigna c: sistema.getConsignas()) {
				linea = Consigna.serializeConsigna(c);
				writer.write(linea);
			}
			writer.write("--Reservas--\ncategoria;emailCliente;id;fechaInicio;fechaFinal"
							+ ";ReservaFinalizada;Incidencia;DescripcionIncidencia\n");
			for(Reserva r: sistema.getReservas()) {
				linea = Reserva.serializeReserva(r);
				writer.write(linea);
			}
		} catch (IOException e) {
			throw new IOException("Error al crear el archivo de salida");
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println("ERROR al cerrar el archivo");
			}
		}
		
		Loggerfichero.getInstance().closeLog(); // cerramos el log
		
	}
	

	/**
	 * Escribe un error en el log a traves del mensaje proporcionado
	 * @param sms : String
	 */
	private void escribirError(String sms) {
		Loggerfichero.getInstance().writeSmg(sms);
		
	}

}
