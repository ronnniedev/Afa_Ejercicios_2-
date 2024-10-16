package interfaz;

import java.util.List;

import logica.Conjunto;
import logica.Restaurante;
import persistencia.GestorCSV;

public class Main {

	public static void main(String[] args) {
		String ruta = "C:\\Users\\mario\\OneDrive\\Desktop"
				+ "\\ProgramasSegundo\\Tema 2\\Actividad2Clase\\"
				+ "Ficheros";
		String ficheroOrigen = "restaurantes.csv";
		String ficheroDestino = "restauranteOut.csv";
		
		ejer1(ruta,ficheroOrigen);
		ejer2(ruta,ficheroOrigen);
		ejer3(ruta,ficheroOrigen,ficheroDestino);
		
	}
		
		private static void ejer1(String ruta,String ficheroOrigen) {
			GestorCSV gestor = new GestorCSV();
			String cadena = gestor.ejercicio1(ruta, ficheroOrigen);
			System.out.println(cadena);
		
	}
		
		private static void ejer2(String ruta,String ficheroOrigen) {
			GestorCSV gestor = new GestorCSV();
			Conjunto conjunto = new Conjunto();
			gestor.cargarDatos(ruta,ficheroOrigen,conjunto);
			List<Restaurante> lista = conjunto.ejer2();
			
			for(int i = 0; i < lista.size();i++) {
				System.out.println(lista.get(i).toString());
			}
			
			System.out.println("Restaurantes encontrados: " + lista.size());
			
			
		}
		
		private static void ejer3(String ruta,String ficheroOrigen,String ficheroDestino) {
			GestorCSV gestor = new GestorCSV();
			Conjunto conjunto = new Conjunto();
			gestor.cargarDatos(ruta,ficheroOrigen,conjunto);
			conjunto.addRestaurante(new Restaurante("nombre1","direccion1","ciudad1",
					"provincia1","11111"));
			conjunto.addRestaurante(new Restaurante("nombre2","direccion1","ciudad1",
					"provincia1","11111"));
			conjunto.addRestaurante(new Restaurante("nombre3","direccion1","ciudad1",
					"provincia1","11111"));
			gestor.guardarDatos(ruta, ficheroDestino, conjunto);
		}
	

}
