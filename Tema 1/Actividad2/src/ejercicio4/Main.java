package ejercicio4;

public class Main {

	public static void main(String[] args) {
		Gestor g = new Gestor();
		g.comprobarDireccion("http://www.host.com:80/datos/fichero.txt");
		g.visitarUrl("http://www.host.com:80/datos/fichero.txt");
		g.visitarUrl("http://www.host.com:80/datos/fichero.txt");
		g.visitarUrl("http://www.host.com:80/datos/fichero.txt");
		
	}

}
