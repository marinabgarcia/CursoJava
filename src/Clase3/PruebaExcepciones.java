package Clase3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class PruebaExcepciones

{

	public static void main(String[] args)

	{

		MarcoDePruebaDeExcepciones marco = new MarcoDePruebaDeExcepciones();

		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}
}

/**
 * 
 * Un marco con una lámina para probar diferentes excepciones
 * 
 */

class MarcoDePruebaDeExcepciones extends JFrame {

	public MarcoDePruebaDeExcepciones()

	{
		setTitle("PruebaDeExcepcion");
		LaminaDePruebaDeExcepciones lamina = new LaminaDePruebaDeExcepciones();
		add(lamina);
		pack();
	}

}

/**
 * 
 * Una lámina con botones de radio para ejecutar trocitos de código y estudiar
 * su comportamiento frente a las excepciones
 * 
 */

class LaminaDePruebaDeExcepciones extends Box {

	private ButtonGroup grupo;
	private JTextField campoDeTexto;
	private double[] a = new double[10];

	public LaminaDePruebaDeExcepciones() {
		super(BoxLayout.Y_AXIS);
		grupo = new ButtonGroup();
		// añadimos botones de radio para los trocitos de código
		ponerBotonDeRadio("División entera por cero", new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				a[1] = 1 / (a.length - a.length);
			}
		});

		ponerBotonDeRadio("División de coma flotante por cero", new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				a[1] = a[2] / (a[3] - a[3]);
				System.out.println(a[1]);
			}
		});

		ponerBotonDeRadio("Indice matricial incorrecto", new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				a[1] = a[10];
			}
		});

		ponerBotonDeRadio("Refundición incorrecta", new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				a = (double[]) evento.getSource();
			}
		});

		ponerBotonDeRadio("Puntero nulo", new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				evento = null;
				System.out.println(evento.getSource());
			}
		});

		ponerBotonDeRadio("Raiz cuadrada de -1", new ActionListener() {
			public void actionPerformed(ActionEvent evento) {

				a[1] = Math.sqrt(-1);
				System.out.println(a[1]);
			}
		});

		ponerBotonDeRadio("Desbordamiento", new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				a[1] = 1000 * 1000 * 1000 * 1000 * 1000 * 1000;
				int n = (int) a[1];
				System.out.println(n);
			}
		});

		ponerBotonDeRadio("No existe ese archivo", new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				try {
					InputStream en = new FileInputStream("nadadenada.txt");
				} catch (IOException e) {
					campoDeTexto.setText(e.toString());
				}
			}
		});
		ponerBotonDeRadio("Lanzar error desconocido", new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				throw new UnknownError();

			}
		});

		// añadimos el campo de texto que sirve como pantalla para las
		// excepciones

		campoDeTexto = new JTextField(30);

		add(campoDeTexto);

		// Añade un botón de radio con el oyente dado a la lámina Captura las
		// excepciones que pueda haber en el método actionPerformed del oyente.

		// @param s el rótulo del botón de radio
		// ©param oyente el oyente de acciones de este botón 1*
	}

	private void ponerBotonDeRadio(String s, ActionListener oyente) {

		JRadioButton boton = new JRadioButton(s, false) {

			// el botón llama a este método para lanzar un evento de acción. Lo
			// invalidamos para capturar excepciones

			protected void fireActionPerformed(ActionEvent evento)
			{
				try
				{
					campoDeTexto.setText("No se ha producido excepcion alguna");
					super.fireActionPerformed(evento);
				}
				catch (Exception e)
				{
					campoDeTexto.setText(e.toString());
				}
			}
		};

		boton.addActionListener(oyente);
		add(boton);
		grupo.add(boton);
	}

}
