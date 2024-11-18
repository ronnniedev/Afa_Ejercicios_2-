package ejercicio3;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import ejemplo3.EstadoDeAnimo;

public class GestionLista implements ItemListener{

	EstadoDeAnimo estadoDeAnimo;
	
	

	public GestionLista(EstadoDeAnimo estadoDeAnimo) {
		this.estadoDeAnimo = estadoDeAnimo;
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
	
		int opcion = this.estadoDeAnimo.getCbColor().getSelectedIndex();
		
		switch (opcion) {
		case 0:{
			estadoDeAnimo.gettEstadoDeAnimo().setText("Gordo");
			estadoDeAnimo.gettEstadoDeAnimo().setForeground(Color.cyan);
			break;
		}
		case 1:{
			estadoDeAnimo.gettEstadoDeAnimo().setText("Mariconchi");
			estadoDeAnimo.gettEstadoDeAnimo().setForeground(Color.BLUE);
			break;
		}case 2:{
			estadoDeAnimo.gettEstadoDeAnimo().setText("Rimbombante");
			estadoDeAnimo.gettEstadoDeAnimo().setForeground(Color.red);
			break;
		}
		}
		
	}
	
	
}
