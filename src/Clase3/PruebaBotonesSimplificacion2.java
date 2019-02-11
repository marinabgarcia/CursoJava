package Clase3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaBotonesSimplificacion2 {

	public static void main(String[] args) {
		MarcoBotonesS2 marco = new MarcoBotonesS2();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoBotonesS2 extends JFrame {
	public MarcoBotonesS2() {
		setSize(300, 200);
		setTitle("Prueba botones");

		LaminaBotonesS2 lamina = new LaminaBotonesS2();
		add(lamina);
	}
}

class LaminaBotonesS2 extends JPanel {

	public LaminaBotonesS2() {
		hacerBoton("Amarillo", Color.YELLOW);
		hacerBoton("Azul", Color.BLUE);
		hacerBoton("Rojo", Color.RED);

	}

	void hacerBoton(String nombre, Color colorDeFondo) {
		JButton boton = new JButton(nombre);
		add(boton);

		ActionListener accion = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// se especifica el color de fondo de la lamina
				setBackground(colorDeFondo);

			}
		};
		boton.addActionListener(accion);

	}
}
