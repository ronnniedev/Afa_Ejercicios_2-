package interfaz;

import persistencia.FicherosCsv;
import logica.Agenda;
import logica.Persona;

public class Main {

	public static void main(String[] args) {
		FicherosCsv gestorPersistencia = new FicherosCsv();
		String nombrefichero = "src//ficheros//prueba.csv";
		System.out.println(nombrefichero);
		
		Agenda agenda = new Agenda();
		
		gestorPersistencia.cargarFichero(nombrefichero, agenda);
		
		agenda.addPersona(new Persona("XXX","XXX","XXX","111"));
		
		String ficheroDestino = "src//ficheros//resulPrueba.csv";
		FicherosCsv.escribirFichero(ficheroDestino,agenda);
		

	}

}
