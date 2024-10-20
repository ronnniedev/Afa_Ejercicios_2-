package ejercicio4;

import java.util.HashMap;
import java.util.Map;

public class Gestor {
	
	Map <DireccionHTTP,Integer> direcciones;

	public Gestor() {
		this.direcciones = new HashMap<DireccionHTTP,Integer>();
	}
	
	public void comprobarDireccion(String direccion) {
		int contBarras = 0;
		String servidor = "";
		String puerto = "";
		String recurso = "";
		boolean hayPuerto = false;
		boolean direccionCorrecta = false;
		boolean puertoCorrecto = false;
		
		for(int i = 0; i < direccion.length();i++) {
			if(contBarras >= 2) {
				if(direccion.charAt(i)== ':') {
					direccionCorrecta = true;
				}else if (!direccionCorrecta){
					servidor += direccion.charAt(i);
				}else if(direccionCorrecta && Character.isDigit(direccion.charAt(i))) {
					puerto += direccion.charAt(i);
					hayPuerto = true;
				}else if(direccionCorrecta && !puertoCorrecto) {
					puertoCorrecto = true;
					recurso += direccion.charAt(i);
				}else if(direccionCorrecta && puertoCorrecto) {
					recurso += direccion.charAt(i);
				}
				
			}
			if(direccion.charAt(i) == '/') {
				contBarras++;
			}
			
		}
		
		if(direccionCorrecta && puertoCorrecto) {
			DireccionHTTP d = new DireccionHTTP(servidor,Integer.parseInt(puerto),recurso);
			if(!direcciones.containsKey(d)) {
				direcciones.put(d, 0);
				System.out.println(d.toString());
				System.out.println("Direccion añadida");
			}
			
		}else {
			System.out.println("Direccion incorrecta");
		}
		
		
	}
	
	public void visitarUrl(String direccion) {
		int contBarras = 0;
		String servidor = "";
		String puerto = "";
		String recurso = "";
		boolean hayPuerto = false;
		boolean direccionCorrecta = false;
		boolean puertoCorrecto = false;
		
		for(int i = 0; i < direccion.length();i++) {
			if(contBarras >= 2) {
				if(direccion.charAt(i)== ':') {
					direccionCorrecta = true;
				}else if (!direccionCorrecta){
					servidor += direccion.charAt(i);
				}else if(direccionCorrecta && Character.isDigit(direccion.charAt(i))) {
					puerto += direccion.charAt(i);
					hayPuerto = true;
				}else if(direccionCorrecta && !puertoCorrecto) {
					puertoCorrecto = true;
					recurso += direccion.charAt(i);
				}else if(direccionCorrecta && puertoCorrecto) {
					recurso += direccion.charAt(i);
				}
				
			}
			if(direccion.charAt(i) == '/') {
				contBarras++;
			}
			
		}
		
		if(direccionCorrecta && puertoCorrecto) {
			DireccionHTTP d = new DireccionHTTP(servidor,Integer.parseInt(puerto),recurso);
			if(direcciones.containsKey(d)) {
				int contador = direcciones.get(d);
				contador++;
				System.out.println("Pagina visitada " + contador + " veces");
				direcciones.remove(d);
				direcciones.put(d, contador);
			}
			
		}else {
			System.out.println("Direccion incorrecta");
		}
		
		
		
		
		
	}
	
	

}
