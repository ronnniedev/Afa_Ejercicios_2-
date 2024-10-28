package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.security.auth.login.LoginException;

import logica.Inmobiliaria;
import excepciones.Loggerfichero;
import excepciones.LogicaException;
import excepciones.PersistenciaException;
import modelo.Empleado;
import modelo.Inmueble;

public class GestorCSV {
	
	public GestorCSV() {
		
	}

	public void gestorLeerEmpleados(String ficheroEmpleados, Inmobiliaria in) 
			throws PersistenciaException, FileNotFoundException {
		File file = new File(ficheroEmpleados);
		
		if(file == null) {
			throw new PersistenciaException("ERROR en el file");
		}
		
		if(!file.exists()) {
			throw new FileNotFoundException("ERROR Fichero no encontrado");
		}
		
		BufferedReader buffer = null;
		try {
		buffer = new BufferedReader(new FileReader(file));
		}catch(FileNotFoundException e) {
			System.out.println("Error en el file");
		}
		
		int contLineas = 0;
		try {
			
			buffer.readLine();
			contLineas++;
			while(buffer.ready()) {
				try {
					String linea = buffer.readLine();
					contLineas++;
					Empleado e = Empleado.serialize(linea);
					if(in.buscarEmpleado(e.getCodEmpleado()) != null) {
						throw new LogicaException("ERROR codigo duplicado");
					}else {
						in.addEmpleado(e);
					}
				}catch(Exception e) {
					System.out.println("ERROR en linea " + contLineas + " de empleados");
				}
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				buffer.close();
			} catch (IOException e) {
				System.out.println("ERROR al cerrar el archivo");
			}
		}
		
		
		
	}

	public void leerInmuebles(String ficheroInmuebles, Inmobiliaria inmobiliaria) 
			throws PersistenciaException, LogicaException {
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new FileReader(ficheroInmuebles));
			int contLineas = 1;
			buffer.readLine(); // Añadimos cabecera
			while(buffer.ready()) {
				try {
					String linea = buffer.readLine();
					contLineas++;
					Inmueble i = Inmueble.serialize(linea);
					if(inmobiliaria.buscarInmueble(i.getCodInmueble()) != null) {
						throw new LogicaException("ERROR inmueble con cod duplicado");
					}
					if(inmobiliaria.buscarEmpleado(i.getCodEmpleado()) == null) {
						throw new LogicaException("ERROR empleado no encontrado");
						
					}
					inmobiliaria.addInmueble(i);
				}catch(Exception e) {
					Loggerfichero.getInstance().writeSmg("Linea :" + contLineas);;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR fichero no encontrado");
		} catch (IOException e) {
			System.out.println("ERROR en la lectura del fichero");
		}finally {
			try {
				buffer.close();
			} catch (IOException e) {
				System.out.println("ERROR al cerrar");
			}
		}
		
	}

	public int guardarEmpleados(String ficheroEmpleados, Inmobiliaria inmobiliaria) 
			throws PersistenciaException {
		File file = new File(ficheroEmpleados);
		if(file == null) {
			throw new PersistenciaException("ERROR file null");
		}
		
		if(file.exists()) {
			System.out.println("Se vana  perder los datos");
		}
		
		BufferedWriter buffer = null;
		int contReg = 0;
		try {
			buffer = new BufferedWriter (new FileWriter(file));
			buffer.write("codEmpleado;nombre;telefono\n");
			for(Empleado e: inmobiliaria.getEmpleados()) {
				String linea = Empleado.serialize(e);
				buffer.write(linea);
				contReg++;
			}
		} catch (IOException e) {
			throw new PersistenciaException("ERROR entrada salida");
		}finally {
			try {
				buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return contReg;
	}

	public int guardarInmuebles(String ficheroInmuebles, Inmobiliaria inmobiliaria) 
			throws PersistenciaException {
		File file = new File(ficheroInmuebles);
		if(file == null) {
			throw new PersistenciaException("ERROR file null");
		}
		
		if(file.exists()) {
			System.out.println("Se vana  perder los datos");
		}
		
		BufferedWriter buffer = null;
		int contReg = 0;
		try {
			buffer = new BufferedWriter (new FileWriter(file));
			buffer.write("codInmueble;direccion;tipo;codEmpleado;precio\n");
			for(Inmueble i: inmobiliaria.getInmuebles()) {
				String linea = Inmueble.serialize(i);
				buffer.write(linea);
				contReg++;
			}
		} catch (IOException e) {
			throw new PersistenciaException("ERROR entrada salida");
		}finally {
			try {
				buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return contReg;
	}


}
