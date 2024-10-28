package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio11 {

	public static void main(String[] args) {
		ProcessBuilder process = new ProcessBuilder("powershell","get-process");
		
		BufferedReader reader = null;
		
		try {
			Process p = process.start();
			InputStream st = p.getInputStream();
			reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
