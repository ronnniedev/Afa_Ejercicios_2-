package ejercicio3;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionBotones implements ActionListener {

	CalculadoraMejorada calculadora;
	
	public GestionBotones(CalculadoraMejorada calculadora) {
		this.calculadora = calculadora;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Double numero1, numero2, resultado = 0.0;
		Button botonPulsado = (Button) e.getSource();
		
		numero1 = Double.parseDouble(calculadora.getTxtNumero1().getText());
		numero2 = Double.parseDouble(calculadora.getTxtNumero2().getText());
		if (botonPulsado == calculadora.getBtnSumar()) {
			resultado = numero1 + numero2;
		}
		else if (botonPulsado == calculadora.getBtnRestar()) {
			resultado = numero1 - numero2;
		}
		else if (botonPulsado == calculadora.getBtnMultiplicar()) {
			resultado = numero1 * numero2;
		}
		else if (botonPulsado == calculadora.getBtnDividir() && numero2 != 0) {
			resultado = numero1 / numero2;
		}
		calculadora.getTxtResultado().setText("" + resultado);
		
	}
}
