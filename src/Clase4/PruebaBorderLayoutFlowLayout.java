package Clase4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaBorderLayoutFlowLayout {

	public static void main(String[] args) {
		MarcoBotones2 marco = new MarcoBotones2();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoBotones2 extends JFrame {
	public MarcoBotones2() {
		setSize(300, 200);
		setTitle("Prueba botones");

		LaminaBotones2 lamina = new LaminaBotones2();
		add(lamina);
	}
}

class LaminaBotones2 extends JPanel {

	public LaminaBotones2() {

		setLayout(new BorderLayout());
		JButton botonAmarillo = new JButton("Amarillo");
		JButton botonAzul = new JButton("Azul");
		JButton botonRojo = new JButton("Rojo");
		
		add(botonAzul,BorderLayout.NORTH);
		add(botonRojo,BorderLayout.CENTER);
		
		JPanel contenedor = new JPanel();
		contenedor.add(botonAmarillo);
		add(contenedor,BorderLayout.SOUTH);
	

	}
}
