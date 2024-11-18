package ejercicio4;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JComboBox;


public class SeleccionadorPaises extends Frame {
	
	private Label lbTitulo,lbAprendiendo,lbPais,lbRegion;
	private JComboBox <String> cbPais,cbRegion;
	private String[] paises = {"Selecciono el pais","Colombia","España","Portugal"};
	private String[] regionesColombia = {"BuenaVentura","Meripopins","Rumanesco"};
	private String[] regionesSpain = {"Galicia","Asturias","Andalucia","Catalonia"};
	private String[] regionesPortugal = {"El bicho","Racismo","Me aburro","Perchero","Coches"};
	private String[] vacio = {"                         "};

	public SeleccionadorPaises(String titulo) {
		super(titulo);
		this.setLayout(new FlowLayout());
		this.setSize(200,200);
		inicializarComponentes(this);
	}
	
	

	public String[] getVacio() {
		return vacio;
	}



	public void setVacio(String[] vacio) {
		this.vacio = vacio;
	}



	public Label getLbTitulo() {
		return lbTitulo;
	}



	public void setLbTitulo(Label lbTitulo) {
		this.lbTitulo = lbTitulo;
	}



	public Label getLbAprendiendo() {
		return lbAprendiendo;
	}



	public void setLbAprendiendo(Label lbAprendiendo) {
		this.lbAprendiendo = lbAprendiendo;
	}



	public Label getLbPais() {
		return lbPais;
	}



	public void setLbPais(Label lbPais) {
		this.lbPais = lbPais;
	}



	public Label getLbRegion() {
		return lbRegion;
	}



	public void setLbRegion(Label lbRegion) {
		this.lbRegion = lbRegion;
	}



	public JComboBox<String> getCbPais() {
		return cbPais;
	}



	public void setCbPais(JComboBox<String> cbPais) {
		this.cbPais = cbPais;
	}



	public JComboBox<String> getCbRegion() {
		return cbRegion;
	}



	public void setCbRegion(JComboBox<String> cbRegion) {
		this.cbRegion = cbRegion;
	}



	public String[] getPaises() {
		return paises;
	}



	public void setPaises(String[] paises) {
		this.paises = paises;
	}



	public String[] getRegionesColombia() {
		return regionesColombia;
	}



	public void setRegionesColombia(String[] regionesColombia) {
		this.regionesColombia = regionesColombia;
	}



	public String[] getRegionesSpain() {
		return regionesSpain;
	}



	public void setRegionesSpain(String[] regionesSpain) {
		this.regionesSpain = regionesSpain;
	}



	public String[] getRegionesPortugal() {
		return regionesPortugal;
	}



	public void setRegionesPortugal(String[] regionesPortugal) {
		this.regionesPortugal = regionesPortugal;
	}



	private void inicializarComponentes(SeleccionadorPaises seleccionadorPaises) {
		this.lbTitulo = new Label("Selecciona pais y ciudad");
		this.lbAprendiendo = new Label("Aprendiendo con JComboBox");
		this.lbPais = new Label("Pais: ");
		this.lbRegion = new Label("Region: ");
		this.cbPais = new JComboBox(paises);
		this.cbRegion = new JComboBox(vacio);
		this.add(lbAprendiendo);
		this.add(lbTitulo);
		this.add(lbPais);
		this.add(cbPais);
		this.add(lbRegion);
		this.add(cbRegion);
		
		this.addWindowListener(new GestionVentana(this));
		this.cbPais.addItemListener(new GestionLista(this));
		
	}
	
	

}
