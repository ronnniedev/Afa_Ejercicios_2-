package ficheros;

import java.io.IOException;


public class Ejemplo5 {

	public static void main(String[] args) {
		
		ProcessBuilder process = new ProcessBuilder("calc.exe");
		/*
		 * Espera a que termina un proceso antes de continuar el codigo
		 */
		Process p;
		try {
			p = process.start();
			int exitCode = p.waitFor();
			
			System.out.println(exitCode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
