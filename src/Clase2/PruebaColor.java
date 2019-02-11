package Clase2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaColor {

	public static void main(String[] args) {
		MarcoColor marco = new MarcoColor();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class MarcoColor extends JFrame {
	public MarcoColor() {
		setSize(400, 400);
		setTitle("Prueba Figuras con colores");
		LaminaConRelleno lamina = new LaminaConRelleno();
		lamina.setBackground(SystemColor.window);
		add(lamina);
	}
}

class LaminaConRelleno extends JPanel {
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;

		// Dibujar rectangulo
		double xizq = 100;
		double ysup = 100;
		double anchura = 200;
		double altura = 150;

		Rectangle2D rectangulo = new Rectangle2D.Double(xizq, ysup, anchura, altura);
		g2.setPaint(Color.WHITE);
		g2.draw(rectangulo);
		
		g2.setPaint(Color.BLUE);
		g2.fill(rectangulo);

		// Dibujar elipse inscrita
		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		g2.setPaint(Color.PINK);
		g2.fill(elipse);

		// dibujar linea diagonal
		g2.setPaint(new Color(10, 70, 20).brighter().brighter());
		g2.draw(new Line2D.Double(xizq, ysup, xizq + anchura, ysup + altura));

	}
}
