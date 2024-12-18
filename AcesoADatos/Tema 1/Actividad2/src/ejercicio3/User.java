package ejercicio3;

import java.util.Objects;

public class User {
	
	private String usuario;

	public User(String usuario) throws IncorrectFormatException {
		this.usuario = comprobarUsuario(usuario);
	}
	
	public String comprobarUsuario(String usuario) throws IncorrectFormatException {
		
		if(usuario.length() < 4 || usuario.length() > 6) {
			throw new IncorrectFormatException("El usuaio debe tener entre 4 y 6 caracteres");
			
		}
		
		for(int i = 0; i < usuario.length();i++) {
			if(!Character.isAlphabetic(usuario.charAt(i))) {
				throw new IncorrectFormatException("La clave solo puede contener letras");
				
			}
			
		}
		
		return usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return other.getUsuario().compareTo(this.usuario) == 0;
	}

	@Override
	public String toString() {
		return "User [usuario=" + usuario + "]";
	}
	
	
	

}
