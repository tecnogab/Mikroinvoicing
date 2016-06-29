package ar.com.jgt.dao;

public class Cliente {
	
	String dni = "";
	String nombre = "";
	String apellido = "";
	String fechaDeAlta = "";
	
	public Cliente(){
	}
	
	public Cliente(String dni, String nombre, String apellido, String fechaDeAlta){
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeAlta = fechaDeAlta;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(String fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}
}
