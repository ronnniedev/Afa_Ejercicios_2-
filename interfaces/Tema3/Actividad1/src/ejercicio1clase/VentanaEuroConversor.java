package ejercicio1clase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VentanaEuroConversor extends Frame 
implements WindowListener,ActionListener{
	// declaramos los componentes
	private Label ltitulo,lcantidad;
	private Button bEuros,bPts;
	private TextField tCantidad;
	

	public VentanaEuroConversor() {
		super("Ejemplo Euroconversor");
		// creamos y diseñamos la ventana
		this.setBounds(100, 100, 600, 500);
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		
		// crear componentes
		ltitulo = new Label("EuroConversor euro/pts");
		ltitulo.setForeground(Color.BLUE); // cambiar color de letra
		ltitulo.setFont(new Font("Times New Roman",Font.BOLD,30));
		lcantidad = new Label("CANTIDAD");
		tCantidad = new TextField();
		bEuros = new Button("A euros");
		bPts = new Button("A pesetas");
		
		//añadir componentes 
		this.add(ltitulo);
		this.add(lcantidad);
		this.add(tCantidad);
		this.add(bEuros);
		this.add(bPts);
		
		
		ltitulo.setBounds(150,50,500,30);
		lcantidad.setBounds(100,200,200,20);
		tCantidad.setBounds(300,200,350,20);
		bEuros.setBounds(100,300,200, 40);
		bPts.setBounds(400, 300, 200, 40);
		
		this.addWindowListener(this);
		bEuros.addActionListener(this);
		bPts.addActionListener(this);
		
		
		
	}



	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
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



	@Override
	public void actionPerformed(ActionEvent e) {
		Button botonPulsado = (Button) e.getSource();
		double cantidad;
		double total = 0;
		cantidad = Double.parseDouble(tCantidad.getText());
		
		
		if(botonPulsado==bEuros) {
			total = cantidad/166.386;
		}else if(botonPulsado==bPts) {
			total = cantidad*166.386;
		}
		
		tCantidad.setText(Double.toString(total));
	}
}
