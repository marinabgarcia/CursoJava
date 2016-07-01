package Clase3;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class PruebaWindowS2 {

	public static void main(String[] args) {
		MarcoWindowS2 marco = new MarcoWindowS2();
		marco.setVisible(true);
		// marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});

	}
}

class MarcoWindowS2 extends JFrame {
	public MarcoWindowS2() {
		setSize(300, 200);
		setTitle("Prueba window");

	}
}

