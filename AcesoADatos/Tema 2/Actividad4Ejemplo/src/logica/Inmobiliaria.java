package logica;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;

import excepciones.Loggerfichero;
import excepciones.LogicaException;
import excepciones.PersistenciaException;
import modelo.Empleado;
import modelo.Inmueble;
import persistencia.GestorCSV;

public class Inmobiliaria {
	private List <Empleado> empleados;
	private List <Inmueble> inmuebles;
	
	public Inmobiliaria() {
		this.empleados = new ArrayList<Empleado>();
		this.inmuebles = new ArrayList<Inmueble>();
	}

	public Inmobiliaria(String ficheroEmpleados, String ficheroInmuebles) 
			throws FileNotFoundException, PersistenciaException, LogicaException {
		this.empleados = new ArrayList<Empleado>();
		this.inmuebles = new ArrayList<Inmueble>();
		GestorCSV gestor = new GestorCSV();
		gestor.gestorLeerEmpleados(ficheroEmpleados,this);
		Loggerfichero.getInstance().writeSmg("lectura empleados");
		gestor.leerInmuebles(ficheroInmuebles,this);
		Loggerfichero.getInstance().writeSmg("lectura inmuebles");
	}
	
	public Empleado buscarEmpleado(String codigoEmpleado) {
		Loggerfichero.getInstance().writeSmg("buscar empleado" + codigoEmpleado);
		for(int i = 0; i<empleados.size();i++) {
			Empleado e=empleados.get(i);
			if(e.getCodEmpleado().compareTo(codigoEmpleado)==0) {
				return e;
			}
		}
		return null;
	}

	public void addEmpleado(Empleado e) {
		empleados.add(e);
		
	}

	public Inmueble buscarInmueble(String codInmueble) {
		for(int i = 0;i<inmuebles.size();i++) {
			Inmueble inm = inmuebles.get(i);
			if(inm.getCodInmueble().compareTo(codInmueble ) == 0) {
				return inm;
			}
		}
		Loggerfichero.getInstance().writeSmg("OJO!!! return null");
		return null;
	}
	
	public  void addInmueble(Inmueble i) {
		Loggerfichero.getInstance().writeSmg("Se añade un inmueble");
		inmuebles.add(i);
	}

	public String listarDatos() {
		String texto = "Empleados :" + empleados.size() + "\n";
		for(Empleado e: empleados){
			texto += "\t"+e.toString() + "\n";
		}
		texto += "\nInmuebles : " + inmuebles.size() + "\n";
		for(Inmueble i: inmuebles) {
			texto += "\t" + i.toString() + "\n";
			
		}
		return texto; 
	}

	public String listadoInmuebles() {
		String texto = "\nInmuebles : " + inmuebles.size() + "\n";
		for(Inmueble i: inmuebles) {
			texto += "\t" + i.toString() + "\n";
			
		}
		return texto;
	}
	
	

	/**
	 * @return the empleados
	 */
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	/**
	 * @param empleados the empleados to set
	 */
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	/**
	 * @return the inmuebles
	 */
	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	/**
	 * @param inmuebles the inmuebles to set
	 */
	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public int guardarDatos(String ficheroEmpleados, String ficheroInmuebles) throws PersistenciaException {
		GestorCSV gestor = new GestorCSV();
		int resulE=gestor.guardarEmpleados(ficheroEmpleados,this);
		int resulI=gestor.guardarInmuebles(ficheroInmuebles,this);
		return resulE+resulI;
	}
}
