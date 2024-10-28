package persistencia;

public class Main {

	public static void main(String[] args) {
		String prueba = "Hola";
		String pruebaDos = "hola";
		String pruebaTres = "pepino";
		
		verificar(prueba);
		verificar(pruebaDos);
		verificar(pruebaTres);
		
	}
	
	public static void verificar (String prueba) {
		if(prueba.toLowerCase().compareTo("hola")==0) {
			System.out.println("Acertaste");
		}else {
			System.out.println("Fallaste");
		}
		
	}

}
