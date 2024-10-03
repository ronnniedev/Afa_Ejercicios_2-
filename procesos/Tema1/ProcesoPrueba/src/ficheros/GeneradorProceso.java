package ficheros;

import java.io.File;
import java.io.IOException;

public class GeneradorProceso {

	public static void main(String[] args) {
		
		// ProcessBuilder process = new ProcessBuilder("Notepad.exe","C:\\Users\\mario\\OneDrive\\Desktop\\Programas\\procesos\\miau.txt");
		ProcessBuilder procesoNotas = new ProcessBuilder("notepad.exe","poronga.txt");
		procesoNotas.directory(new File("C:\\pepe"));
		try {
			procesoNotas.start();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}

	}

}