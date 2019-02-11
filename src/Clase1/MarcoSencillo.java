package Clase1;

import javax.swing.JFrame;

public class MarcoSencillo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco marco = new Marco();
		marco.setUndecorated(false);
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class Marco extends JFrame {
	
	public Marco() {
		setSize(200,200);
		setLocation(0,0);
		setResizable(true);
		setTitle("Hola Soy una Ventana");
		//setExtendedState(MAXIMIZED_BOTH);
	}	
}
