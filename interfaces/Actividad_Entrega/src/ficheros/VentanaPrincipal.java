package ficheros;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame{
	
	private JLabel lbOperacion,lbNotaUno,lbNotaDos,lbNotaTres,lbNotaCuatro,lbNotaCinco;
	private JLabel lbPromedio,lbDesviacion,lbNotaMayor,lbNotaMenor,lbResultado;
	private JLabel lbResulPromedio,lbResulDesviacion,lbResulNotaMayor,lbResulNotaMenor,lbResulResultado;
	private TextField tNotaUno,tNotaDos,tNotaTres,tNotaCuatro,tNotaCinco;
	private JButton bCalcular,bLimpiar;
	private JComboBox cOperacion;
	private String []operandos = {"+","-","*","/"};
	
	public VentanaPrincipal(String titulo){
		super();
		this.setLayout(new GridLayout(12,2));
		this.setBounds(400,100,450,600);
		
		inicializarComponentes();
		
		this.addWindowListener(new WindowsListener(this));
		bCalcular.addActionListener(new GestionAcciones(this));
		bLimpiar.addActionListener(new GestionAcciones(this));
	}

	


	public JLabel getLbOperacion() {
		return lbOperacion;
	}




	public void setLbOperacion(JLabel lbOperacion) {
		this.lbOperacion = lbOperacion;
	}


	public JLabel getLbNotaUno() {
		return lbNotaUno;
	}


	public void setLbNotaUno(JLabel lbNotaUno) {
		this.lbNotaUno = lbNotaUno;
	}


	public JLabel getLbNotaDos() {
		return lbNotaDos;
	}

	public void setLbNotaDos(JLabel lbNotaDos) {
		this.lbNotaDos = lbNotaDos;
	}

	public JLabel getLbNotaTres() {
		return lbNotaTres;
	}

	public void setLbNotaTres(JLabel lbNotaTres) {
		this.lbNotaTres = lbNotaTres;
	}
	
	public JLabel getLbNotaCuatro() {
		return lbNotaCuatro;
	}

	public void setLbNotaCuatro(JLabel lbNotaCuatro) {
		this.lbNotaCuatro = lbNotaCuatro;
	}
	
	public JLabel getLbNotaCinco() {
		return lbNotaCinco;
	}

	public void setLbNotaCinco(JLabel lbNotaCinco) {
		this.lbNotaCinco = lbNotaCinco;
	}

	public JLabel getLbPromedio() {
		return lbPromedio;
	}









	public void setLbPromedio(JLabel lbPromedio) {
		this.lbPromedio = lbPromedio;
	}









	public JLabel getLbDesviacion() {
		return lbDesviacion;
	}









	public void setLbDesviacion(JLabel lbDesviacion) {
		this.lbDesviacion = lbDesviacion;
	}









	public JLabel getLbNotaMayor() {
		return lbNotaMayor;
	}









	public void setLbNotaMayor(JLabel lbNotaMayor) {
		this.lbNotaMayor = lbNotaMayor;
	}









	public JLabel getLbNotaMenor() {
		return lbNotaMenor;
	}









	public void setLbNotaMenor(JLabel lbNotaMenor) {
		this.lbNotaMenor = lbNotaMenor;
	}









	public JLabel getLbResultado() {
		return lbResultado;
	}









	public void setLbResultado(JLabel lbResultado) {
		this.lbResultado = lbResultado;
	}









	public JLabel getLbResulPromedio() {
		return lbResulPromedio;
	}









	public void setLbResulPromedio(JLabel lbResulPromedio) {
		this.lbResulPromedio = lbResulPromedio;
	}









	public JLabel getLbResulDesviacion() {
		return lbResulDesviacion;
	}









	public void setLbResulDesviacion(JLabel lbResulDesviacion) {
		this.lbResulDesviacion = lbResulDesviacion;
	}









	public JLabel getLbResulNotaMayor() {
		return lbResulNotaMayor;
	}









	public void setLbResulNotaMayor(JLabel lbResulNotaMayor) {
		this.lbResulNotaMayor = lbResulNotaMayor;
	}









	public JLabel getLbResulNotaMenor() {
		return lbResulNotaMenor;
	}









	public void setLbResulNotaMenor(JLabel lbResulNotaMenor) {
		this.lbResulNotaMenor = lbResulNotaMenor;
	}









	public JLabel getLbResulResultado() {
		return lbResulResultado;
	}









	public void setLbResulResultado(JLabel lbResulResultado) {
		this.lbResulResultado = lbResulResultado;
	}









	public TextField gettNotaUno() {
		return tNotaUno;
	}









	public void settNotaUno(TextField tNotaUno) {
		this.tNotaUno = tNotaUno;
	}









	public TextField gettNotaDos() {
		return tNotaDos;
	}









	public void settNotaDos(TextField tNotaDos) {
		this.tNotaDos = tNotaDos;
	}









	public TextField gettNotaTres() {
		return tNotaTres;
	}









	public void settNotaTres(TextField tNotaTres) {
		this.tNotaTres = tNotaTres;
	}









	public TextField gettNotaCuatro() {
		return tNotaCuatro;
	}









	public void settNotaCuatro(TextField tNotaCuatro) {
		this.tNotaCuatro = tNotaCuatro;
	}









	public TextField gettNotaCinco() {
		return tNotaCinco;
	}









	public void settNotaCinco(TextField tNotaCinco) {
		this.tNotaCinco = tNotaCinco;
	}









	public JButton getbCalcular() {
		return bCalcular;
	}









	public void setbCalcular(JButton bCalcular) {
		this.bCalcular = bCalcular;
	}









	public JButton getbLimpiar() {
		return bLimpiar;
	}









	public void setbLimpiar(JButton bLimpiar) {
		this.bLimpiar = bLimpiar;
	}









	public JComboBox getcOperacion() {
		return cOperacion;
	}




	public void setcOperacion(JComboBox cOperacion) {
		this.cOperacion = cOperacion;
	}




	public String[] getOperandos() {
		return operandos;
	}




	public void setOperandos(String[] operandos) {
		this.operandos = operandos;
	}




	private void inicializarComponentes() {
		this.lbOperacion = new JLabel("Operacion");
		this.lbNotaUno = new JLabel("Nota 1: ");
		this.lbNotaDos= new JLabel("Nota 2: ");
		this.lbNotaTres = new JLabel("Nota 3: ");
		this.lbNotaCuatro = new JLabel("Nota 4: ");
		this.lbNotaCinco = new JLabel("Nota 5: ");
		this.lbPromedio = new JLabel("Promedio = ");
		this.lbDesviacion = new JLabel("Desviación = ");
		this.lbNotaMayor = new JLabel("Nota mayor = ");
		this.lbNotaMenor = new JLabel("Nota menor = ");
		this.lbResultado = new JLabel("Resultado = ");
		this.lbResulPromedio = new JLabel("");
		this.lbResulDesviacion = new JLabel("");
		this.lbResulNotaMayor = new JLabel("");
		this.lbResulNotaMenor = new JLabel("");
		this.lbResulResultado = new JLabel("");
		this.cOperacion = new JComboBox(operandos);
		this.tNotaUno = new TextField("");
		this.tNotaDos = new TextField("");
		this.tNotaTres = new TextField("");
		this.tNotaCuatro = new TextField("");
		this.tNotaCinco= new TextField("");
		this.bCalcular = new JButton("CALCULAR");
		this.bLimpiar = new JButton("LIMPIAR");
		
		this.add(lbOperacion);
		this.add(cOperacion);
		this.add(lbNotaUno);
		this.add(tNotaUno);
		this.add(lbNotaDos);
		this.add(tNotaDos);
		this.add(lbNotaTres);
		this.add(tNotaTres);
		this.add(lbNotaCuatro);
		this.add(tNotaCuatro);
		this.add(lbNotaCinco);
		this.add(tNotaCinco);
		this.add(bCalcular);
		this.add(bLimpiar);
		this.add(lbPromedio);
		this.add(lbResulPromedio);
		this.add(lbDesviacion);
		this.add(lbResulDesviacion);
		this.add(lbNotaMayor);
		this.add(lbResulNotaMayor);
		this.add(lbNotaMenor);
		this.add(lbResulNotaMenor);
		this.add(lbResultado);
		this.add(lbResulResultado);
		
		
	}



	
	

}
