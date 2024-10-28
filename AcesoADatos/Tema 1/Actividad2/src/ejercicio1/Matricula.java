package ejercicio1;

import java.util.Objects;

public class Matricula {
	
	private String matricula;

	public Matricula(String matricula) throws IncorrectFormatException {
		this.matricula = comprobarMatricula(matricula);
	}
	
	public static String comprobarMatricula(String matricula) throws IncorrectFormatException {
		String trozos [] = matricula.split("-");
		
		if(!(trozos.length == 2)) {
			throw new IncorrectFormatException("Matricula solo puede estar conformada como DDDD-AAA");
			
		}
		
		
		if(trozos[0].length() == 4) {
			for(int i = 0;i < 4;i++) {
				if(!Character.isDigit(trozos[0].charAt(i))) {
					throw new IncorrectFormatException("Matricula con letras al principio");
					
				}
				
			}
		}else {
			throw new IncorrectFormatException("Parte 1 tiene mas de 4 caracteres");
			
		}
		
		if(trozos[1].length() == 3) {
			for(int i = 0;i < 3;i++) {
				if(!Character.isAlphabetic(trozos[1].charAt(i))) {
					throw new IncorrectFormatException("Matricula con numeros al final");
					
				}
				
			}
			
		}else {
			throw new IncorrectFormatException("Parte 2 tiene mas de 3 caracteres");
			
		}
		
		return matricula;
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		return other.getMatricula().compareTo(this.matricula) == 0;
	}

	@Override
	public String toString() {
		return "Matricula [matricula=" + matricula + "]";
	}
	
	

}
