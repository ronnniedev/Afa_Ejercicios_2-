package ficheros;

public class Ejercicio13 {

	public static void main(String[] args) {
		
		Process p;
		
		try {
			p = Funciones.lanzarPrograma("notepad.exe");
			int exitCode = p.waitFor();
			if(exitCode == 0) {
				Funciones.lanzarPrograma("calc.exe");
			}else {
				Funciones.lanzarPrograma("mspaint.exe");
			}
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
