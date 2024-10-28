package ficheros;

import java.util.Map;

public class Ejercicio9 {

	public static void main(String[] args) {
		ProcessBuilder notepad = new ProcessBuilder("notepad.exe");	
		
		Map <String,String> variables= notepad.environment();
		variables.put("Variable Ejercicio9", "Valor Ejercicio9");
		for(String claves: variables.keySet()) {
			System.out.print(claves.toString() + ": " + variables.get(claves).toString() + "\n");
		}

	}

}
