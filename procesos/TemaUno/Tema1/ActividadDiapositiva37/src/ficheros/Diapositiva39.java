package ficheros;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Diapositiva39 {

	public static void main(String[] args) {
		
		
		File directorio = new File("C:\\Users\\mario\\Desktop");
		ProcessBuilder pb = new ProcessBuilder("CMD","/C","java -jar","Lectura.jar");
		pb.directory(directorio);
		
		Process p;
		try {
			p = pb.start();
			OutputStream out = p.getOutputStream();
			out.write("Hola mundo".getBytes());
			out.flush();
			
			//Escribimo el resultado
			InputStream in = p.getInputStream();
			int texto;
			while((texto = in.read())!=-1) {
				System.out.println((char)texto);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Sobrescribimo la entrada del proceso Lectura
		
		

	}

}
