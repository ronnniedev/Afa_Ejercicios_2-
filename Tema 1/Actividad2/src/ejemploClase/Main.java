package ejemploClase;

public class Main {

	public static void main(String[] args) {
		
		Persona p1 = new Persona("xxx",123123123,'X');
		Persona p2 = new Persona("yyy",243243243,'B');
		Persona p3 = new Persona("zzz",345345345,'Z');
		
		
		Agenda agenda = new Agenda();
		agenda.addPersona(p1);
		agenda.addPersona(p2);
		agenda.addPersona(p3);
		
		
		Persona elementoBuscado=agenda.buscar(new Dni(123123123,'X'));
		
		if(elementoBuscado == null) {
			System.out.println("Persona no encontrada");
			
		}else {
			System.out.println(elementoBuscado.toString());
		}
	}

}
