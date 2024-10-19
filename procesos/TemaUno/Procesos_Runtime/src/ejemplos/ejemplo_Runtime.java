package ejemplos;

import java.io.IOException;

public class ejemplo_Runtime {

	public static void main(String[] args) {
		
		// Runtime funciona igual que Process

		try {
			Runtime.getRuntime().exec("Notepad.exe notas.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String [] infoProceso = {"Notepad.exe", "notas.txt"};
		try {
			Runtime.getRuntime().exec(infoProceso);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
