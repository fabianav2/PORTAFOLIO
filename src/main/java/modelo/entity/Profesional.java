package modelo.entity;

/** 
 * @version 1.0.0  Trabajo Sprint M5
 * @author Fabiana Vega
 * @author Cristian Díaz
 */

/** Clase Profesional extiende de clase Usuario
* Atributos:
* run
* titulo
* fechaIngreso
*/
public class Profesional extends Usuario {
	
	private int run;
	private String titulo;
	private String fechaIngreso;
	
	// Constructores
	
	public Profesional() {}
	
	public Profesional(int runUsuario, String nombreUsuario, String fechaNacimiento, String tipo,
			int run, String titulo, String fechaIngreso) {
		super(run, nombreUsuario, fechaNacimiento, tipo);
		
		this.setRun(run);
		this.setTitulo(titulo);
		this.setFechaIngreso(fechaIngreso);
	}

	// Metodos getters y setters

	/*
	* @return Retorna entero run
	*/
	public int getRun() {
		return run;
	}
	
	/**
	 * @param run Recibe y valida entero run
	 * obligatorio
	 */
	public void setRun(int run) {
	this.run = run;
	}

	/**
	 * @return Retorna cadena titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * @param titulo Recibe y valida cadena titulo
	 * obligatorio, mínimo 10 caracteres, máximo 50
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return Retorna cadena fechaIngreso
	 */
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	
	/**
	 * @param fechaIngreso Recibe y valida cadena fechaIngreso
	 * independiente si lo declara como una fecha o un String, 
	 * debe ser desplegado con el formato DD/MM/AAAA
	 */
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	// Metodos sobreescritos

	@Override
	public String toString() {
		return "Profesional ["
				+ "run="+ run + ""
				+ "titulo=" + titulo + 
				", fechaIngreso=" + fechaIngreso + 
				", toString()=" + super.toString()
				+ "]";
	}
	
}
