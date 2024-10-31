package ejercicioClase;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VentanaFicheros extends Frame {
	
	private Button bVentana,bFichero;
	private TextField tNombre,tApellidos;
	private Label lNombre,lApellidos;
	
	

	public Button getbVentana() {
		return bVentana;
	}



	public Button getbFichero() {
		return bFichero;
	}



	public TextField gettNombre() {
		return tNombre;
	}



	public TextField gettApellidos() {
		return tApellidos;
	}



	public Label getlNombre() {
		return lNombre;
	}



	public Label getlApellidos() {
		return lApellidos;
	}



	public VentanaFicheros(String string) {
		super(string);
		this.setLayout(new GridLayout(3,2)); // y es el 3 y x es el 2
		this.setBounds(400, 100, 300, 200);
		
		// this.setSize(); se puede usar para meter el tamaño sin meter la posicion
		
		this.lNombre = new Label("Nombre: ");
		this.lApellidos = new Label("Apellidos: ");
		this.bVentana = new Button("Ventana");
		this.bFichero = new Button("Fichero");
		this.tNombre = new TextField("");
		this.tApellidos = new TextField("");
		
		this.add(lNombre);
		this.add(tNombre);
		this.add(lApellidos);
		this.add(tApellidos);
		this.add(bVentana);
		this.add(bFichero);
		
		this.addWindowListener(new GestorVentana(this));
		this.bVentana.addActionListener(new GestorBotones(this));
		this.bFichero.addActionListener(new GestorBotones(this));
	}

}