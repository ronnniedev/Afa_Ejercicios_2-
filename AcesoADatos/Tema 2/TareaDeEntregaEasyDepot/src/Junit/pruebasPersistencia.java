package Junit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import Excepciones.LogicaException;
import Excepciones.PersistenciaException;
import Logica.Sistema;
import Modelo.Cliente;
import Modelo.Consigna;
import Modelo.Reserva;
import Persistencia.GestorPersistencia;

class pruebasPersistencia {
	GestorPersistencia gestor = new GestorPersistencia();
	GestorPersistencia gestorConSistema = new GestorPersistencia();
	Sistema sistema = new Sistema();
	
	
	@Test
	public void testCategoriaMalHecha()  {

		assertThrows(PersistenciaException.class,()->gestor.categorizarLinea(0, 
				"a;Carlos;López;620447727;email13;pass13;4;45")); 
		assertThrows(PersistenciaException.class,()->gestor.categorizarLinea(0, 
				"4;1;Calle Teodoro Cuesta")); 
		assertThrows(PersistenciaException.class,()->gestor.categorizarLinea(0, 
				"12;email7;1-1;Tue Oct 29 20:26:07 CET 2024\"\r\n"
				+ "					+ \";NA;false;false;Sin Incidencia")); 
		
		// Entradas bien categorizadas
		try {
			assertTrue(gestor.categorizarLinea(0,"1;Carlos;López;620447727;email13;pass13;4;45"));
			assertTrue(gestor.categorizarLinea(0,"2;1;Calle Teodoro Cuesta"));
			assertTrue(gestor.categorizarLinea(0,"3;email7;1-1;Tue Oct 29 20:26:07 CET 2024"
					+ ";NA;false;false;Sin Incidencia"));
			
		} catch (Exception e) {
		}
		
	}
	
	@Test
	public void malFormateo()  {

		// Falta movil
		assertThrows(PersistenciaException.class,()->gestor.categorizarLinea(0, 
				"1;Carlos;Lópeze;mail13;pass13;4;45")); 
		// Tiene un dato de mas
		assertThrows(PersistenciaException.class,()->gestor.categorizarLinea(0, 
				"2;1;Calle Teodoro Cuesta;62")); 
		// Falta correo
		assertThrows(PersistenciaException.class,()->gestor.categorizarLinea(0, 
				"3;1-1;Tue Oct 29 20:26:07 CET 2024"
						+ ";NA;false;false;Sin Incidencia")); 
		
		// Entradas bien categorizadas
		try {
			assertTrue(gestor.categorizarLinea(0,"1;Carlos;López;620447727;email13;pass13;4;45"));
			assertTrue(gestor.categorizarLinea(0,"2;1;Calle Teodoro Cuesta"));
			assertTrue(gestor.categorizarLinea(0,"3;email7;1-1;Tue Oct 29 20:26:07 CET 2024"
					+ ";NA;false;false;Sin Incidencia"));
			
		} catch (Exception e) {
		}
		
	}
	
	@Test
	public void ElementoInexistente()  {

		// No existe la consigna 1 para meter esta reserva
		Reserva r;
		Reserva r2;
		try {
			
			
			// Cliente con el que vamos a trabajar
			Cliente c = Cliente.serializeCliente("1;Marta;Martínez;678748433;email1;pass15;4;50");
			sistema.addCliente(c);
			r = Reserva.serializeReserva("3;email1;1-1;Tue Oct 29 20:26:07 CET 2024"
					+ ";NA;false;false;Sin Incidencia");
			assertThrows(LogicaException.class,()->sistema.addReserva(r)); 
			
			
			// Existe la consigna pero no el cliente
			Consigna con = Consigna.serializeConsigna("2;1;Calle Teodoro Cuesta");
			sistema.addConsigna(con);
			r2 = Reserva.serializeReserva("3;email2;1-1;Tue Oct 29 20:26:07 CET 2024"
					+ ";NA;false;false;Sin Incidencia");
			
			// Existe tanto el cliente como la reserva
			Reserva r3 = Reserva.serializeReserva("3;email1;1-1;Tue Oct 29 20:26:07 CET 2024"
					+ ";NA;false;false;Sin Incidencia");
			assertTrue(r3 != null);
			
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LogicaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void FicheroNoExiste()  {
		
		//Cargamos un fichero que no existe
		assertThrows(FileNotFoundException.class,()->gestor.cargarDatos("\\Datos\\entr1da.csv"));
		
		//Carga un archivo correctamente
		try {
			assertTrue(gestor.cargarDatos("\\Datos\\entrada.csv"));
		} catch (IOException e) {
		}
		
		
	}
	
	@Test
	public void ElementoRepetido()  {
		
		// Cliente con el que vamos a trabajar
		Cliente c;
		try {
			// Si metemos un cliente que no existe
			c = Cliente.serializeCliente("1;Marta;Martínez;678748433;email1;pass15;4;50");
			assertTrue(sistema.addCliente(c));
			
			//Si metemos un cliente que existe
			assertThrows(LogicaException.class,()->sistema.addCliente(c));
			
			// Metemos una consigna que no existe
			Consigna con = Consigna.serializeConsigna("2;1;Calle Teodoro Cuesta");
			assertTrue(sistema.addConsigna(con));
			
			//Metemos una consigna que existe
			assertThrows(LogicaException.class,()->sistema.addConsigna(con));
			
			// Si metemos una reserva que no existe
			Reserva r = Reserva.serializeReserva("3;email1;1-1;Tue Oct 29 20:26:07 CET 2024"
					+ ";NA;false;false;Sin Incidencia");
			assertTrue(sistema.addReserva(r));
			
			//Si metemos una reserva que existe
			assertThrows(LogicaException.class,()->sistema.addReserva(r));
						
			
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LogicaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
