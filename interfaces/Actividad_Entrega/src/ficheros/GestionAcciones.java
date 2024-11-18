package ficheros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionAcciones implements ActionListener {
	
	private VentanaPrincipal ventanaPrincipal;
	
	public GestionAcciones(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double []notas = recogerNotas();
	
		if(e.getSource() == ventanaPrincipal.getbCalcular()) {
			calcularResultado(notas);
			calcularPromedio(notas);
			calcularDesviacion(notas);
			calcularNotaMayor(notas);
			calcularNotaMenor(notas);
		}else if(e.getSource() == ventanaPrincipal.getbLimpiar()) {
			limpiarTextos();
		}
		
	}

	private void limpiarTextos() {
		
		ventanaPrincipal.gettNotaUno().setText("");
		ventanaPrincipal.gettNotaDos().setText("");
		ventanaPrincipal.gettNotaTres().setText("");
		ventanaPrincipal.gettNotaCuatro().setText("");
		ventanaPrincipal.gettNotaCinco().setText("");
		ventanaPrincipal.getLbResulPromedio().setText("");
		ventanaPrincipal.getLbResulDesviacion().setText("");
		ventanaPrincipal.getLbResulNotaMayor().setText("");
		ventanaPrincipal.getLbResulNotaMenor().setText("");
		ventanaPrincipal.getLbResulResultado().setText("");
		
	}

	private void calcularResultado(double[] notas) {
		int opcion = this.ventanaPrincipal.getcOperacion().getSelectedIndex();
		double resultado = 0;
		switch (opcion) {
		case 0: {
			for(Double nota: notas) {
				resultado += nota;
			}
			ventanaPrincipal.getLbResulResultado().setText("" + resultado);
			break;
		}
		case 1: {
			resultado = notas[0] - notas [1];
			ventanaPrincipal.getLbResulResultado().setText("" + resultado);
			break;
		}
		case 2: {
			resultado = 1;
			for(Double nota: notas) {
				resultado *= nota;
			}
			ventanaPrincipal.getLbResulResultado().setText("" + resultado);
			break;
		}
		case 3: {
			resultado = notas[0] / notas [1];
			ventanaPrincipal.getLbResulResultado().setText("" + resultado);
			break;
		}
		}
		
	}

	private void calcularNotaMenor(double[] notas) {
		double pivote = Double.MAX_VALUE;
		
		for(double nota: notas) {
			if(pivote > nota) {
				pivote = nota;
			}
		}
		ventanaPrincipal.getLbResulNotaMenor().setText("" + pivote);
	}

	private void calcularDesviacion(double[] notas) {
        double suma = 0.0;
        
        for (double num : notas) {
            suma += num;
        }
        
        double media = suma / notas.length;

        double sumaDiferenciasCuadradas = 0.0;
        for (double num : notas) {
            sumaDiferenciasCuadradas += Math.pow(num - media, 2);
        }

        double desviacion = Math.sqrt(sumaDiferenciasCuadradas / notas.length);
	    ventanaPrincipal.getLbResulDesviacion().setText("" + desviacion);
	}

	private void calcularNotaMayor(double[] notas) {
		double pivote = Double.MIN_VALUE;
		
		for(double nota: notas) {
			if(pivote < nota) {
				pivote = nota;
			}
		}
		ventanaPrincipal.getLbResulNotaMayor().setText("" + pivote);
	}

	private void calcularPromedio(double[] notas) {
		double resultado = 0;
		
		for(double nota:notas) {
			resultado += nota;
		}
		ventanaPrincipal.getLbResulPromedio().setText("" + resultado/5);
		
	}

	private double[] recogerNotas() {
		double numUno =Double.parseDouble(ventanaPrincipal.gettNotaUno().getText());
		double numDos =Double.parseDouble(ventanaPrincipal.gettNotaDos().getText());
		double numTres =Double.parseDouble(ventanaPrincipal.gettNotaTres().getText());
		double numCuatro =Double.parseDouble(ventanaPrincipal.gettNotaCuatro().getText());
		double numCinco =Double.parseDouble(ventanaPrincipal.gettNotaCinco().getText());
		
		double numeros[] = {numUno,numDos,numTres,numCuatro,numCinco};
		
		return numeros;
	}

}
