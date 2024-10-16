package ejercicio3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File f = new File ("Ficheros_Act2//restaurantes.csv"); 
		BufferedWriter w = null;
		
		
		try {
			w = new BufferedWriter(new FileWriter(f.getAbsolutePath(),true));
			w.write("\nKFC,Teodoro Cuesta,Gijon,AS,55674");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				w.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Fin");

	}

}
