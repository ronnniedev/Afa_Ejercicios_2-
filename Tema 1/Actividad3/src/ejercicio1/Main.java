package ejercicio1;

public class Main {

	public static void main(String[] args) {
		int valor = 0;
		
		try {
			valor = valor + 1;
			valor = valor + Integer.parseInt("A");
		}catch(Exception e) {
			valor = valor + Integer.parseInt("A");
			System.out.println(e.getMessage());
		}finally {
			valor = valor +5;
			System.out.println("Pipo" + valor);
			
		}
		System.out.println(valor);

	}

}
