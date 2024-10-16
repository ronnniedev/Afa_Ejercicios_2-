package principal;

import java.util.LinkedList;
import java.util.List;

import persistencia.Persistencia;

public class Concesionario {
	
	private List <Coche> listaCoches;
	

	public Concesionario(String nombreFicheroOrigen) {
		this.listaCoches = new LinkedList<Coche>();
		Persistencia.leerCoches(nombreFicheroOrigen, listaCoches);
	}
	
	public void NuevoCoche(String marca,String modelo) {
		listaCoches.add(new Coche ((listaCoches.size()+1) ,marca,modelo));
		
	}
	
	public String listarCoches() {
		String contenido = "-----Lista de coches----\n";
		
		for(Coche coche: listaCoches) {
			contenido = contenido + coche.toString() + "\n";
		}
		
		return contenido;
	}
	
	public String listarCochesPorMarca(String marca) {
		String contenido = "---------Listar coches por marca---------\n";
		
		for(Coche coche: listaCoches) {
			String linea = coche.toString();
			if(linea.contains(marca)) {
				
				contenido = contenido + linea +"\n";
			}
			
		}
		
		return contenido;
	}
	
	public void guardarDatos(String nombreFicheroDestino) {
		Persistencia.escribirCoches(nombreFicheroDestino, listaCoches);
	}
	
	

}
