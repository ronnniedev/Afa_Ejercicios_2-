/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


/**
 *
 * @author Usuario
 */

// es el patrón Singleton, objeto accesible desde cualquier parte del proyecto. Características:
public class Loggerfichero {
	// la propia clase tiene un atributo de su misma clase privado static
        private static Loggerfichero log ;
        BufferedWriter buffer;
        
        // el constructor siempre es privado: nunca se va a poder hacer un new de la clase
        private Loggerfichero() {
            try {
                String rutafichero = System.getProperty("user.dir")+"\\datos\\";
                String ficheroLog=rutafichero+"log.txt";
                // true añade al final los datos y no sobrescribe el fichero
                buffer = new BufferedWriter(new FileWriter(ficheroLog,true));
            } catch (IOException ex) {
                System.out.println("ERROR al abrir fichero");
            }
        }

        /* Cuando queramos guardar una traza en el sistema
         * 1. Pregunta si el log es null: el propio objeto de la clase
         * 2. Si es null, se crea llamando a su constructor
         * 3. Retornamos el propio objeto de la clase
         */
        public static Loggerfichero getInstance() {
            if(null == log) {
                log = new Loggerfichero();
            }
            return log;
        }

        public void writeSmg(String msg){
            String linea = LocalDateTime.now()+"\n";
            linea +="\t"+msg;
            try {
                buffer.write(linea);
            } catch (IOException ex) {
                System.out.println("ERROR");
            }
        }
        
        public void closeLog(){
            try {
                buffer.close();
            } catch (IOException ex) {
                System.out.println("ERROR");
            }
        }
}
