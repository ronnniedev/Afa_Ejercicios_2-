package ficheros;

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
		if(e.getSource() == this.v.getCkAcepto()) {
			if(this.v.getCkAcepto().isSelected()) {
				this.v.getBtContinuar().setEnabled(true);
			}else {
				this.v.getBtContinuar().setEnabled(false);
			}
		}else {
			JOptionPane.showMessageDialog(v, "ERROR EN CASILLA","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == v.getBtContinuar()) {
			System.exit(0);
		}else {
			JOptionPane.showMessageDialog(v, "ERROR EN CASILLA","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	

}
