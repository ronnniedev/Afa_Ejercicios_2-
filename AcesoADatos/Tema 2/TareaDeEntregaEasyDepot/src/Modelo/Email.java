package Modelo;

import java.util.Objects;

public class Email {
	
	private String email;

	/**
	 * Constructor de 1 parametro de la clase Email
	 * @param email
	 */
	public Email(String email) {
		this.email = email;
	}

	/**
	 * Metodo get de la clase Email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return other.getEmail().compareTo(this.email) == 0;
	}

	/**
	 * Metodo set de la clase email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return email ;
	}
	
	

}
