package ejercicio4Clase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionCombo implements ActionListener{
	
	private VentanaComboBox vp;

	public GestionCombo(VentanaComboBox vp) {
		this.vp = vp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vp.getcCiudad().setEnabled(true);
		
		
		if(e.getSource() == vp.getcPais()) {
			if(vp.getcPais().getSelectedIndex() == 1) {
				vp.getcCiudad().removeAllItems();
				for(int i = 0; i <vp.getEspania().length;i++) {
					vp.getcCiudad().addItem(vp.getEspania()[i]);
				}
			}else if(vp.getcPais().getSelectedIndex() == 2) {
				vp.getcCiudad().removeAllItems();
				for(int i = 0; i <vp.getEspania().length;i++) {
					vp.getcCiudad().addItem(vp.getFrancia()[i]);
				}
			}else if(vp.getcPais().getSelectedIndex() == 3) {
				vp.getcCiudad().removeAllItems();
				for(int i = 0; i <vp.getEspania().length;i++) {
					vp.getcCiudad().addItem(vp.getAlemania()[i]);
				}
			}else if(vp.getcPais().getSelectedIndex() == 0) {
				vp.getcCiudad().removeAllItems();
				vp.getcCiudad().setEnabled(false);
				vp.setTitle("Ventanita");
			}
		}else if(e.getSource() == vp.getcCiudad()) {
			try {
				vp.setTitle(vp.getcCiudad().getSelectedItem().toString());
			}catch(Exception exc){
				vp.setTitle("Ventanita");
			}
		}
	}
	
	
	

}
