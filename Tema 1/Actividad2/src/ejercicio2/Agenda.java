package ejercicio2;

import java.util.HashMap;
import java.util.Map;

public class Agenda {
	
	private Map <Telefono,Contacto>contactos;

	public Agenda() {
		this.contactos = new HashMap<Telefono,Contacto>();
	}
	
	public void nuevaEntrada(String numero,String nombre,String direccion) throws TooLongException {
		Telefono t = new Telefono(numero);
		if(contactos.containsKey(t)) {
			System.out.println("El telefono ya esta incluido");
			
		}else {
			contactos.put(t, new Contacto(nombre,t,direccion));
			System.out.println("Telefono añadido");
		}
		
	}
	
	public Contacto buscaContactoTelefono(String numero) throws TooLongException {
		Telefono t = new Telefono(numero);
		Contacto c = null;
		
		if(contactos.containsKey(t)) {
			c  = contactos.get(t);
			
		}else {
			System.out.println("Contacto no encontrado");
			
		}
		
		return c;
	}
	
	public Contacto buscaContactoNombre(String nombre)  {
		Contacto c = null;
		
		for(Contacto con: contactos.values()) {
			if(con.getNombre() == nombre) {
				c = con;
				
			}
			
		}
		
		return c;
	}
	
	public String mostrarAgenda() {
		
		String texto =  "---Agenda telefonica---\n";
		
		for(Contacto c: contactos.values()) {
			texto += c.toString() + "\n";
			
		}
		
		return texto;
	}

	

}
