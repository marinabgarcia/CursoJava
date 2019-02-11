package Clase3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpleadoRepaso {

	public static void main(String[] args) {
		List<Empleado> listaEmpleado = new ArrayList<Empleado>();
		listaEmpleado.add(new Empleado("Juan",1000D,new Date()));
		listaEmpleado.add(new Empleado("Rosa",2500D,new Date(2016,1,1)));
		Empleado e = new Empleado();
		e.setFechaContrato(new Date());
		e.setSueldo(2000D);
		e.setNombre("Pedro");
		listaEmpleado.add(e);
		
		Empleado admin = new Administrador();
		admin.getSueldo();
		
		for(Empleado emp : listaEmpleado){
			System.out.println(emp.getNombre());
			emp.subirSueldo();
		}
	}
}


