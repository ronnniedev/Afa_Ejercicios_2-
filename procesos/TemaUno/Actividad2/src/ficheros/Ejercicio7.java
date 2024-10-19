package ficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio7 {

	public static void main(String[] args) {
		
		ProcessBuilder process = new ProcessBuilder("cmd", "/c","start","C:\\Users\\mario\\OneDrive\\Desktop\\ejemplo.odt");

		try {
			Process p = process.start();

			InputStream st = p.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			// Creamos un reader que lee los errores en caso de que los haya
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
			while ((linea = errorReader.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
