package InterfaceGrafico.muestras_de_posibles_soluciones.java.BarraDeProgreso.src.barraDeProgreso;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InterfazGraficoDeUsuario interfaz = new InterfazGraficoDeUsuario();
				interfaz.mostrarInterface();
			}
		});
	}

}
