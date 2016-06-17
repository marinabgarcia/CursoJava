package Clase1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaGraphics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoFiguras marco = new MarcoFiguras();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class MarcoFiguras extends JFrame {
	public MarcoFiguras() {
		setSize(400, 400);
		setTitle("Prueba Figuras");
		LaminaConFiguras lamina = new LaminaConFiguras();
		add(lamina);
	}
}

class LaminaConFiguras extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// Dibujar rectangulo
		double xizq = 100;
		double ysup = 100;
		double anchura = 200;
		double altura = 150;

		Rectangle2D rectangulo = new Rectangle2D.Double(xizq, ysup, anchura, altura);
		g2.draw(rectangulo);

		// Dibujar elipse inscrita
		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		g2.draw(elipse);

		// dibujar linea diagonal
		g2.draw(new Line2D.Double(xizq, ysup, xizq + anchura, ysup + altura));

		// dibujar un circulo con el mismo centro
		double xcentro = rectangulo.getCenterX();
		double ycentro = rectangulo.getCenterY();
		double radio = 150;

		Ellipse2D circulo = new Ellipse2D.Double();
		circulo.setFrameFromCenter(xcentro, ycentro, xcentro + radio, ycentro + radio);
		g2.draw(circulo);
	}
}
