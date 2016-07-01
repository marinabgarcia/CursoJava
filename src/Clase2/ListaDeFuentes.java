package Clase2;

import java.awt.GraphicsEnvironment;

public class ListaDeFuentes {

	public static void main(String[] args) {
		String[] nombresFuentes = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(String nombre : nombresFuentes)
			System.out.println(nombre);

	}

}
