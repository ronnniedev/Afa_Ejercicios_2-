package interfaz;

import persistencia.FicherosCsv;

public class Main {

	public static void main(String[] args) {
		FicherosCsv lectura = new FicherosCsv();
		lectura.cargarFichero("src//ficheros//prueba.csv");
		

	}

}
