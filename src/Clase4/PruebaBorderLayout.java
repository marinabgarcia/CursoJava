package Clase4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaBorderLayout {

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

		setLayout(new BorderLayout());
		JButton botonAmarillo = new JButton("Amarillo");
		JButton botonAzul = new JButton("Azul");
		JButton botonRojo = new JButton("Rojo");


		add(botonAmarillo,BorderLayout.SOUTH);
		add(botonAzul,BorderLayout.NORTH);
		add(botonRojo,BorderLayout.CENTER);

	}
}
