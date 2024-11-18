package ejemplo3;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionBotones implements ActionListener{
	
	private EstadoDeAnimo estadoDeAnimo;

	public GestionBotones(EstadoDeAnimo estadoDeAnimo) {
		this.estadoDeAnimo = estadoDeAnimo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Button botonPulsado = (Button) e.getSource();
		
		if (botonPulsado == estadoDeAnimo.getbAgregar()) {
			String nuevoColor = estadoDeAnimo.gettNuevoColor().getText();
			estadoDeAnimo.getCbColor().addItem(nuevoColor);
			
		}
		
	}

}
