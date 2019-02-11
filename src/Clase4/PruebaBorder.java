package Clase4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class PruebaBorder {

	public static void main(String[] args) {
		MarcoBorder marco = new MarcoBorder();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoBorder extends JFrame {

	public MarcoBorder() {
		setSize(600, 200);
		setLocation(400, 100);
		setTitle("Tipos de bordes");

		// Agregamos la lamina
		LaminaBorder lamina = new LaminaBorder();
		add(lamina);
	}
}

class LaminaBorder extends JPanel {
	JPanel laminaBotones;
	JPanel laminaDemo;
	ButtonGroup grupo;

	public LaminaBorder() {

		//lamina sobre la cual se probaran los border
		laminaDemo = new JPanel();
		//lamina con los radio
		laminaBotones = new JPanel();
		//grupo para agrupar los radio
		grupo = new ButtonGroup();

		ponerBotonRadio("Biselado hundido", BorderFactory.createLoweredBevelBorder());
		ponerBotonRadio("Biselado elevado", BorderFactory.createRaisedBevelBorder());
		ponerBotonRadio("Grabado", BorderFactory.createEtchedBorder());
		ponerBotonRadio("Linea", BorderFactory.createLineBorder(Color.BLUE));
		ponerBotonRadio("Mate", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
		ponerBotonRadio("Vacio", BorderFactory.createEmptyBorder());

		Border grabado = BorderFactory.createEtchedBorder();
		Border conTitulo = BorderFactory.createTitledBorder(grabado, "Tipos de border");
		laminaBotones.setBorder(conTitulo);

		setLayout(new GridLayout(2, 1));
		add(laminaBotones);
		add(laminaDemo);

	}

	private void ponerBotonRadio(String nombreBoton, Border b) {
		JRadioButton boton = new JRadioButton(nombreBoton);
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				laminaDemo.setBorder(b);
			}
		});
		grupo.add(boton);
		laminaBotones.add(boton);
	}
}
