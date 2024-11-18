package ejemplo3;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class GestionVentana implements WindowListener{
	private EstadoDeAnimo ventanaActual;
	public GestionVentana(EstadoDeAnimo v) {
		this.ventanaActual = v;
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int opcion = JOptionPane.showConfirmDialog(ventanaActual, "¿Quieres cerrar la ventana?"
				,"cerrar aplicación",JOptionPane.OK_OPTION);
		if(opcion == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
