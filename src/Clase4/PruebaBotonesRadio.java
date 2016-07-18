package Clase4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PruebaBotonesRadio {

	public static void main(String[] args) {
		MarcoRadio marco = new MarcoRadio();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoRadio extends JFrame {

	public MarcoRadio() {
		setSize(600, 300);
		setLocation(400, 100);
		setTitle("Casillas de Verificacion");

		// Agregamos la lamina
		LaminaRadio lamina = new LaminaRadio();
		add(lamina);
	}
}

class LaminaRadio extends JPanel {
	private static int TAMFUENTE = 12;
	JLabel rotulo;
	ButtonGroup grupo;
	JPanel laminaBotones;

	public LaminaRadio() {
		setLayout(new BorderLayout());
		// se agrega el rotulo para el ejemplo
		rotulo = new JLabel("El veloz murcielago hindu comia tambien cascaras de kiwi", JLabel.CENTER);
		rotulo.setFont(new Font("Serif", Font.PLAIN, TAMFUENTE));
		add(rotulo, BorderLayout.CENTER);

		// se agregan los botones de radio
		laminaBotones = new JPanel();
		grupo = new ButtonGroup();

		ponerBotonDeRadio("Pequeno", 8);
		ponerBotonDeRadio("Mediano", 12);
		ponerBotonDeRadio("Grande", 18);
		ponerBotonDeRadio("Muy grande", 36);

		add(laminaBotones, BorderLayout.SOUTH);
	}

	private void ponerBotonDeRadio(String nombre, int tamanio) {
		boolean seleccionado = tamanio == TAMFUENTE;
		JRadioButton boton = new JRadioButton(nombre, seleccionado);
		grupo.add(boton);
		laminaBotones.add(boton);

		// oyente que especifica el tamanio de letra del rotulo
		ActionListener oyente = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rotulo.setFont(new Font("Serif", Font.PLAIN, tamanio));

			}
		};
		boton.addActionListener(oyente);

	}

}
