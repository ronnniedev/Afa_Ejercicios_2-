package Paquete;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorFicheros gestor=new GestorFicheros();
		try {
			gestor.crearEstructura();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR al crear estrucura");
		}
		
		if(gestor.crearFichero("Carp2","Fich6")==true) {
			System.out.println("Fich6 creado con exito");
		}
		if(gestor.crearFichero("Carp5","Fich7")==true) {
			System.out.println("Fich7 creado con exito");
		}
		
		
		gestor.borrarFichero("fich1.txt");
		gestor.borrarFichero("Fich4");
		//gestor.copiar("Carp3","Carp6");
		
		System.out.println("ADIOS");
	}

}
