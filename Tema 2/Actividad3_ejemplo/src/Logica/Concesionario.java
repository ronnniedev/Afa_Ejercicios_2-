package Logica;

import java.util.LinkedList;
import java.util.List;

import Persistencia.GestorCSV;
import Persistencia.GestorCSV2;

public class Concesionario {
	List<Coche> coches;
	
	public Concesionario(String nombreFicheroOrigen) {
		GestorCSV gestor = new GestorCSV();
		coches = new LinkedList<Coche>();
		gestor.leerFichero(nombreFicheroOrigen,coches);
	}
	
	

	public String listarCoches() {
		String texto = "Total coches :" + coches.size() + "\n";
		
		for(int i = 0; i < coches.size(); i++) {
			Coche c = coches.get(i);
			texto += c.toString() + "\n";
		}
		return texto;
	}
	
	public void vaciaLista() {
		coches.clear();
	}

	public void NuevoCoche(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public String listarCochesPorMarca(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void guardarDatos(String nombreFicheroDestino) {
		// TODO Auto-generated method stub
		
	}
}
