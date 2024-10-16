package LogicaNegocio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import clases.Empleado;
import clases.Inmueble;
import persistencia.Persistencia;

public class Inmobiliaria {
	
	private List <Inmueble> listaInmuebles;
	private List <Empleado> listaEmpleados;

	
	public Inmobiliaria(String ficheroEmpleados, String ficheroInmuebles) {
		
		this.listaInmuebles = new LinkedList <Inmueble>();
		this.listaEmpleados = new ArrayList<Empleado>();
		
		Persistencia.LeerEmpleado(ficheroEmpleados, listaEmpleados);
		Persistencia.leerInmuebles(ficheroInmuebles, listaInmuebles, listaEmpleados);
		
	}


	public String listarDatos() {
		String contenido = "----------ListaEmpleados------------\n";
		for(Empleado e: listaEmpleados) {
			contenido = contenido + e.toString() + "\n";
		}
		contenido = contenido + "------------ListaInmuebles-----------\n";
		for(Inmueble i : listaInmuebles) {
			contenido = contenido + i.toString() + "\n";
		}
		return contenido;
	}


	public String listadoInmuebles() {
		String contenido ="------------ListaInmuebles-----------\n";
		for(Inmueble i : listaInmuebles) {
			contenido = contenido + i.toString() + "\n";
		}
		return contenido;
	}


	public void insertarInmueble(String linea) {
		Inmueble i = new Inmueble(linea);
		boolean correcto = true;
		for(Inmueble in: listaInmuebles) {
			if(i.getCodInmueble().compareTo(in.getCodInmueble())==0) {
				correcto = false;
			}
		}
		
		if(correcto && encontrarEmpleado(i)) {
			listaInmuebles.add(i); 
		}
		
	}
	
	public boolean encontrarEmpleado(Inmueble i) {
		
		for(Empleado e: listaEmpleados) {
			if(e.getCodEmpleado().compareTo(i.getCodEmpleado()) == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean encontrarEmpleado(Empleado en) {
		
		for(Empleado e: listaEmpleados) {
			if(e.getCodEmpleado().compareTo(en.getCodEmpleado()) == 0) {
				return true;
			}
		}
		
		return false;
	}


	public void insertarEmpleado(String linea) {
		Empleado e = new Empleado(linea);
		boolean correcto = true;
	
		if(encontrarEmpleado(e)) {
			listaEmpleados.add(e);
		}
		
		
	}


	public boolean borrarEmpleado(String codInmueble) {
		for(Inmueble i : listaInmuebles) {
			if(i.getCodInmueble().compareTo(codInmueble) == 0) {
				return listaInmuebles.remove(i);
			}
		}
		return false;
	}


	public int guardarDatos(String nombreFicheroEmpelados, String nombreFicheroinmuebles) {
		Persistencia.escribirEmpleado(nombreFicheroEmpelados, listaEmpleados);
		Persistencia.escribirInmueble(nombreFicheroinmuebles, listaInmuebles);
		return listaEmpleados.size()+listaInmuebles.size();
	}
	
	


}
