package ficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio3 {

	/* Construimos el proceso de consola llamando al cmd y diciendole que vamos a introducir un comando con el /c 
	 * Ping- Representa que haremos un ping
	 * 3- Que enviaremos 3 paquetes de pruebas
	 * google.com - el webpoint al que le haremos el ping
	*/
	public static void main(String[] args) {
		ProcessBuilder process = new ProcessBuilder("cmd", "/c","ping","-n", "3", "google.com");

		try {
			Process p = process.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
