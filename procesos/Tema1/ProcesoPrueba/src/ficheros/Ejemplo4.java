package ficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo4 {

	public static void main(String[] args) {
		// devuelve la info de el directorio donde esta situado, por defecto estamos en el worskpace
		ProcessBuilder process = new ProcessBuilder("cmd", "/c", "DIR","C:\\Users\\mario\\OneDrive\\Desktop\\Programas");
		try {
			Process p = process.start();
			
			InputStream st = p.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea;
			while((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}