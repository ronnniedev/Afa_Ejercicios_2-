package ejercicio2;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VentanaCalculadoraB extends Frame 
implements WindowListener,ActionListener{
	
	private Label lTitulo,lNumeroUno,lNumeroDos,lResultado;
	private TextField tNumeroUno,tNumeroDos,tResultado;
	private Button bMultiplicar,bRestar,bSumar,bDividir;
	
	public VentanaCalculadoraB(String titulo) {
		super(titulo);
		this.setBounds(100,100,500,400);
		this.setLayout(null);
		this.setBackground(Color.GRAY);
		this.setFont(new Font("Times New Roman",Font.BOLD,15));
		this.setForeground(Color.WHITE);
		
		// crear componentes
		lTitulo = new Label(titulo);
		
		lTitulo.setFont(new Font("Times New Roman",Font.BOLD,30));
		lNumeroUno = new Label("Numero1");
		lNumeroDos = new Label("Numero2");
		lResultado = new Label("Resultado");
		tNumeroUno = new TextField();
		tNumeroDos= new TextField();
		tResultado = new TextField("NA");
		tResultado.setForeground(Color.BLACK);
		tNumeroUno.setBackground(Color.WHITE);
		tNumeroDos.setBackground(Color.WHITE);
		tNumeroUno.setForeground(Color.BLACK);
		tNumeroDos.setForeground(Color.BLACK);
		tResultado.setBackground(Color.WHITE);
		bSumar = new Button("SUMAR");
		bSumar.setForeground(Color.BLACK);
		
		bRestar = new Button("RESTAR");
		bDividir = new Button("DIVIDIR");
		bMultiplicar = new Button("MULTIPLICAR");
		bRestar.setForeground(Color.BLACK);
		bDividir.setForeground(Color.BLACK);
		bMultiplicar.setForeground(Color.BLACK);
		
		// añadir componentes
		this.add(lTitulo);
		this.add(lNumeroUno);
		this.add(lNumeroDos);
		this.add(lResultado);
		this.add(tNumeroUno);
		this.add(tNumeroDos);
		this.add(tResultado);
		this.add(tNumeroUno);
		this.add(tNumeroDos);
		this.add(tResultado);
		this.add(bSumar);
		this.add(bRestar);
		this.add(bDividir);
		this.add(bMultiplicar);
		
		// posicionar componentes
		lTitulo.setBounds(100,50,300,30);
		lNumeroUno.setBounds(50,150,100,50);
		lNumeroDos.setBounds(50,200,100,50);
		tNumeroUno.setBounds(150,160,150,30);
		tNumeroDos.setBounds(150,210,150,30);
		tResultado.setBounds(250,360,200,30);
		tResultado.setEnabled(false);
		lResultado.setBounds(120,360,100,30);
		bSumar.setBounds(0, 250, 250, 50);
		bRestar.setBounds(250, 250, 250, 50);
		bMultiplicar.setBounds(0, 300, 250, 50);
		bDividir.setBounds(250, 300, 250, 50);
		
		this.addWindowListener(this);
		bSumar.addActionListener(this);
		bRestar.addActionListener(this);
		bDividir.addActionListener(this);
		bMultiplicar.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button botonPulsado = (Button) e.getSource();
		Double numeroUno = Double.parseDouble(tNumeroUno.getText());
		Double numeroDos = Double.parseDouble(tNumeroDos.getText());
		
		if(botonPulsado==bSumar) {
			tResultado.setText("" +(numeroUno+numeroDos));
		}
		if(botonPulsado==bRestar) {
			tResultado.setText("" +(numeroUno-numeroDos));
		}
		if(botonPulsado==bDividir) {
			tResultado.setText("" +(numeroUno/numeroDos));
		}
		if(botonPulsado==bMultiplicar) {
			tResultado.setText("" +(numeroUno*numeroDos));
		}
		
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
