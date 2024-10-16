package ficheros;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {

		File f = new File("");
		String ruta = f.getAbsolutePath();
		List <String> rutas = new LinkedList<String>();
		
		
		rutas.add(ruta + "\\pruebas");
		rutas.add(ruta + "\\pruebas\\bin");
		rutas.add(ruta + "\\pruebas\\bin\\rm.txt");
		rutas.add(ruta + "\\pruebas\\bin\\ls.txt");
		rutas.add(ruta + "\\pruebas\\bin\\cat.txt");
		rutas.add(ruta + "\\pruebas\\usr");
		rutas.add(ruta + "\\pruebas\\usr\\dan");
		rutas.add(ruta + "\\pruebas\\usr\\bill");
		rutas.add(ruta + "\\pruebas\\usr\\bill\\file1.txt");
		rutas.add(ruta + "\\pruebas\\usr\\bill\\file2.txt");
		rutas.add(ruta + "\\pruebas\\usr\\bill\\file3.txt");
		rutas.add(ruta + "\\pruebas\\usr\\gord");
		
		for(String direction: rutas) {
			if(direction.contains(".")) {
				creaArchivo(direction);
			}else {
				creaDirectorio(direction);
			}
		}
	
		
		System.out.println("Programa finalizado con exito");
		
		
	}
	
	public static void crearSistemaPruebas(String ruta) {
		
		creaDirectorio(ruta + "pruebas");
		creaDirectorio(ruta + "pruebas\\bin");
		creaArchivo(ruta + "pruebas\\bin\\rm.txt");
		creaArchivo(ruta + "pruebas\\bin\\ls.txt");
		creaArchivo(ruta + "pruebas\\bin\\cat.txt");
		creaDirectorio(ruta + "pruebas\\usr");
		creaDirectorio(ruta + "pruebas\\usr\\dan");
		creaDirectorio(ruta + "pruebas\\usr\\bill");
		creaArchivo(ruta + "pruebas\\usr\\bill\\file1.txt");
		creaArchivo(ruta + "pruebas\\usr\\bill\\file2.txt");
		creaArchivo(ruta + "pruebas\\usr\\bill\\file3.txt");
		creaDirectorio(ruta + "pruebas\\usr\\gord");
		
		
		System.out.println("Programa finalizado con exito");
	}
	
	public static void comprobarEstructura(List <String>rutas) {
		
		for(String ruta: rutas) {
			File f = new File(ruta);
			if(f.isDirectory()) {
				if(!comprobarExistencia(f,rutas)) {
					
				}
			}else {
				
			}
		}
		
	}
	
	public static boolean comprobarExistencia(File f,List<String>rutas) {
		
		for(String ruta: rutas) {
			
		}
		return false;
	}
	
	public static void creaDirectorio(String ruta) {
		File f = new File(ruta);
		
		if(f.isDirectory()) {
			System.out.println(f.getName() + " ya existe");
			
		}else {
			f.mkdir();
		}
		
	}
	
	public static void creaArchivo(String ruta) {
		File f = new File(ruta);
		
		if(f.isFile()) {
			System.out.println(f.getName() + " ya existe");
		}else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Algo inesperado ha ocurrido");
				System.out.println(e.getMessage());
			}
		}
		
	}

}
