package Clase3;

public class Administrador extends Empleado {
	static final int AUMENTO = 5;
	@Override
	public Double getSueldo() {
		System.out.println("Admin");
		return sueldo * AUMENTO;
	}
	


}
