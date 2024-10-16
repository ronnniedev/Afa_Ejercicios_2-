package Logica;

import java.util.LinkedList;
import java.util.List;

import Persistencia.GestorCSV;

public class Concesionario {
	List<Coche> coches;
	
	public Concesionario(String nombreFicheroOrigen) {
		GestorCSV gestor = new GestorCSV();
		coches = new LinkedList<Coche>();
		gestor.leerFichero(nombreFicheroOrigen,coches);
	}
}
