package ejercicio3;

import java.util.HashMap;
import java.util.Map;

public class Login {
	
	Map <User,Cuenta>usuarios;

	public Login() {
		this.usuarios = new HashMap<User,Cuenta>();
	}
	
	public void nuevoRegistro(String nombreUsuario,String password) 
			throws IncorrectFormatException, AlreadyRegisteredException {
		User u = new User(nombreUsuario);
		if(usuarios.containsKey(u)) {
			throw new AlreadyRegisteredException("Usuario ya registrado");
			
		}else {
			Cuenta c = new Cuenta(u.getUsuario(),password);
			usuarios.put(u, c);
			System.out.println("Usuario agregado");
		}
		
	}
	
	public void login(String nombreUsuario,String password) throws IncorrectFormatException {
		User u = new User(nombreUsuario);
		if(usuarios.containsKey(u)) {
			if(usuarios.get(u).getContraseña().compareTo(password) == 0) {
				System.out.println("Logeado con exito");
			}
			else {
				System.out.println("Contraseña incorrecta");
			}
		}else {
			System.out.println("Contraseña o usuario incorrecta");
		}
		
	}
	
	public void modificarPassword(String user, String password, String newPassword) 
			throws IncorrectFormatException {
		User u = new User(user);
		if(usuarios.containsKey(u)) {
			if(usuarios.get(u).getContraseña().compareTo(password) == 0) {
				usuarios.get(u).setContraseña(newPassword);
				}else {
					System.out.println("Contraseña incorrecta");
				}
		}else {
			System.out.println("Contraseña o usuario incorrecta");
		}
		
		
	}
	
	public void mostrarCuentas() {
		System.out.println("---Cuentas---");
		for(Cuenta c: usuarios.values()) {
			System.out.println(c.toString());
		}
		
	}
	

}
