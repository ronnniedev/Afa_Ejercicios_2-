package logica;

public class Persona {

	private String nombre;
	private String ape1;
	private String ape2;
	private String tel;
	
	public Persona(String nombre, String ape1, String ape2, String tel) {
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.tel = tel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + ", tel=" + tel + "]";
	}
	
	
	
}
