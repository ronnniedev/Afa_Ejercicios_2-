package ficheros;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static Scanner keyboard = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		iniciarConsola();
		System.out.println("Que quieres ejecutar?");
		LanzarPrograma(keyboard.nextLine());

	}

	public static void LanzarPrograma(String parametro) {
		
		ProcessBuilder process = new ProcessBuilder(parametro);
		
		Process p;
		
		
		try {
			
			p = process.start();
			int exitCode = p.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void iniciarConsola() {
		ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe");
		Process p1;
		
		try {
			p1 = processBuilder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
