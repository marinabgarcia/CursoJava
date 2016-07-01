package Clase3;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class PruebaAcciones {

	public static void main(String[] args) {
		MarcoAcciones marco = new MarcoAcciones();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoAcciones extends JFrame {
	public MarcoAcciones() {
		setSize(300, 200);
		setTitle("Prueba botones");

		LaminaAcciones lamina = new LaminaAcciones();
		add(lamina);
	}
}

class LaminaAcciones extends JPanel {

	public LaminaAcciones() {

		// se definen las acciones
		Action actionAmarillo = new AccionColor("Amarillo", new ImageIcon("src/circuloAmarillo.png"), Color.YELLOW);
		Action actionAzul = new AccionColor("Azul", new ImageIcon("src/circuloAzul.png"), Color.BLUE);
		Action actionRojo = new AccionColor("Rojo", new ImageIcon("src/circuloRojo.png"), Color.RED);

		// se crean los botones con acciones
		JButton botonAmarillo = new JButton(actionAmarillo);
		JButton botonAzul = new JButton(actionAzul);
		JButton botonRojo = new JButton(actionRojo);

		// se agregan los botones a la lamina
		add(botonAmarillo);
		add(botonAzul);
		add(botonRojo);

		// se asocian las teclas Y,B y R
		InputMap mapEnt = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

		mapEnt.put(KeyStroke.getKeyStroke("ctrl Y"), "lamina.yellow");
		mapEnt.put(KeyStroke.getKeyStroke("ctrl B"), "lamina.blue");
		mapEnt.put(KeyStroke.getKeyStroke("ctrl R"), "lamina.red");

		// se asocian los nombres a las acciones
		ActionMap mapaAccion = getActionMap();
		mapaAccion.put("lamina.yellow", actionAmarillo);
		mapaAccion.put("lamina.blue", actionAzul);
		mapaAccion.put("lamina.red", actionRojo);

	}

	class AccionColor extends AbstractAction {

		public AccionColor(String nombre, Icon icon, Color c) {
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color: " + nombre.toLowerCase());
			putValue("color", c);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// obtengo color
			Color colorDeFondo = (Color) getValue("color");
			// se especifica el color de fondo de la lamina
			setBackground(colorDeFondo);

		}
	}
}
