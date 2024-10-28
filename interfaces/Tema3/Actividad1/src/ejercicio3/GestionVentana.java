package ejercicio3;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class GestionVentana implements WindowListener {
	
	private CalculadoraMejorada ventana;
	
	public GestionVentana(CalculadoraMejorada calc) {
		this.ventana = calc;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	// Este evento se genera cuando pulsamos el botón de cerrar
	@Override
	public void windowClosing(WindowEvent e) {
		//JOptionPane genera un cuadro de dialogo
		JOptionPane.showMessageDialog(ventana, "Adiós, pringao.", "Cerrar ventana", JOptionPane.WARNING_MESSAGE);
		System.exit(0);
		
	}

	//Evento cuando se cierra la ventana
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("CERRADO");
		
	}
	
	//Evento cuando se minimiza la ventana
	@Override
	public void windowIconified(WindowEvent e) {
		JOptionPane.showConfirmDialog(ventana, "Va a minimizarse la ventana", "MINIMIZAR", JOptionPane.OK_CANCEL_OPTION);
		
	}

	// Evento cuando volvemos a seleccionar la ventana minimizada en la barra de herramientas
	@Override
	public void windowDeiconified(WindowEvent e) {
		JOptionPane.showMessageDialog(ventana, "Va a maximizarse la ventana", "MAXIMIZAR", JOptionPane.INFORMATION_MESSAGE);
		
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
