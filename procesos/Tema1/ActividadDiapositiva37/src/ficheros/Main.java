package ficheros;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder("CMD","/c","java -jar"
				,"C:\\Users\\mario\\Desktop\\programa.jar");
		
		try {
			pb.start();
		}catch(IOException e1){
			e1.printStackTrace();
		}

	}

}
