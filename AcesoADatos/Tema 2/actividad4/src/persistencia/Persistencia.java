package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import clases.Empleado;
import clases.Inmueble;
import excepciones.CodNotFoundException;

public class Persistencia {

	public static void LeerEmpleado(String nombreFichero,List<Empleado>listaEmpleados) {
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(nombreFichero));
			String linea = "";
			reader.readLine();
			while((linea = reader.readLine()) != null) {
				 Empleado e = new Empleado(linea);
				 System.out.println(e.getCodEmpleado());
				 listaEmpleados.add(e);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el archivo");;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el archivo");
			}
		}
	}
	
	public static void escribirEmpleado(String nombreFichero,List<Empleado>listaEmpleados) {
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(nombreFichero));
			String linea = "codEmpleado;nombre;telefono\n";
			for(Empleado e: listaEmpleados) {
				linea = linea + e.serielize() + "\n";
			}
			writer.write(linea);
		} catch (IOException e) {
			System.out.println("Error al procesar el archivo");
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar los buffers");
			}
			
		}
	}
	
	public static void leerInmuebles(String nombreFichero,List<Inmueble>listaInmuebles
										,List<Empleado>listaEmpleados) {
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(nombreFichero));
			reader.readLine();
			String linea = "";
			while((linea = reader.readLine()) != null) {
				 Inmueble i = new Inmueble(linea);
				 try {
					if(buscarEmpleado(i,listaEmpleados)) {
						 listaInmuebles.add(i);
					 }
				} catch (CodNotFoundException e) {
					System.out.println(e.getMessage());
				}
				 
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
			}
		}
		
	}
	
	public static void escribirInmueble(String nombreFichero,List<Inmueble>listaInmuebles) {
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(nombreFichero));
			writer.write("codInmueble;direccion;tipo;codEmpleado;precio\n");
			for(Inmueble i: listaInmuebles) {
				writer.write(i.serielize() + "\n");
			}
		} catch (IOException e) {
			System.out.println("Error fichero no encontrado");
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public static boolean buscarEmpleado(Inmueble i,List<Empleado>listaEmpleados) 
			throws CodNotFoundException {
		
		for(Empleado e: listaEmpleados) {
			if(i.getCodEmpleado().compareTo(e.getCodEmpleado())==0) {
				return true;
			}
		}
		
		throw new CodNotFoundException("No se encuentra el codigo");
		
	}
}
