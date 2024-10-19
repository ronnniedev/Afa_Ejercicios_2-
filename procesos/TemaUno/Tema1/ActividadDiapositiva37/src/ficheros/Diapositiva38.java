package ficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Diapositiva38 {

public static void main(String[] args) {
	
		
		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in);
			System.out.println("Introduce una cadena de texto: ");
			String texto = br.readLine();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
