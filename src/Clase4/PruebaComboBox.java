package Clase4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PruebaComboBox {

	public static void main(String[] args) {
		MarcoComboBox marco = new MarcoComboBox();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoComboBox extends JFrame {

	public MarcoComboBox() {
		setSize(600, 300);
		setLocation(400, 100);
		setTitle("ComboBox");

		// Agregamos la lamina
		LaminaComboBox lamina = new LaminaComboBox();
		add(lamina);
	}
}

class LaminaComboBox extends JPanel {
	private static int TAMFUENTE = 12;
	JLabel rotulo;

	public LaminaComboBox() {
		setLayout(new BorderLayout());
		// se agrega el rotulo para el ejemplo
		rotulo = new JLabel("El veloz murcielago hindu comia tambien cascaras de kiwi", JLabel.CENTER);
		rotulo.setFont(new Font("Serif", Font.PLAIN, TAMFUENTE));
		add(rotulo, BorderLayout.CENTER);

		// se crea un combobox y se agregan los nombre de los tipos de letras
		JComboBox<String> comboFuentes = new JComboBox<String>();
		comboFuentes.setEditable(true);
		comboFuentes.addItem("Serif");
		comboFuentes.addItem("SansSerif");
		comboFuentes.addItem("Monospaced");
		comboFuentes.addItem("Dialog");
		comboFuentes.addItem("DialogInput");

		// el oyente del combo que cambia la fuente del rotulo
		comboFuentes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rotulo.setFont(new Font((String) comboFuentes.getSelectedItem(), Font.PLAIN, TAMFUENTE));

			}
		});

		// se agrega el combo a una lamina situada en el borde sur
		JPanel laminaCombo = new JPanel();
		laminaCombo.add(comboFuentes);
		add(laminaCombo, BorderLayout.SOUTH);
	}
}
