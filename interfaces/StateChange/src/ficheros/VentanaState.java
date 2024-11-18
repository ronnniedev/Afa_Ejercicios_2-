package ficheros;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaState extends JFrame{
	
	private JLabel lbTitulo;
	private JCheckBox ckAcepto;
	private JButton btContinuar;

	public VentanaState(String titulo) {
		super(titulo);
		this.setLayout(null);
		this.setBounds(300,100,350,200);
		this.lbTitulo = new JLabel("¿Estas de acuerdo con la normativa?");
		this.ckAcepto = new JCheckBox("Acepto");
		this.btContinuar = new JButton("Continuar");
		
		this.add(lbTitulo);
		this.lbTitulo.setBounds(10,10,300,30);
		this.add(ckAcepto);
		this.ckAcepto.setBounds(10,60,100,30);
		this.add(btContinuar);
		this.btContinuar.setBounds(10,100,100,30);
		this.btContinuar.setEnabled(false);
		
		this.ckAcepto.addChangeListener(new GestionEventos(this));
		this.btContinuar.addActionListener(new GestionEventos(this));
		
	}

	public JLabel getLbTitulo() {
		return lbTitulo;
	}

	public void setLbTitulo(JLabel lbTitulo) {
		this.lbTitulo = lbTitulo;
	}

	public JCheckBox getCkAcepto() {
		return ckAcepto;
	}

	public void setCkAcepto(JCheckBox ckAcepto) {
		this.ckAcepto = ckAcepto;
	}

	public JButton getBtContinuar() {
		return btContinuar;
	}

	public void setBtContinuar(JButton btContinuar) {
		this.btContinuar = btContinuar;
	}
	
	

}
