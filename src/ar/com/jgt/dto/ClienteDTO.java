package ar.com.jgt.dto;

public class ClienteDTO {
	
	private String dni = "";
	private String nombre = "";
	private String apellido = "";
	private String fechaDeAlta = "";
	
	public ClienteDTO(){
	}
	
	public ClienteDTO(String dni) {
		super();
		this.dni = dni;
	}
	
	public ClienteDTO(String dni, String nombre, String apellido, String fechaDeAlta) {
		super();
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
