package Logica;

import java.util.ArrayList;
import java.util.List;



import Excepciones.*;
import Modelo.*;
import Persistencia.GestorPersistencia;



public class Taller {
	
	private List <Vehiculo>vehiculos;
	private List <Mecanico>mecanicos;
	private List<Reparacion>reparaciones;

	public Taller(String ficheroDatos) {
		this.vehiculos = new ArrayList<Vehiculo>();
		this.mecanicos = new ArrayList<Mecanico>();
		this.reparaciones = new ArrayList<Reparacion>();
	}
	public void realizarReparacion(String matricula, String dniMecanico
									, int codigo, String fecha, String descripcion,double importe) {
		Reparacion r = null;
		Mecanico m = null;
		try {
			r = localizarReparacion(codigo);
			m = localizarMecanico(dniMecanico);
		} catch (ExcepcionLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(r == null && m != null) {
			r = new Reparacion(codigo,dniMecanico,matricula,fecha,importe,descripcion);
		}
	}
	
	private Mecanico localizarMecanico(String dni) throws ExcepcionLogica {
		for(Mecanico mecanico: mecanicos) {
			if(mecanico.getDNI().compareTo(dni)== 0) {
				return mecanico;
			}
		}
		throw new ExcepcionLogica("ERROR mecanico no encontrado");
	}
	public Reparacion localizarReparacion(int codigo) throws ExcepcionLogica {
		for(Reparacion reparacion: reparaciones) {
			if(reparacion.getCodigo() == codigo) {
				return reparacion;
			}
		}
		throw new ExcepcionLogica("ERROR mecanico no encontrado");
	}

	public void guardarDatos(String ficheroSalida) {
		// TODO Auto-generated method stub
		
	}

	public List <Vehiculo> listarVehiculos() {
		return vehiculos;
		
	}

	public String listarMecanicos() {
		String texto = "-------------Mecanicos alojados--------------\n";
		
		for(Mecanico mecanico: mecanicos) {
			texto += mecanico.toString() + "\n";
			for(Reparacion reparacion: reparaciones) {
				if(reparacion.getDNI().compareTo(mecanico.getDNI()) == 0) {
					texto += reparacion.toString() +"\n";
				}
			}
		}
		
		return texto;
	}

	public String verReparacionesVehiculo(String matricula) {
		String texto = "-------Reparaciones de " + matricula + "--------------\n";
		for(Reparacion r: reparaciones) {
			if(r.getMatricula().compareTo(matricula) == 0) {
				texto += r.toString() + "\n";
			}
		}
		return texto;
	}

	public void eliminarReparacion(String matricula, String dniMecanico, int codigo) {
		Reparacion r = null;
		Mecanico m = null;
		try {
			r = localizarReparacion(codigo);
			m = localizarMecanico(dniMecanico);
		} catch (ExcepcionLogica e) {
			System.out.println(e.getMessage());
		}
		 
		if(r != null && m!= null) {
			reparaciones.remove(r);
			System.out.println("Borrado con exito");
		}
		
	}

	
	

}
