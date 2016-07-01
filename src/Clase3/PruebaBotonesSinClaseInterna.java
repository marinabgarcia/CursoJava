package Clase3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Clase3.LaminaBotones.AccionColor;

public class PruebaBotonesSinClaseInterna {

	public static void main(String[] args) {
		MarcoBotonesSCI marco = new MarcoBotonesSCI();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoBotonesSCI extends JFrame {
	public MarcoBotonesSCI() {
		setSize(300, 200);
		setTitle("Prueba botones");

		LaminaBotonesSCI lamina = new LaminaBotonesSCI();
		add(lamina);
	}
}

class LaminaBotonesSCI extends JPanel implements ActionListener {

	private JButton botonAmarillo;
	private JButton botonAzul;
	private JButton botonRojo;

	public LaminaBotonesSCI() {
		botonAmarillo = new JButton("Amarillo");
		botonAzul = new JButton("Azul");
		botonRojo = new JButton("Rojo");

		botonAmarillo.addActionListener(this);
		botonAzul.addActionListener(this);
		botonRojo.addActionListener(this);

		add(botonAmarillo);
		add(botonAzul);
		add(botonRojo);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// averiguo origen del evento
		Object origen = e.getSource();
		// se especifica el color de fondo de la lamina
		if (origen == botonAmarillo)
			setBackground(Color.YELLOW);
		else if (origen == botonAzul)
			setBackground(Color.BLUE);
		else if (origen == botonRojo)
			setBackground(Color.RED);
	}
}
