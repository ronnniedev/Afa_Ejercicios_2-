package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Listar_Archivos_dir {

	public static void main(String[] args) {

		
		try {
			// Comando que se va a ejecutar.
			String comando = "cmd /c dir";
			Process proceso = Runtime.getRuntime().exec(comando);
			
			// Leer la salida del comando
			BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
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
