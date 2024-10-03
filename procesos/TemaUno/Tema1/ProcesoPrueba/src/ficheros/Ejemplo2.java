package ficheros;

import java.io.IOException;
import java.util.Map;

public class Ejemplo2 {

	public static void main(String[] args) {
		
		
		ProcessBuilder process = new ProcessBuilder("notepad.exe");
		Map<String,String> env = process.environment();
		System.out.println(env.get(env));
		System.out.println(env.get("NUMBER_OF_PROCESSORS"));
		
		try {
			process.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
