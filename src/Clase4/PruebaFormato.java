package Clase4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.DocumentFilter;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.MaskFormatter;

public class PruebaFormato {

	public static void main(String[] args) {
		MarcoPruebaFormato marco = new MarcoPruebaFormato();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}

class MarcoPruebaFormato extends JFrame {
	JButton botonOk;
	JPanel laminaPrincipal;

	public MarcoPruebaFormato() {
		setTitle("Prueba Formato");
		setSize(500, 250);

		JPanel laminaBotones = new JPanel();
		botonOk = new JButton("OK");
		laminaBotones.add(botonOk);
		add(laminaBotones, BorderLayout.SOUTH);

		laminaPrincipal = new JPanel();
		laminaPrincipal.setLayout(new GridLayout(0, 3));
		add(laminaPrincipal, BorderLayout.CENTER);

		JFormattedTextField campoInt = new JFormattedTextField(NumberFormat.getIntegerInstance());
		campoInt.setValue(new Integer(100));
		ponerFila("Numero: ", campoInt);

		JFormattedTextField campoInt2 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		campoInt2.setValue(new Integer(100));
		campoInt2.setFocusLostBehavior(JFormattedTextField.COMMIT);
		ponerFila("Numero (commit): ", campoInt2);
		
		JFormattedTextField campoInt3 = new JFormattedTextField(NumberFormat.getNumberInstance());
		campoInt3.setValue(new Double(100.8));
		ponerFila("Numero con coma: ", campoInt3);

		JFormattedTextField campoInt4 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		campoInt4.setValue(new Integer(100));
		campoInt4.setInputVerifier(new Verificador());
		ponerFila("Numero verificado: ", campoInt4);

		JFormattedTextField campoMonetario = new JFormattedTextField(NumberFormat.getCurrencyInstance());
		campoMonetario.setValue(new Double(10));
		ponerFila("Divisa: ", campoMonetario);

		JFormattedTextField campoFechas = new JFormattedTextField(DateFormat.getDateInstance());
		campoFechas.setValue(new Date());
		ponerFila("Date predeterminado: ", campoFechas);

		DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
		format.setLenient(false);
		JFormattedTextField campoFechas2 = new JFormattedTextField(format);
		campoFechas2.setValue(new Date());
		ponerFila("Date corto no clemente: ", campoFechas2);

		MaskFormatter formateador;
		try {
			formateador = new MaskFormatter("##UUU##");
			formateador.setPlaceholderCharacter('*');
			JFormattedTextField campoPatente = new JFormattedTextField(formateador);
			campoPatente.setValue("32ABC34");
			ponerFila("Mascara Patente ", campoPatente);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ponerFila(String textoRotulo, final JFormattedTextField campo) {
		laminaPrincipal.add(new JLabel(textoRotulo));
		laminaPrincipal.add(campo);
		final JLabel rotuloValor = new JLabel();
		laminaPrincipal.add(rotuloValor);

		botonOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object valor = campo.getValue();
				rotuloValor.setText(valor.toString());
			}
		});
	}
}

class Verificador extends InputVerifier {

	@Override
	public boolean verify(JComponent input) {
		JFormattedTextField campo = (JFormattedTextField) input;
		return campo.isEditValid();
	}

}