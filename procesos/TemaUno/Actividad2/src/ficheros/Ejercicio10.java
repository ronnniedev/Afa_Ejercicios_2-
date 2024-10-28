package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio10 {

	public static void main(String[] args) {
		ProcessBuilder process = new ProcessBuilder("cmd", "/c","DIR", "C:\\Users\\mario\\Desktop\\ejercicio10");
		File file = new File("C:\\Users\\mario\\Desktop\\ejercicio10\\log.txt");
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			Process p = process.start();
			InputStream st = p.getInputStream();
			reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			writer = new BufferedWriter(new FileWriter(file));
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
				writer.write(linea + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
