package ejercicio4;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public class GestionLista implements ItemListener {

	private SeleccionadorPaises seleccionador;

	public GestionLista(SeleccionadorPaises seleccionador) {
		this.seleccionador = seleccionador;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int opcion = this.seleccionador.getCbPais().getSelectedIndex();
		seleccionador.getCbRegion().removeAllItems();
		
		
		switch (opcion) {
		case 0: {
			for(String region: seleccionador.getVacio()) {
				seleccionador.getCbRegion().addItem(region);
			}
			break;
		}
		case 1: {
			for(String region: seleccionador.getRegionesColombia()) {
				seleccionador.getCbRegion().addItem(region);
			}
			break;
		}
		case 2: {
			for(String region: seleccionador.getRegionesSpain()) {
				seleccionador.getCbRegion().addItem(region);
			}
			break;
		}
		case 3: {
			for(String region: seleccionador.getRegionesPortugal()) {
				seleccionador.getCbRegion().addItem(region);
			}
			break;
		}
		}
	}
}
