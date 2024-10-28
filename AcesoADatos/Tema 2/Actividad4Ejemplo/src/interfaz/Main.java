package interfaz;

import logica.Inmobiliaria;
import modelo.Empleado;
import modelo.Inmueble;

import java.io.FileNotFoundException;
import java.util.Scanner;

import excepciones.Loggerfichero;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class Main {
    String rutaficheros;
    String ficheroEmpleados;
    String ficheroInmuebles;
    Inmobiliaria gestor;
    Scanner teclado = new Scanner(System.in);
    public Main(){
        
    }
    public void menu() throws FileNotFoundException, PersistenciaException, LogicaException {
        rutaficheros = System.getProperty("user.dir")+"\\datos";
        ficheroEmpleados=rutaficheros+"\\empelados.csv";
        ficheroInmuebles=rutaficheros+"\\inmuebles.csv";
        
        Loggerfichero.getInstance().writeSmg("Cargamos ficheros");
        
        gestor = new Inmobiliaria(ficheroEmpleados,ficheroInmuebles);
        int opcion = -1;
        while(opcion != 0){
            opcion = pedirOpcion();
            switch (opcion) {
                case 1:
                    listarDatos();
                    break;
                case 2: 
                    listarInmueble();
                    break;
                case 3:
                    nuevoInmmueble();
                    break;
                case 4:
                    nuevoEmpleado();
                    break;
                case 5:
                    borrarInmueble();
                    break;
                case 0:
                	guardarDatos();  
                	break;
                default:
                	System.out.println("Comando no aceptado");
                	 
            }
        }
    }

 
    
    public static void main(String[] args) {
        
        Main ejecucionMain = new Main();
        try {
			ejecucionMain.menu();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (PersistenciaException e) {
			System.out.println(e.getMessage());
		} catch (LogicaException e) {
			System.out.println(e.getMessage());
		}
    }

    private int pedirOpcion() {
        System.out.println("Menu");
        System.out.println("1.- Listar Datos ");
        System.out.println("2.- Listar Inmuebles");
        System.out.println("3.- Nuevo inmueble");
        System.out.println("4.- Nuevo empleado");
        System.out.println("5.- Borrar inmueble");
        int opcion = teclado.nextInt();
        return opcion;
    }

    private void listarDatos() {
        System.out.println("Listado informacion ");
        System.out.println(gestor.listarDatos());
    }

    private void listarInmueble() {
        System.out.println("Listado de inmuebles");
        System.out.println(gestor.listadoInmuebles());
    }

    private void nuevoInmmueble() throws PersistenciaException {
        System.out.println("Nuevo inmueble:");
        System.out.print("codInmueble");
        String codInmueble = teclado.nextLine();
        System.out.print("direccion :");
        String direccion = teclado.nextLine();
        System.out.print("tipo :");
        String tipo =teclado.nextLine();
        System.out.print("codEmpleado ");
        String codEmpleado = teclado.nextLine();
        System.out.print("precio :");
        double precio = teclado.nextDouble();
        
        String linea=codInmueble+";"+direccion+";"+tipo+";"+codEmpleado+";"+precio;
        gestor.addInmueble(Inmueble.serialize(linea));
    }

    private void nuevoEmpleado() throws PersistenciaException {
        System.out.println("Nuevo empelado:");
        System.out.print("codEmpleado ");
        String codEmpleado = teclado.nextLine();
        System.out.print("nombre completo");
        String nombreCompleto = teclado.nextLine();
        System.out.print("telefono :");
        String telefono = teclado.nextLine();
 
        String linea = codEmpleado+";"+nombreCompleto+";"+telefono;
        gestor.addEmpleado(Empleado.serialize(linea));
    }
	

    private void borrarInmueble() {
        System.out.println("Borrar Inmueble");
        teclado.nextLine();
        String codInmueble = teclado.nextLine();
       // if(gestor.borrarEmpleado(codInmueble)==true){
       //     System.out.println("Se ha borrado el inmueble correctamente");
       // }
        
    }

    private void guardarDatos() throws PersistenciaException {
    	ficheroEmpleados=rutaficheros+"\\empeladosResul.csv";
        ficheroInmuebles=rutaficheros+"\\inmueblesResul.csv";
        int resul = gestor.guardarDatos(ficheroEmpleados,ficheroInmuebles);
        System.out.println("Se han guardado "+resul+" registros");
        Loggerfichero.getInstance().closeLog();
    }
    
}
