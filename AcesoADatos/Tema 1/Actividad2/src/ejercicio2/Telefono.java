package ejercicio2;

import java.util.Objects;

public class Telefono {
	
	private String telefono;

	public Telefono(String telefono) throws TooLongException {
		this.telefono = comprobarTelefono(telefono);
	}
	
	public String comprobarTelefono(String telefono) throws TooLongException {
		
		if(telefono.length()==9) {
			for(int i = 0; i < telefono.length(); i++) {
				if(!Character.isDigit(telefono.charAt(i))) {
					throw new TooLongException("El telefono solo puede estar compuesto por numeros");
					
				}
				
			}
			
		}else {
			throw new TooLongException("El telefono debe tener 9 digitos");
			
		}
	
		
		return telefono;
		
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefono other = (Telefono) obj;
		return other.getTelefono().compareTo(this.telefono) == 0;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Telefono [telefono=" + telefono + "]";
	}
	
	

}
