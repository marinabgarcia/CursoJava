package Clase4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PruebaCasillasDeVerificacion {

	public static void main(String[] args) {
		MarcoCasillas marco = new MarcoCasillas();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoCasillas extends JFrame {

	public MarcoCasillas() {
		setSize(300, 200);
		setLocation(400, 100);
		setTitle("Casillas de Verificacion");

		// Agregamos la lamina
		LaminaCasillas lamina = new LaminaCasillas();
		add(lamina);
	}
}

class LaminaCasillas extends JPanel {
	private static int TAMFUENTE = 12;
	JCheckBox negrita;
	JCheckBox cursiva;

	public LaminaCasillas() {

		this.setLayout(new BorderLayout());
		// se agrega el rotulo para el ejemplo
		JLabel rotulo = new JLabel("El veloz murcielago hindu comia tambien cascaras de kiwi", JLabel.CENTER);
		rotulo.setFont(new Font("Serif", Font.PLAIN, TAMFUENTE));
		add(rotulo, BorderLayout.CENTER);

		// se crea un oyente para cambiar el tipo de letra del rotulo

		ActionListener oyente = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int modo = 0;
				if (negrita.isSelected())
					modo += Font.BOLD;
				if (cursiva.isSelected())
					modo += Font.ITALIC;
				rotulo.setFont(new Font("Serif", modo, TAMFUENTE));
			}
		};

		// se agregan las casillas de verificacion
		JPanel laminaBotones = new JPanel();

		negrita = new JCheckBox("Negrita");
		negrita.addActionListener(oyente);
		laminaBotones.add(negrita);

		cursiva = new JCheckBox("Cursiva");
		cursiva.addActionListener(oyente);
		laminaBotones.add(cursiva);

		add(laminaBotones, BorderLayout.SOUTH);
	}
}
