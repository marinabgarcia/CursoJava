package Clase1;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class PruebaMarcoCentrado {
	
	public static void main (String[] args){
		MarcoCentrado marco = new MarcoCentrado();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoCentrado extends JFrame{
	
	public MarcoCentrado(){
	    Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = mipantalla.getScreenSize();
		int ancho = tamanoPantalla.width;
		int alto = tamanoPantalla.height;
		
		setSize(ancho/2,alto/2);
		setLocation(ancho/4, alto/4);
		
		Image imagen = mipantalla.getImage("src/icono.jpg");
		setIconImage(imagen);
		
	}
}
