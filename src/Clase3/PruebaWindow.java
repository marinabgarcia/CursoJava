package Clase3;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class PruebaWindow {

	public static void main(String[] args) {
		MarcoWindow marco = new MarcoWindow();
		marco.setVisible(true);
		//marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.addWindowListener(new Terminador());

	}

}

class MarcoWindow extends JFrame {
	public MarcoWindow() {
		setSize(300, 200);
		setTitle("Prueba window");

	}
}

class Terminador implements WindowListener {


	@Override
	public void windowClosing(WindowEvent e) { System.exit(0);}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
