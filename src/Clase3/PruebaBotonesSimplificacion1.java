package Clase3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaBotonesSimplificacion1 {

	public static void main(String[] args) {
		MarcoBotonesS1 marco = new MarcoBotonesS1();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoBotonesS1 extends JFrame {
	public MarcoBotonesS1() {
		setSize(300, 200);
		setTitle("Prueba botones");

		LaminaBotonesS1 lamina = new LaminaBotonesS1();
		add(lamina);
	}
}

class LaminaBotonesS1 extends JPanel {
	
	class AccionColor implements ActionListener {
		private Color colorDeFondo;

		public AccionColor(Color c) {
			colorDeFondo = c;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// se especifica el color de fondo de la lamina
			setBackground(colorDeFondo);

		}
	}

	public LaminaBotonesS1() {
		hacerBoton("Amarillo", Color.YELLOW);
		hacerBoton("Azul", Color.BLUE);
		hacerBoton("Rojo", Color.RED);
	}

	void hacerBoton(String nombre, Color colorDeFondo) {
		JButton boton = new JButton(nombre);
		add(boton);
		AccionColor accion = new AccionColor(colorDeFondo);
		boton.addActionListener(accion);

	}
}
