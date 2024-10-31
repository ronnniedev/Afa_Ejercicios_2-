package ejercicioClase;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class GestorBotones implements ActionListener {

	private VentanaFicheros ventana;
	
	
	public GestorBotones(VentanaFicheros ventanaFicheros) {
		this.ventana = ventanaFicheros;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Button botonPulsado = (Button) e.getSource();
		String nombre = ventana.gettNombre().getText();
		String apellidos = ventana.gettApellidos().getText();
		
		if(botonPulsado == ventana.getbVentana()) {
			JOptionPane.showMessageDialog(ventana, "Hola " + nombre + " " + apellidos
					,"Goodbye",JOptionPane.INFORMATION_MESSAGE);
		}else if(botonPulsado == ventana.getbFichero()) {
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter("Resultado.txt",true));
				writer.write("***************************************\n");
				writer.write("Nombre: " + nombre+  "\n");
				writer.write("Apellidos: " + apellidos +  "\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					writer.close();
				} catch (IOException e1) {
					System.out.println("ERROR al cerrar");
				}
			}
		}
		
	}

}
