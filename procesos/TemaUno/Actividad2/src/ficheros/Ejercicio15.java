package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio15 {

	public static void main(String[] args) {
		ProcessBuilder process = new ProcessBuilder("powershell","get-process | sort-object","-property","CPU");
		File log = new File("cpu.txt");
		System.out.println(log.getAbsolutePath());
		BufferedReader reader = null;
		BufferedWriter writer = null;
		Process p = null;
		
		try {
			p  = process.start();
			InputStream is = p.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));
			writer = new BufferedWriter(new FileWriter(log));
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
