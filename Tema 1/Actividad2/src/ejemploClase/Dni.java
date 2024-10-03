package ejemploClase;

import java.util.Objects;

public class Dni {
	
	private int numero;
	private char letra;

	public Dni(int numero,char letra) {
		this.numero = numero;
		this.letra = letra;
	}

	public String getDni() {
		return numero+letra+"";
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getDni());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dni other = (Dni) obj;
		return other.getDni().compareTo(this.getDni()) == 0;
	}

	@Override
	public String toString() {
		return "DNI : " + numero+letra;
	}
	
	
	
	

}
