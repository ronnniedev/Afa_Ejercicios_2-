package ejemplos;


import java.util.logging.Logger;
import java.util.logging.Level;


public class PruebaMain {
	static final Logger logger = Logger.getLogger(PruebaMain.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		funcMain1();
	}
	
	public static void funcMain1() {
		logger.log(Level.INFO,"Funcion main 1");
		System.out.println("Funcion Main 1");
		funcMain2();
	}
	
	public static void funcMain2() {
		logger.log(Level.SEVERE,"Funcion main 2");
		System.out.println("Funcion Main 2");
		funcMain3();
	}
	
	
	public static void funcMain3() {
		logger.log(Level.INFO,"Funcion main 3");
		System.out.println("Funcion Main 3");
		funcMain4();
	}
	
	
	public static void funcMain4() {
		logger.log(Level.INFO,"Funcion main 4");
		System.out.println("Funcion Main 4");
	}
}

