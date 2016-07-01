package Clase2;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PruebaImagen {
	public static void main(String[] args) {
		try {
			MarcoImagen marco = new MarcoImagen();
			marco.setVisible(true);
			marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar la imagen");
		}
	}
}

class MarcoImagen extends JFrame {
	public MarcoImagen() throws IOException {

		setSize(1200, 1200);
		setTitle("Prueba con imagen");
		LaminaConImagen lamina;
		lamina = new LaminaConImagen();
		add(lamina);

	}
}

class LaminaConImagen extends JPanel {
	private Image imagen;

	public LaminaConImagen() throws IOException{
		File input = new File("src/icono.jpg");

			imagen = ImageIO.read(input);
		
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
