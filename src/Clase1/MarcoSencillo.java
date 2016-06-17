package Clase1;

import javax.swing.JFrame;

public class MarcoSencillo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco marco = new Marco();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}

}

class Marco extends JFrame {
	
	public Marco() {
		setSize(300,500);
		setLocation(200, 300);
		setResizable(true);
		setTitle("Hola Soy una Ventana");
	}
	
}
