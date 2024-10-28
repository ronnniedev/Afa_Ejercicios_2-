package ficheros;

import java.io.IOException;

public class Ejercicio6 {

	public static void main(String[] args) {
		
		Process p;
		
		try {
			p = Funciones.lanzarPrograma("notepad.exe");
			int exitCode = p.waitFor();
			Funciones.lanzarPrograma("calc.exe");
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
