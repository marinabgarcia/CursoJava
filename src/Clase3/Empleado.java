package Clase3;

import java.util.Date;

public class Empleado {
	
	protected Double sueldo;
	private Date fechaContrato;
	public String nombre;

	public Empleado(String nombre, double sueldo, Date fechaContrato) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.fechaContrato = fechaContrato;
	}

	public Empleado() {
	}

	public Double getSueldo() {
		System.out.println("Empleado");
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void subirSueldo() {
		this.sueldo += ((sueldo * AUMENTO) / 100);
	}

	@Override
	public String toString() {
		return "Empleado [sueldo=" + sueldo + ", fechaContrato=" + fechaContrato + ", nombre=" + nombre + "]";
	}

	
}
