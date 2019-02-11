package Clase4;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PruebaTabla {

	public static void main(String[] args) {
		MarcoTabla marco = new MarcoTabla();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoTabla extends JFrame {

	public MarcoTabla() {
		setTitle("Tabla sencilla");
		setSize(600, 300);
		setLocation(400, 100);

		LaminaTabla lamina = new LaminaTabla();
		add(lamina);

	}
}

class LaminaTabla extends JPanel {

	public LaminaTabla() {

		// datos a mostrar
		Object[][] data = { { "Daniel", "Villar", "Esquiar", new Integer(5), new Boolean(false) },
				{ "Carlos", "Villar", "Patinar", new Integer(3), new Boolean(true) },
				{ "Karinna", "Villar", "Escalar", new Integer(2), new Boolean(false) },
				{ "Mario", "Diaz", "Correr", new Integer(7), new Boolean(true) },
				{ "Sylvia", "Uribe", "Modelar", new Integer(4), new Boolean(false) } };

		// array de String's con los títulos de las columnas

		String[] columnNames = { "Nombre", "Apellido", "Pasatiempo", "Años de  Practica", "Soltero(a)" };

		// creamos el Modelo de la tabla con los datos anteriores
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);

		// se crea la Tabla con el modelo DefaultTableModel
		// final JTable table = new JTable(dtm);

		JTable table = new JTable(dtm) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};

		// una vez creada la tabla con su modelo
		// podemos agregar columnas
		String[] newColumn = { "Flan", "Pastel", "Helado", "Barquillo", "Manzana" };
		dtm.addColumn("Postre", newColumn);

		// agregar filas
		Object[] newRow = { "Pepe", "Grillo", "Tenis", new Integer(5), new Boolean(false), "Pera" };
		dtm.addRow(newRow);

		// o modificar una celda en especifico
		dtm.setValueAt("Catherine", 1, 1);

		// podemos definir el tamaño de la tabla
		table.setPreferredScrollableViewportSize(new Dimension(700, 70));

		// Creamos un JscrollPane por si no se llegan a ver todos los registros
		// y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(table);

		// Agregamos el JScrollPane al contenedor
		add(scrollPane);
	}

}
