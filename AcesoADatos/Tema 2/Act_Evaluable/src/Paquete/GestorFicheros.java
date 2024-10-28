package Paquete;

import java.io.File;
import java.io.IOException;

public class GestorFicheros {

	public void crearEstructura() throws IOException {
		// TODO Auto-generated method stub
		File carp1=new File("C:\\Monica\\Carp1");
		carp1.mkdir();
		
		File carp2=new File("C:\\Monica\\Carp1\\Carp2");
		carp2.mkdir();
		File fich1=new File(carp2,"fich1.txt");
		fich1.createNewFile();
		
		File carp3=new File("C:\\Monica\\Carp1\\Carp3");
		carp3.mkdir();
		File fich2=new File(carp3,"fich2.txt");
		fich2.createNewFile();
		File fich3=new File(carp3,"fich3.txt");
		fich3.createNewFile();
		
		
		
		File carp4=new File("C:\\Monica\\Carp1\\Carp4");
		carp4.mkdir();
		File fich4=new File(carp4,"fich4.txt");
		fich4.createNewFile();
		
		File carp5=new File("C:\\Monica\\Carp1\\Carp4\\Carp5");
		carp5.mkdir();
		File fich5=new File(carp4,"fich4.txt");
		fich5.createNewFile();
		
	}

	public File buscarDirectorio(String ruta,String nomDir) {
		File elemento=new File(ruta+"\\"+nomDir);
		if(elemento!=null) {
			if(elemento.exists() && elemento.isDirectory()) return elemento;
			else {
				File dir=new File(ruta);
				if(dir.exists() && dir.isDirectory()) {
					String []contenido=dir.list();
					if(contenido!=null) {
						for(int i=0;i<contenido.length;i++) {
							File resul=buscarDirectorio(ruta+"\\"+contenido[i], nomDir);
							if(resul!=null) return resul;
						}
					}
				}
			}
		}
		return null;
	}
	
	
	private File buscarFicheroEnDirectorio(File dirFile, String fich) {
		// TODO Auto-generated method stub
		String contenido[]=dirFile.list();
		if(contenido!=null) {
			for(int i=0;i<contenido.length;i++) {
				if(contenido[i].compareTo(fich)==0) {
					return new File(dirFile.getAbsolutePath()+"\\"+fich);
				}
			}
		}
		return null;
	}
	
	public boolean crearFichero(String dir, String fich) {
		// TODO Auto-generated method stub
		File dirFile=buscarDirectorio("C:\\Monica", dir);
		if(dirFile!=null) {
			File fichFile=buscarFicheroEnDirectorio(dirFile,fich);
			if(fichFile!=null) {
				if(fichFile.exists()) {
					System.out.println("ERROR el fichero ya existe ");
				}
			}else {
				try {
					fichFile=new File(dirFile,fich);
					fichFile.createNewFile();
					return true;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("ERROR al crear el fichero");
				}
			}
		}else {
			System.out.println("ERROR el directorio no existe");
		}
		return false;
	}



	public void borrarFichero(String nombreFichero) {
		if(borrarRec("c:\\Monica",nombreFichero)==true) {
			System.out.println("Se ha borrado con exito el fichero "+nombreFichero);
		}else {
			System.out.println("Error al borrar  el fichero "+nombreFichero);
		}
		
	}

	private boolean borrarRec(String ruta, String nombreFichero) {
		// TODO Auto-generated method stub
		File dirFile=new File(ruta);
		if(dirFile.list().length==0) return false; // es dir vacio
		else {
			String contenido[]=dirFile.list();
			for(int i=0;i<contenido.length;i++) {
				System.out.println(contenido[i]);
				File elem=new File(dirFile,contenido[i]);
				if(elem.isFile() && contenido[i].compareTo(nombreFichero)==0) {
					elem.delete();
					return true;
				}
				else {
					if(elem.isDirectory() && borrarRec(elem.getAbsolutePath(), nombreFichero)==true) {
						return true;						
					}
				}
			}
			return false;
		}
	}

	public void copiar(String origen, String destino) {
		
		
	}

}
