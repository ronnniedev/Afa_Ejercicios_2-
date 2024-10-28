package Interfaz;

import java.util.Scanner;

import Excepciones.ExcepcionLogica;
import Logica.Taller;
import Modelo.Vehiculo;

public class Main {
	
	Taller taller;
	
	public Main() throws ExcepcionLogica {
		String ficheroDatos="";
		taller=new Taller(ficheroDatos);
		System.out.println(taller.toString());
		int opcion=menu();
		while(opcion!=0){
			procesarOpcion(opcion);
			opcion=menu();
		}
		System.out.println("\n\nFIN\n");
		String ficheroSalida="";
		taller.guardarDatos(ficheroSalida);
	}
	
	private int menu() {
		// TODO Auto-generated method stub
		System.out.println("\n\n--------- Servicio de Taller ---------\n");
		System.out.println(" 1.- Listar vehiculos");
		System.out.println(" 2.- Listar mecinicos y sus reparaciones");
		System.out.println(" 3.- Realizar reparacion");
		System.out.println(" 4.- Eliminar reparacion");
		System.out.println(" 5.- Listar reparaciones de vehiculo");
		System.out.println(" 6.- Eliminar vehiculos con todas las reparaciones antiguas");
		System.out.println("\n 0.- Salir");
		System.out.println("\nOPCION: ");
		int opcion=0;
		Scanner teclado=new Scanner(System.in);
		opcion=teclado.nextInt();		
		return opcion;
	}

	
	private void procesarOpcion(int opcion) throws ExcepcionLogica {
		switch (opcion) {
		case 1:
			listarVehiculos();
			break;
		case 2:
			listarMecanicosConReparaciones();
			break;
		case 3:
			realizarReparacion();
			break;
		case 4:
			eliminarReparacion();			
			break;
		case 5:
			listarReparacionesVehiculo();
			break;
		case 6:
			eliminarVehiculosAntiguos();
			break;
		}
	}

	private void listarVehiculos() {
		System.out.println("\nLISTA DE VEH�CULOS: \n");
		taller.listarVehiculos();
		for(int i=0; i<taller.listarVehiculos().size(); i++){
			Vehiculo v=(Vehiculo)taller.listarVehiculos().get(i);
			String cadena=v.getMatricula()+"\t"+v.getMarcaModelo()+"\t"+v.getTipo()
			+"\t"+v.getNombreApellidos()+"\t"+v.getTelefono()+"\n";
			System.out.println(cadena);
		}
	}
	
	private void listarMecanicosConReparaciones() {
		System.out.println("\nLISTA DE Mecanicos: \n");
		taller.listarMecanicos();
		System.out.println(taller.listarMecanicos());
	}

	private void listarReparacionesVehiculo() throws ExcepcionLogica {
		System.out.println("Matricula: ");
		Scanner teclado=new Scanner (System.in);
		String matricula=teclado.next();
		System.out.println("\nLISTA DE REPARACIONES: \n");
		System.out.println(taller.verReparacionesVehiculo(matricula));
	}

	private void eliminarReparacion() throws ExcepcionLogica{
		Scanner teclado=new Scanner (System.in);
		System.out.println("Matricula: ");
		String matricula=teclado.next();
		System.out.println("Dni del mec�nico: ");
		String DniMecanico=teclado.next();
		System.out.println("C�digo: ");
		int codigo=teclado.nextInt();
		taller.eliminarReparacion(matricula, DniMecanico, codigo);
		System.out.println("\nREPARACI�N ELIMINADA\n");
	}

	private void realizarReparacion() throws ExcepcionLogica {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Matricula: ");
		String matricula=teclado.next();
		System.out.println("Dni del mec�nico: ");
		String DniMecanico=teclado.next();
		System.out.println("Codigo: ");
		int codigo=teclado.nextInt();
		System.out.println("Fecha: ");
		String fecha=teclado.next();
		System.out.println("Descripci�n: ");
		String descripcion=teclado.next();
		System.out.println("Importe: ");
		double importe=teclado.nextDouble();
		taller.realizarReparacion(matricula, DniMecanico, codigo, fecha, descripcion, importe);
		System.out.println("\nREPARACION REALIZADA\n");
	}

	private void eliminarVehiculosAntiguos() {
		
	}
	
	public static void main(String[] args) throws ExcepcionLogica {
		new Main();	
	}
}
