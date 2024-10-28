package ejercicio3;

import java.awt.*;
import java.awt.event.ActionListener;


public class CalculadoraMejorada extends Frame {

	// atributos
	private Label lblTitulo, lblNumero1, lblNumero2, lblResultado;
	private TextField txtNumero1, txtNumero2, txtResultado;
	private Button btnSumar, btnRestar, btnMultiplicar, btnDividir;

	public CalculadoraMejorada(String titulo) {
		super(titulo);
		// posicionamos la ventana en la pantalla
		this.setLayout(null); // null = no tiene ningún gestor de geometría
		this.setBounds(400, 100, 500, 600);
		// creamos los componentes
		// etiquetas de texto
		this.lblTitulo = new Label("CALCULADORA MEJORADA");
		this.lblNumero1 = new Label("Número 1:");
		this.lblNumero2 = new Label("Número 2:");
		this.lblResultado = new Label("Resultado:");
		// campos de texto
		this.txtNumero1 = new TextField("0");
		this.txtNumero2 = new TextField("0");
		this.txtResultado = new TextField("0");
		// botones
		this.btnSumar = new Button("SUMAR");
		this.btnRestar = new Button("RESTAR");
		this.btnMultiplicar = new Button("MULTIPLICAR");
		this.btnDividir = new Button("DIVIDIR");
		// Añadimos componentes
		this.add(lblTitulo);
		this.add(lblNumero1);
		this.add(lblNumero2);
		this.add(lblResultado);
		this.add(txtNumero1);
		this.add(txtNumero2);
		this.add(txtResultado);
		this.add(btnSumar);
		this.add(btnRestar);
		this.add(btnMultiplicar);
		this.add(btnDividir);
		// Damos flow a la ventana
		this.setBackground(Color.GRAY);
		this.setFont(new Font("Cambria", Font.BOLD, 16));
		// Damos un poco de flow a los componentes
		this.lblTitulo.setForeground(Color.WHITE);
		this.lblNumero1.setForeground(Color.WHITE);
		this.lblNumero2.setForeground(Color.WHITE);
		this.lblResultado.setForeground(Color.WHITE);
		this.txtNumero1.setBackground(Color.lightGray);
		this.txtNumero2.setBackground(Color.lightGray);
		this.txtResultado.setBackground(Color.GREEN);
		// Posicionamos los componentes
		this.lblTitulo.setBounds(150, 50, 500, 30);
		this.lblNumero1.setBounds(50, 100, 100, 20);
		this.lblNumero2.setBounds(50, 150, 100, 20);
		this.txtNumero1.setBounds(170, 100, 100, 25);
		this.txtNumero2.setBounds(170, 150, 100, 25);
		this.btnSumar.setBounds(70, 250, 150, 50);
		this.btnRestar.setBounds(280, 250, 150, 50);
		this.btnMultiplicar.setBounds(70, 350, 150, 50);
		this.btnDividir.setBounds(280, 350, 150, 50);
		this.lblResultado.setBounds(50, 450, 100, 25);
		this.txtResultado.setBounds(170, 450, 100, 25);
		
		//Añadimos listener a la ventana
		this.addWindowListener(new GestionVentana(this));
		//Añadimos listener a los botones
		this.btnSumar.addActionListener(new GestionBotones(this));
		this.btnRestar.addActionListener(new GestionBotones(this));
		this.btnMultiplicar.addActionListener(new GestionBotones(this));
		this.btnDividir.addActionListener(new GestionBotones(this));

	}

	public Label getLblTitulo() {
		return lblTitulo;
	}

	public Label getLblNumero1() {
		return lblNumero1;
	}

	public Label getLblNumero2() {
		return lblNumero2;
	}

	public Label getLblResultado() {
		return lblResultado;
	}

	public TextField getTxtNumero1() {
		return txtNumero1;
	}

	public TextField getTxtNumero2() {
		return txtNumero2;
	}

	public TextField getTxtResultado() {
		return txtResultado;
	}

	public Button getBtnSumar() {
		return btnSumar;
	}

	public Button getBtnRestar() {
		return btnRestar;
	}

	public Button getBtnMultiplicar() {
		return btnMultiplicar;
	}

	public Button getBtnDividir() {
		return btnDividir;
	}
	
	

}
