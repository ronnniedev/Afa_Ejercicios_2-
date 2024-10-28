package ficheros;

import java.io.IOException;
import java.util.Map;

public class Ejercicio8 {

	public static void main(String[] args) {
		ProcessBuilder notepad = new ProcessBuilder("notepad.exe");	
			
		Map <String,String> variables= notepad.environment();
		
		for(String claves: variables.keySet()) {
			System.out.print(claves.toString() + ": " + variables.get(claves).toString() + "\n");
		}
		
	}

}
