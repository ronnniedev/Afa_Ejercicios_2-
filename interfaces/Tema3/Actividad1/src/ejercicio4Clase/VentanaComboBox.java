package ejercicio4Clase;

import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaComboBox extends JFrame{
	
	
	private JLabel lTitulo,lTituloCombo1,lTituloCombo2;
	private JComboBox cPais,cCiudad;
	private JPanel panel1;
	private String []pais = {"Seleccione Pais", "España", "Francia" , "Alemania"};
	private String [] espania = {"Barcelona","Madrid","Oviedo"};
	private String [] francia = {"Lion","Paris","Tolouse"};
	private String [] alemania = {"Berlin","Munich","Colonia"};
	
	
	public VentanaComboBox(String titulo){
		super(titulo);
		this.setLayout(null);
		this.setBounds(100,100,412,213);
		incializarComponentes();
		cPais.addActionListener(new GestionCombo(this));
		cCiudad.addActionListener(new GestionCombo(this));
	}
	
	

	public JLabel getlTitulo() {
		return lTitulo;
	}



	public void setlTitulo(JLabel lTitulo) {
		this.lTitulo = lTitulo;
	}



	public JLabel getlTituloCombo1() {
		return lTituloCombo1;
	}



	public void setlTituloCombo1(JLabel lTituloCombo1) {
		this.lTituloCombo1 = lTituloCombo1;
	}



	public JLabel getlTituloCombo2() {
		return lTituloCombo2;
	}



	public void setlTituloCombo2(JLabel lTituloCombo2) {
		this.lTituloCombo2 = lTituloCombo2;
	}



	public JComboBox getcPais() {
		return cPais;
	}



	public void setcPais(JComboBox cPais) {
		this.cPais = cPais;
	}



	public JComboBox getcCiudad() {
		return cCiudad;
	}



	public void setcCiudad(JComboBox cCiudad) {
		this.cCiudad = cCiudad;
	}



	public JPanel getPanel1() {
		return panel1;
	}



	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}



	public String[] getPais() {
		return pais;
	}



	public void setPais(String[] pais) {
		this.pais = pais;
	}



	public String[] getEspania() {
		return espania;
	}



	public void setEspania(String[] espania) {
		this.espania = espania;
	}



	public String[] getFrancia() {
		return francia;
	}



	public void setFrancia(String[] francia) {
		this.francia = francia;
	}



	public String[] getAlemania() {
		return alemania;
	}



	public void setAlemania(String[] alemania) {
		this.alemania = alemania;
	}



	private void incializarComponentes() {
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(10,50,375,110);
		panel1.setBorder(BorderFactory.createTitledBorder("America-Sur"));
		lTitulo = new JLabel("SELECCIONE PAIS Y CIUDAD");
		lTitulo.setBounds(120,20,170,20);
		lTituloCombo1 = new JLabel("Pais");
		lTituloCombo2 = new JLabel("Ciudad");
		cPais = new JComboBox(pais);
		cPais.setSelectedIndex(0);
		cCiudad = new JComboBox();
		cCiudad.setEnabled(false);
		
		lTituloCombo1.setBounds(30,30,50,20);
		lTituloCombo2.setBounds(30,70,60,20);
		cPais.setBounds(100,30,150,24);
		
		this.add(lTitulo);
		this.add(panel1);
		
		//agregamos en el panel
		panel1.add(cPais);
		panel1.add(lTituloCombo1);
		panel1.add(lTituloCombo2);
		panel1.add(cCiudad);
		cCiudad.setBounds(100,70,150,24);
		
		
		
	}
	
	
	

}
