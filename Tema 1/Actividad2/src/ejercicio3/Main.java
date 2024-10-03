package ejercicio3;

public class Main {

	public static void main(String[] args) {
		
		Login l = new Login();
		nuevaCuenta(l,"miau","womeni");
		nuevaCuenta(l,"miaooo","womeni");
		nuevaCuenta(l,"miaaoo","sgdhjagsS");
		
		
		l.mostrarCuentas();
		
		try {
			l.modificarPassword("miau", "womeni", "maricha");
		} catch (IncorrectFormatException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			l.login("miaooo", "womeni");
		} catch (IncorrectFormatException e) {
			System.out.println(e.getMessage());
		}
		
		l.mostrarCuentas();

	}
	
	public static void nuevaCuenta(Login l,String user,String password) {
		
		try {
			l.nuevoRegistro(user, password);
		} catch (IncorrectFormatException e) {
			System.out.println(e.getMessage());
		} catch (AlreadyRegisteredException e) {
			System.out.println(e.getMessage());
		}

	}

}
