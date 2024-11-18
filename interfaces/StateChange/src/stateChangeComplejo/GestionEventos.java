package stateChangeComplejo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GestionEventos implements ChangeListener,ActionListener{
	
	VentanaState v;
	
	public GestionEventos(VentanaState v) {
		this.v = v;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() == this.v.getRdAceptar()) {
			if(this.v.getRdAceptar().isSelected()) {
				if(this.v.getRdNoAceptar().isSelected()) {
					v.getRdNoAceptar().setSelected(false);
				}
				this.v.getBtContinuar().setEnabled(true);
			}
		}else if(e.getSource() == this.v.getRdNoAceptar()) {
			if(this.v.getRdNoAceptar().isSelected()){
				if(this.v.getRdAceptar().isSelected()) {
					v.getRdAceptar().setSelected(false);
				}
				this.v.getBtContinuar().setEnabled(false);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == v.getBtContinuar()) {
			System.exit(0);
		}
		
	}
	
	

}
