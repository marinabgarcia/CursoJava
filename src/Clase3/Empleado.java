package Clase3;

import java.util.Date;

public class Empleado {
	static final int AUMENTO = 5;
	private Double sueldo;
	private Date fechaContrato;
	private String nombre;

	public Empleado(String nombre, double sueldo, Date fechaContrato) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.fechaContrato = fechaContrato;
	}

	public Empleado() {
	}

	public Double getSueldo() {
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
