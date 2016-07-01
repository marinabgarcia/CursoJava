package Clase3;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dibujos {

	public static void main(String[] args) {
		MarcoDibujos marco = new MarcoDibujos();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}

class MarcoDibujos extends JFrame {
	public MarcoDibujos() {
		setSize(300, 200);
		setTitle("Dibujando");
		
		LaminaDibujos lamina = new LaminaDibujos();
		add(lamina);
	}
}

class LaminaDibujos extends JPanel {

	private Point2D ultima;
	private ArrayList<Line2D> lineas;

	private static final int INCREMENTO_MINI = 1;
	private static final int INCREMENTO_MAXI = 5;

	/**
	 * Lamina para dibujar con teclado
	 */
	public LaminaDibujos() {
		ultima = new Point2D.Double(100, 100);
		lineas = new ArrayList<Line2D>();
		KeyHandler oyente = new KeyHandler();
		addKeyListener(oyente);
		setFocusable(true);
	}

	public void add(int dx, int dy) {
		// se calcula nuevo punto final
		Point2D fin = new Point2D.Double(dx + ultima.getX(), dy + ultima.getY());

		// se agrega el segmento de linea
		Line2D linea = new Line2D.Double(ultima, fin);
		lineas.add(linea);
		// recordar que no se debe llamar al metodo paintComponent sino repaint
		repaint();

		// recordamos nuevo punto final
		ultima = fin;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		// se dibujan todas las lineas
		for (Line2D linea : lineas)
			g2.draw(linea);
	}

	private class KeyHandler implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			int codigoTecla = e.getKeyCode();
			int d;
			// fijamos la distancia
			if (e.isShiftDown())
				d = INCREMENTO_MAXI;
			else
				d = INCREMENTO_MINI;

			// se agrega un segmento de linea
			if (codigoTecla == KeyEvent.VK_LEFT)
				add(-d, 0);
			else if (codigoTecla == KeyEvent.VK_RIGHT)
				add(d, 0);
			else if (codigoTecla == KeyEvent.VK_UP)
				add(0, -d);
			else if (codigoTecla == KeyEvent.VK_DOWN)
				add(0, d);

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}
}