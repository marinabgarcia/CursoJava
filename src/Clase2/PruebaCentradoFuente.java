package Clase2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaCentradoFuente {
	public static void main(String[] args) {
		MarcoTexto marco = new MarcoTexto();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class MarcoTexto extends JFrame {
	public MarcoTexto() {
		setSize(400, 400);
		setTitle("Prueba Figuras con fuentes");
		LaminaConTexto lamina = new LaminaConTexto();
		add(lamina);
	}
}

class LaminaConTexto extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Font fuente = new Font("Serif", Font.BOLD, 14);
		g2.setFont(fuente);
		g2.setColor(Color.PINK);

		String nombre = "Ejemplo fuente";

		// Medimos mensaje
		FontRenderContext contexto = g2.getFontRenderContext();
		Rectangle2D limites = fuente.getStringBounds(nombre, contexto);

		// obtenemos posicion
		double x = (getWidth() - limites.getWidth()) / 2;
		double y = (getHeight() - limites.getHeight()) / 2;

		g2.drawString(nombre, (int) x, (int) y);

	}
}
