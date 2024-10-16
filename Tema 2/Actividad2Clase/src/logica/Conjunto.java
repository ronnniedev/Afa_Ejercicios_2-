package logica;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Conjunto {
	private Set<Restaurante> conjunto;
	
	public Conjunto() {
		conjunto = new HashSet<Restaurante>();
		
	}
	
	public void addRestaurante(Restaurante r) {
		conjunto.add(r);
	}
	
	

	public Set<Restaurante> getConjunto() {
		return conjunto;
	}

	public void setConjunto(Set<Restaurante> conjunto) {
		this.conjunto = conjunto;
	}

	public List<Restaurante> ejer2() {
		List <Restaurante> lista = new LinkedList<Restaurante>();
		
		for(Restaurante r: this.conjunto) {
			
			if(r.getCp().startsWith("6")){
				lista.add(r);
				
			}
		}
		return lista;
	}

	
	 
}
