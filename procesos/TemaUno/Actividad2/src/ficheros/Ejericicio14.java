package ficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejericicio14 {

	public static void main(String[] args) {
		ProcessBuilder process = new ProcessBuilder("powershell","start-process","notepad.exe");
		ProcessBuilder parar = new ProcessBuilder("powershell","stop-process","-name ","notepad");
		ProcessBuilder leer = new ProcessBuilder("powershell","get-process","-name ","note*");
		
		BufferedReader reader = null;
		
		try {
			process.start();
			Process p = leer.start();
			InputStream is = p.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
			
			parar.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
