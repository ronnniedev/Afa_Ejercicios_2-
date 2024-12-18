package ejercicio3;

public class Cuenta {
	
	private User usuario;
	private String contraseña;
	
	
	public Cuenta(String user, String contraseña) throws IncorrectFormatException {
		this.usuario = new User (user);
		this.contraseña = comprobarContraseña(contraseña);
	}

	
	public String comprobarContraseña(String password) throws IncorrectFormatException {
		
		if(password.length() < 6 || password.length() > 10) {
			throw new IncorrectFormatException("La clave debe tener entre 6 y 10 caracteres");
			
		}
		
		for(int i = 0; i < password.length();i++) {
			if(!Character.isAlphabetic(password.charAt(i))) {
				throw new IncorrectFormatException("La clave debe tener caracteres alfabeticos");
				
			}
			
		}
		
		return password;
	}

	public User getUsuario() {
		return usuario;
	}


	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) throws IncorrectFormatException {
		this.contraseña =comprobarContraseña(contraseña);
	}


	@Override
	public String toString() {
		return "Cuenta [usuario=" + usuario + ", contraseña=" + contraseña + "]";
	}
	

}
