package ejemplos;

import java.io.IOException;

public class waitFor_Runtime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] infoProceso = {"Notepad.exe", "notas.txt"};
		try {
			Process proceso = Runtime.getRuntime().exec(infoProceso);
			int codigoRetorno = proceso.waitFor();
			System.out.println("Fin de la ejecución: " + codigoRetorno);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
