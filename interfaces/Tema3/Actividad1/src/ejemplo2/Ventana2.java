package ejemplo2;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class Ventana2 extends Frame{
	// componente -> propiedades 
	
	// constructor con super
	
	private Label lnombre;
	private TextField tnombre;
	private Button bAceptar;
	
	public Ventana2(String titulo) {
		super(titulo);
		
		this.setVisible(true);
		// creo los componentes 
		lnombre = new Label ("Nombre Empleado");
		tnombre = new TextField(30);
		bAceptar = new Button ("ACEPTAR");
		
		
		//anadir componentes
		this.add(bAceptar);
		this.add(tnombre);
		this.add(lnombre);
		
		//posicionarlos
		
		this.lnombre.setBounds(100, 100, 200, 30);
		this.tnombre.setBounds(100, 200, 100, 27);
		this.bAceptar.setBounds(100, 250, 100, 27);
		this.setBounds(300,400,300,200);
	}
	

}
