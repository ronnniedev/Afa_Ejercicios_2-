package ficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Funciones {

	public static void lanzarPrograma(String parametro) {

		ProcessBuilder process = new ProcessBuilder(parametro);

		Process p;

		try {
			p = process.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void lanzarComando(String comando,String atributo) {
		ProcessBuilder process = new ProcessBuilder("cmd", "/c",comando,atributo);
		
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
