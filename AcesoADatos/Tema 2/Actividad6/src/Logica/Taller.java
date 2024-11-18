package logica;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import excepciones.ExcepcionLogica;
import excepciones.LogicaException;
import excepciones.PersistenciaException;
import modelo.Mecanico;
import modelo.Reparacion;
import modelo.Vehiculo;
import persistencia.GestorPersistencia;

public class Taller {
	
	private List <Vehiculo> vehiculos;
	private List <Mecanico> mecanicos;
	private List <Reparacion> reparaciones;
	private GestorPersistencia gestor;

	public Taller(String ficheroDatos) throws FileNotFoundException {
		
		this.vehiculos = new ArrayList<Vehiculo>();
		this.mecanicos = new ArrayList<Mecanico>();
		this.reparaciones = new ArrayList<Reparacion>();
		this.gestor = new GestorPersistencia(this);
		gestor.cargarDatos(ficheroDatos);
		
	}
	
	

	/**
	 * @return the vehiculos
	 */
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}



	/**
	 * @param vehiculos the vehiculos to set
	 */
	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}



	/**
	 * @return the mecanicos
	 */
	public List<Mecanico> getMecanicos() {
		return mecanicos;
	}



	/**
	 * @param mecanicos the mecanicos to set
	 */
	public void setMecanicos(List<Mecanico> mecanicos) {
		this.mecanicos = mecanicos;
	}



	/**
	 * @return the reparaciones
	 */
	public List<Reparacion> getReparaciones() {
		return reparaciones;
	}



	/**
	 * @param reparaciones the reparaciones to set
	 */
	public void setReparaciones(List<Reparacion> reparaciones) {
		this.reparaciones = reparaciones;
	}



	/**
	 * @return the gestor
	 */
	public GestorPersistencia getGestor() {
		return gestor;
	}



	/**
	 * @param gestor the gestor to set
	 */
	public void setGestor(GestorPersistencia gestor) {
		this.gestor = gestor;
	}



	public void guardarDatos(String ficheroSalida) {
		gestor.guardarDatos(ficheroSalida);
		
	}

	public List <Vehiculo> listarVehiculos() {
		return vehiculos;
		
	}

	public String listarMecanicos() {
		String texto = "";
		
		for(Mecanico m: mecanicos) {
			texto += m.toString() +"\n";
			texto+= "-------Reparaciones de " + m.getNombre() +  " -----------\n";
			for(Reparacion r: reparaciones) {
				if(r.getDniMecanico().compareTo(m.getDni()) == 0) {
					texto += r.toString() +"\n";
				}
				
			}
		}
		return texto;
		
	}

	public String verReparacionesVehiculo(String matricula) throws ExcepcionLogica {
		Vehiculo v = buscarVehiculo(matricula);
		String texto = "------Reparaciones de " + matricula + "-------\n";
		for(Reparacion r: reparaciones) {
			if(r.getMatricula().compareTo(matricula) == 0) {
				texto += r.toString() + "\n";
			}
			
		}
		
		return texto;
	}

	public void eliminarReparacion(String matricula, String dniMecanico, int codigo) 
			throws ExcepcionLogica {
		buscarVehiculo(matricula);
		buscarMecanico(dniMecanico);
		Reparacion r = buscarReparacion(codigo);
		reparaciones.remove(r);
	}

	private Reparacion buscarReparacion(int codigo) throws ExcepcionLogica {
		for(Reparacion r: reparaciones) {
			if(codigo == r.getCodigo()) {
				return r;
			}
		}
		throw new ExcepcionLogica("ERROR reparacion no encontrada");
	}

	private Mecanico buscarMecanico(String dniMecanico) throws ExcepcionLogica {
		
		for(Mecanico m: mecanicos) {
			if(m.getDni().compareTo(dniMecanico)==0) {
				return m;
			}
		}
		
		throw new ExcepcionLogica("ERROR mecanico no encontrado");
	}

	public void realizarReparacion(String matricula, String dniMecanico, int codigo, String fecha, String descripcion,
			double importe) throws ExcepcionLogica{
		
		buscarVehiculo(matricula);
		Reparacion r = new Reparacion(codigo,dniMecanico,matricula,fecha,importe,
				descripcion);
		addReparacion(r);
	}

	public void addVehiculo(Vehiculo v) throws PersistenciaException {
		
		for(Vehiculo veh: vehiculos) {
			if(veh.getMatricula().compareTo(v.getMatricula()) == 0) {
				throw new PersistenciaException("ERROR esta matricula ya existe");
			}
		}
		
		vehiculos.add(v);
		
	}

	private Vehiculo buscarVehiculo(String matricula) throws ExcepcionLogica {
		
		for(Vehiculo v: vehiculos) {
			if(v.getMatricula().compareTo(matricula) == 0) {
				return v;
			}
		}
		
		throw new ExcepcionLogica("ERROR vehiculo no encontrado");
	}

	public void addMecanico(Mecanico m) throws PersistenciaException {

		for(Mecanico mec: mecanicos) {
			if(mec.getDni().compareTo(m.getDni()) == 0) {
				throw new PersistenciaException("ERROR este DNI ya existe");
			}
		}
		
		mecanicos.add(m);
		
	}

	public void addReparacion(Reparacion r)throws ExcepcionLogica {
		
		for(Reparacion rep: reparaciones) {
			if(r.getCodigo() == rep.getCodigo()) {
				throw new ExcepcionLogica("ERROR este codigo de reparacion ya existe");
			}
		}
		
		reparaciones.add(r);
	}

}
