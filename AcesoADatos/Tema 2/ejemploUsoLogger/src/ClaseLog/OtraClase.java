package ClaseLog;

import java.util.logging.Level;
import java.util.logging.Logger;



public class OtraClase {
	
	static final Logger logger = Logger.getLogger("OtraClase");
	
	public OtraClase() {
		MiLog.guardarMensaje(Level.INFO, "constructor");
		System.out.println("Un constructor de la nueva clase");
	}
	
	public void setValor() {
		MiLog.guardarMensaje(Level.INFO, "set Valor");
		System.out.println("Metodo set valor");
	}
	
	public void getValor() {
		MiLog.guardarMensaje(Level.INFO, "get Valor");
		System.out.println("Metodo getValor");
	}
}
