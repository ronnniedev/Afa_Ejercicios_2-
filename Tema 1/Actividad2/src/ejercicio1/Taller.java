package ejercicio1;

import java.util.HashMap;
import java.util.Map;

public class Taller {
	
	private Map <Matricula,Vehiculo> vehiculos;

	public Taller() {
		this.vehiculos = new HashMap<Matricula,Vehiculo>();
	}
	
	public void añadirVehiculo(Vehiculo v) {
		if(vehiculos.containsKey(v.getMatricula())) {
			System.out.println("Vehiculo ya en lista");
			
		}else {
			vehiculos.put(v.getMatricula(), v);
			System.out.println("Vehiculo añadido");
		}
		
	}
	
	public void mostrarVehiculos() {
		System.out.println("-----Vehiculos en taller-----");
		
		for(Vehiculo v: vehiculos.values()) {
			System.out.println(v.toString());
			
		}
		
	}
	
	public void buscarVehiculos(String matricula) throws IncorrectFormatException {
		Matricula m = new Matricula(matricula);
		
		System.out.println("----Busqueda de vehiculos----");
		if(vehiculos.containsKey(m)) {
			Vehiculo v = vehiculos.get(m);
			System.out.println(v.toString());
			
		}else {
			System.out.println("Vehiculo no encontrado");
			
		}
		
	}

}
