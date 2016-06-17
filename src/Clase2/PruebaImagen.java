package Clase2;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaImagen {
	public static void main(String[] args) {
		MarcoTexto marco = new MarcoTexto();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoImagen extends JFrame {
	public MarcoImagen() {
		setSize(1200, 1200);
		setTitle("Prueba con imagen");
		LaminaConImagen lamina = new LaminaConImagen();
		add(lamina);
	}
}

class LaminaConImagen extends JPanel {
	private Image imagen;

	public LaminaConImagen() {
		File input = new File("src/icono.jpg");
		try {
			imagen = ImageIO.read(input);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se encuentra la imagen");
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Dibujo imagen
		g.drawImage(imagen, 0, 0, null);

		int ancho = imagen.getWidth(this);
		int alto = imagen.getHeight(this);

		// Copio imagen
		for (int i = 0; i * ancho <= getWidth(); i++)
			for (int j = 0; j * alto <= getHeight(); j++)
				if (i + j > 0)
					g.copyArea(0, 0, ancho, alto, i * ancho, j * alto);

	}
}
