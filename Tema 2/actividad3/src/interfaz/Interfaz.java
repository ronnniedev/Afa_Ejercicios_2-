package interfaz;

import principal.Concesionario;

/**
 *
 * @author Usuario
 */
public class Interfaz {

    String nombreFicheroOrigen;
    String nombreFicheroDestino;

    public Interfaz(){
        String rutafichero = System.getProperty("user.dir")+"\\src\\ficheros\\";
        nombreFicheroOrigen = rutafichero+"coches.csv";        
        nombreFicheroDestino = rutafichero+"cochesDestino.csv";
        menu();
    }
    
    public void menu(){
        Concesionario concesionario = new Concesionario(nombreFicheroOrigen);
        System.out.println("Listado de la informacion");
        System.out.println(concesionario.listarCoches());
        concesionario.NuevoCoche("nissan","xtrail");
        concesionario.NuevoCoche("seat","leon");
        concesionario.NuevoCoche("opel","astra");
        System.out.println("Listado de la informacion");
        System.out.println(concesionario.listarCoches());
        System.out.println("Listado marca seat");
        System.out.println(concesionario.listarCochesPorMarca("seat"));
        concesionario.guardarDatos(nombreFicheroDestino);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Interfaz interfaz = new Interfaz();
    }
    
}

