package ficheros;

import java.io.IOException;

public class Ejercicio6 {

	public static void main(String[] args) {
		ProcessBuilder notepad = new ProcessBuilder("notepad.exe");
		ProcessBuilder calculadora = new ProcessBuilder("calc.exe");
		
		Process p;
		
		try {
			p = notepad.start();
			int exitCode = p.waitFor();
			p = calculadora.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
