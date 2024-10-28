package ficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio12 {

	public static void main(String[] args) {
		ProcessBuilder process = new ProcessBuilder("powershell","start-process","calc.exe");
		
		BufferedReader reader = null;
		
		try {
			Process p = process.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
