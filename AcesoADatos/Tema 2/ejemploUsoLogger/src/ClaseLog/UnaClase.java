package ClaseLog;


import java.util.logging.Logger;

import ejemplos.PruebaMain;

import java.util.Scanner;
import java.util.logging.Level;


public class UnaClase {
	

	public static Scanner teclado=new Scanner(System.in);
	static final Logger logger = Logger.getLogger("UnaClase");

		public static void funcMain1() {		
		MiLog.guardarMensaje(Level.INFO, "Func Main 1");
		System.out.println("Funcion Main 1");
		funcMain2();
	}
	
	public static void funcMain2() {
		MiLog.guardarMensaje(Level.INFO, "Func Main 2");
		System.out.println("Funcion Main 2");
		System.out.println("Introduce numero ");
		int num=teclado.nextInt();
		if(num==3) {
			MiLog.guardarMensaje(Level.SEVERE, "Func Main 2");
		}else {
			MiLog.guardarMensaje(Level.WARNING, "Func Main 2");
		}
		funcMain3();
	}
	
	
	public static void funcMain3() {
		MiLog.guardarMensaje(Level.INFO, "Func Main 3");
		System.out.println("Funcion Main 3");
		
		funcMain4();
	}
	
	
	public static void funcMain4() {
		MiLog.guardarMensaje(Level.INFO, "Func Main 4");
		System.out.println("Funcion Main 4");
		OtraClase otra=new OtraClase();
		otra.getValor();
		otra.setValor();
	}
}

