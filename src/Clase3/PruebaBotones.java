package Clase3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaBotones {

	public static void main(String[] args) {
		MarcoBotones marco = new MarcoBotones();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoBotones extends JFrame {
	public MarcoBotones() {
		setSize(300, 200);
		setTitle("Prueba botones");

		LaminaBotones lamina = new LaminaBotones();
		add(lamina);
	}
}

class LaminaBotones extends JPanel {

	public LaminaBotones() {

		JButton botonAmarillo = new JButton("Amarillo");
		JButton botonAzul = new JButton("Azul");
		JButton botonRojo = new JButton("Rojo");

		AccionColor accionAmarillo = new AccionColor(Color.YELLOW);
		AccionColor accionAzul = new AccionColor(Color.BLUE);
		AccionColor accionRojo = new AccionColor(Color.RED);
		botonAmarillo.addActionListener(accionAmarillo);
		botonAzul.addActionListener(accionAzul);
		botonRojo.addActionListener(accionRojo);

		add(botonAmarillo);
		add(botonAzul);
		add(botonRojo);

	}
	
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

}


