package Clase3;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class PruebaWindowSimplificacion1 {

	public static void main(String[] args) {
		MarcoWindowS1 marco = new MarcoWindowS1();
		marco.setVisible(true);
		// marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.addWindowListener(new TerminadorS1());

	}

}

class MarcoWindowS1 extends JFrame {
	public MarcoWindowS1() {
		setSize(300, 200);
		setTitle("Prueba window");

	}
}

class TerminadorS1 extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

}
