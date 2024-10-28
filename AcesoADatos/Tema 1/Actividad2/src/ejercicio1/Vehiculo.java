package ejercicio1;

public class Vehiculo {
	
	private Matricula matricula;
	private String modelo;
	private int km;
	
	
	public Vehiculo(String matricula, String modelo, int km) throws IncorrectFormatException {
		this.matricula = new Matricula(matricula);
		this.modelo = modelo;
		this.km = km;
	}


	public Matricula getMatricula() {
		return matricula;
	}


	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getKm() {
		return km;
	}


	public void setKm(int km) {
		this.km = km;
	}


	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", modelo=" + modelo + ", km=" + km + "]";
	}
	
	
	
	

}
