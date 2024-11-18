package stateChangeComplejo;

import java.awt.Frame;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class VentanaState extends JFrame{
	
	private JLabel lbTitulo;
	private JRadioButton rdAceptar,rdNoAceptar;
	private ButtonGroup gbPrincipal;
	private JButton btContinuar;

	public VentanaState(String titulo) {
		super(titulo);
		this.setLayout(null);
		this.setBounds(300,100,350,200);
		this.lbTitulo = new JLabel("¿Estas de acuerdo con la normativa?");
		this.rdAceptar = new JRadioButton("Acepto");
		this.rdNoAceptar = new JRadioButton("No acepto");
		this.btContinuar = new JButton("Continuar");
		this.gbPrincipal = new ButtonGroup();
		
		this.add(lbTitulo);
		this.lbTitulo.setBounds(10,10,300,30);
		this.add(rdAceptar);
		this.rdAceptar.setBounds(10,60,100,30);
		this.add(rdNoAceptar);
		this.rdNoAceptar.setBounds(10,90,100,30);
		this.add(btContinuar);
		this.btContinuar.setBounds(10,130,100,30);
		this.btContinuar.setEnabled(false);
		
		this.rdAceptar.addChangeListener(new GestionEventos(this));
		this.rdNoAceptar.addChangeListener(new GestionEventos(this));
		this.btContinuar.addActionListener(new GestionEventos(this));
		
	}

	public JLabel getLbTitulo() {
		return lbTitulo;
	}

	public void setLbTitulo(JLabel lbTitulo) {
		this.lbTitulo = lbTitulo;
	}



	public JRadioButton getRdAceptar() {
		return rdAceptar;
	}

	public void setRdAceptar(JRadioButton rdAceptar) {
		this.rdAceptar = rdAceptar;
	}

	public JRadioButton getRdNoAceptar() {
		return rdNoAceptar;
	}

	public void setRdNoAceptar(JRadioButton rdNoAceptar) {
		this.rdNoAceptar = rdNoAceptar;
	}

	public JButton getBtContinuar() {
		return btContinuar;
	}

	public void setBtContinuar(JButton btContinuar) {
		this.btContinuar = btContinuar;
	}
	
	

}
