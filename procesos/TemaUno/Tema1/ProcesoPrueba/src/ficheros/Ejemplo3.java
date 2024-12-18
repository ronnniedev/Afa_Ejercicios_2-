package ficheros;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Ejemplo3 {

	public static void main(String[] args) {
		ProcessBuilder builder = new ProcessBuilder("notepad.exe","datos.exe");
		
		List<String> list = builder.command();
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		try {
			builder.start();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
