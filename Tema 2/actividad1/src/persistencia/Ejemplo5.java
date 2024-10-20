package persistencia;

import java.io.File;
import java.util.Scanner;

public class Ejemplo5 {
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		System.out.println("Escribeme la ruta: ");
		String ruta = keyboard.nextLine();
		try {
			rec(ruta);
		} catch (BorradoException e) {
			System.out.println("ERROR");
		}
		System.out.println("proceso terminado");
		

	}
	
	public static void rec (String ruta) throws BorradoException {
		File dir = new File(ruta);
		System.out.println(dir.getAbsolutePath());
		
		if(dir.isDirectory()) {
			if(!dir.delete()) {
				String []ficheros = dir.list();
				for(String fichero: ficheros) {
					File archivo = new File(dir.getAbsolutePath(),fichero);
					if(archivo.isFile()) {
						if(!archivo.delete()) {
							throw new BorradoException("Borrado no conseguido");
						}
					}else{
						rec(archivo.getAbsolutePath());
					}
				}
			}else {
				System.out.println("Borrado con exito");
			}	
		}else {
			System.out.println("No se ha encontrado el directorio");
			
		}
		dir.delete();
		
	}

}
