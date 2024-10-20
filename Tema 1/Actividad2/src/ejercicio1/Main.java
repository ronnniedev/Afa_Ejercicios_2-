package ejercicio1;

public class Main {

	public static void main(String[] args) {
		
		Taller t = new Taller();
		Vehiculo v = crearVehiculo("1234-ABC","1",123);
		Vehiculo v1 = crearVehiculo("1244-ABC","1",123);
		Vehiculo v2 = crearVehiculo("1334-ABC","1",123);
		Vehiculo v3 = crearVehiculo("2234-ABC","1",123);
		
		t.añadirVehiculo(v);
		t.añadirVehiculo(v1);
		t.añadirVehiculo(v2);
		t.añadirVehiculo(v3);
		
		t.mostrarVehiculos();
		
		try {
			t.buscarVehiculos("1264-ABC");
		} catch (IncorrectFormatException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	
	}
	
	public static Vehiculo crearVehiculo(String matricula, String modelo , int km) {
		Vehiculo v = null;
		
		
		try {
			v = new Vehiculo(matricula,modelo,km);
		} catch (IncorrectFormatException e) {
			System.out.println(e.getMessage());
		}
		
		return v;
	}

}
