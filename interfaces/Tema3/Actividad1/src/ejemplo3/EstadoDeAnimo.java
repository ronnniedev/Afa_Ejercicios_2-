package ejemplo3;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JComboBox;

import ejercicio3.GestionLista;

public class EstadoDeAnimo extends Frame{

	private Label lbColor, lbNuevoColor,lbEstadoDeAnimo;
	private TextField tNuevoColor,tEstadoDeAnimo;
	private Button bAgregar;
	private JComboBox <String>cbColor;
	private String[] colores = {"AZUL","ROJO","VERDE"};
	
	
	public EstadoDeAnimo(String titulo) {
		super(titulo);
		this.setLayout(new FlowLayout());
		this.setSize(180,250);
		inicializarComponentes(this);
	}
	
	
	
	public String[] getColores() {
		return colores;
	}



	public void setColores(String[] colores) {
		this.colores = colores;
	}

	


	public Button getbAgregar() {
		return bAgregar;
	}



	public void setbAgregar(Button bAgregar) {
		this.bAgregar = bAgregar;
	}
	
	



	public Label getLbColor() {
		return lbColor;
	}



	public void setLbColor(Label lbColor) {
		this.lbColor = lbColor;
	}



	public Label getLbNuevoColor() {
		return lbNuevoColor;
	}



	public void setLbNuevoColor(Label lbNuevoColor) {
		this.lbNuevoColor = lbNuevoColor;
	}



	public Label getLbEstadoDeAnimo() {
		return lbEstadoDeAnimo;
	}



	public void setLbEstadoDeAnimo(Label lbEstadoDeAnimo) {
		this.lbEstadoDeAnimo = lbEstadoDeAnimo;
	}



	public TextField gettEstadoDeAnimo() {
		return tEstadoDeAnimo;
	}



	public void settEstadoDeAnimo(TextField tEstadoDeAnimo) {
		this.tEstadoDeAnimo = tEstadoDeAnimo;
	}



	public JComboBox getCbColor() {
		return cbColor;
	}



	public void setCbColor(JComboBox cbColor) {
		this.cbColor = cbColor;
	}



	public TextField gettNuevoColor() {
		return tNuevoColor;
	}



	public void settNuevoColor(TextField tNuevoColor) {
		this.tNuevoColor = tNuevoColor;
	}



	public void inicializarComponentes(Frame ventana) {
		this.lbColor = new Label("Color");
		this.lbNuevoColor = new Label("Nuevo color: ");
		this.lbEstadoDeAnimo = new Label ("Estado animico: ");
		this.tNuevoColor = new TextField(10);
		this.tEstadoDeAnimo = new TextField("Gordo",20);
		this.tEstadoDeAnimo.setForeground(Color.cyan);
		this.bAgregar = new Button("AGREGAR");
		this.cbColor= new JComboBox(colores);
		this.add(lbColor);
		this.add(cbColor);
		this.add(lbNuevoColor);
		this.add(tNuevoColor);
		this.add(bAgregar);
		this.add(lbEstadoDeAnimo);
		this.add(tEstadoDeAnimo);
		
		this.addWindowListener(new GestionVentana(this));
		this.bAgregar.addActionListener(new GestionBotones(this));
		this.cbColor.addItemListener(new GestionLista(this));
		
	}
}
