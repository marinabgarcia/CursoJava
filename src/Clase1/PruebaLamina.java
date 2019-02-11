package Clase1;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaLamina {

	public static void main(String[] args) {
		MarcoLamina marco = new MarcoLamina();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class MarcoLamina extends JFrame {

	public MarcoLamina() {
		setSize(500, 300);
		setLocation(300, 200);
		setResizable(true);
		setTitle("Dibujando un texto");
		Lamina lamina = new Lamina();
		add(lamina);
	}

}

class Lamina extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Texto sobre lamina", 100, 50);
		g.drawRect(100, 100, 100, 100);
		g.drawLine(100, 50, 200, 200);
	}
}