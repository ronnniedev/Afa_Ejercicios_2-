package principal;

public class Coche {
	
	private int id;
	private String marca;
	private String modelo;
	
	public Coche(int id, String marca, String modelo) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public Coche(String linea) throws FormatException {
		String []trozos = linea.split(";");
		comprobarCoche(trozos);
		this.id = Integer.parseInt(trozos[0]);
		this.marca = trozos[1];
		this.modelo = trozos[2];
	}
	
	public static boolean comprobarCoche(String []trozos) throws FormatException {
		if(trozos.length != 3) {
			throw new FormatException("Solo hay 3 apartados");
		}else{
			for(int i = 0; i < trozos[0].length();i++) {
				if(!Character.isDigit(trozos[0].charAt(i))) {
					throw new FormatException("La id debe ser numerica");
				}
			}
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
	public String serialize() {
		return this.id + ";" + this.marca + ";" + this.modelo + "\n";
	}
	
	

}
