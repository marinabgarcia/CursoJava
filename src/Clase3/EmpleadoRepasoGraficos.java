package Clase3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EmpleadoRepasoGraficos {

	public static void main(String[] args) {
		MarcoEmpleado marco = new MarcoEmpleado();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}

class MarcoEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;

	public MarcoEmpleado() {

		setSize(350, 200);

		setLocation(100, 100);

		setTitle("Ejemplo Empleado");

		LaminaEmpleado lamina = new LaminaEmpleado();
		this.add(lamina);
		

	}

}


class LaminaEmpleado extends JPanel {

	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		Font fuente = new Font("Arial", Font.BOLD, 14);

		g2.setFont(fuente);

		g2.setPaint(Color.PINK);

		List<Empleado> listaEmpleado = new ArrayList<Empleado>();
		listaEmpleado.add(new Empleado("Juan",1000D,new Date()));
		listaEmpleado.add(new Empleado("Rosa",2500D,new Date(2016,1,1)));
		Empleado e = new Empleado();
		e.setFechaContrato(new Date());
		e.setSueldo(2000D);
		e.setNombre("Pedro");
		listaEmpleado.add(e);
		
		for(Empleado emp : listaEmpleado){
			emp.subirSueldo();
			System.out.println(emp.toString());
		}
		
		int lin = 5;
		

		for (Empleado emp : listaEmpleado)

		{

			lin = lin + 30;

			g2.drawString(emp.getNombre(), 20, lin);

			g2.drawString(emp.getSueldo().toString(), 120, lin);
			
			//formatear fecha
			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			g2.drawString(formateador.format(emp.getFechaContrato()), 230, lin);
		}
	}
}
