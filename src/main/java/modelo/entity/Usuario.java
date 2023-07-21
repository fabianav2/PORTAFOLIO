package modelo.entity;

/** 
 * @version 1.0.0  Trabajo Grupal Módulo 5
 * @author Fabiana Vega
 * @author Cristian Díaz
 */

/**
 * Clase Usuario implementa interfaz IAsesoria
 * Atributos:
 * runUsuario
 * nombreUsuario
 * fechaNacimientoUsuario
 * tipo
 */
public class Usuario {
	
	private int runUsuario;
	private String nombreUsuario; 
	private String fechaNacimientoUsuario;
	private String tipo;
	
	// Constructores
	
	public Usuario() {	}
	
	public Usuario(int run, String nombreUsuario, String fechaNacimientoUsuario, String tipo ) {

		this.setRunUsuario(run);
		this.setNombreUsuario(nombreUsuario);
		this.setFechaNacimientoUsuario(fechaNacimientoUsuario);
		this.setTipo(tipo);
		
	}
	
	//Metodos setters y getters
	
	/**
	 * @return Retorna run del usuario
	 */
	public int getRunUsuario() {
		return runUsuario;
	}

	/**
	 * @param runUsuario Run del usuario
	 * corresponde a un número menor a 99.999.999
	 */
	public void setRunUsuario(int runUsuario) {
			this.runUsuario=runUsuario;
	}

	/**
	 * @return Retorna el nombre del usuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario Recibe un String con el Nombre del usuario
	 * obligatorio, mínimo 10 caracteres, máximo 50
	 */
	public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return Retorna la fecha de nacimiento del usuario
	 */
	public String getFechaNacimientoUsuario() {
		return fechaNacimientoUsuario;
	}

	/**
	 * @param fechaNacimientoUsuario Recibe fecha de nacimiento del usuario
	 * obligatorio, independiente si lo declara como una fecha o string,
	 * debe ser desplegado con el formato DD/MM/AAAA
	 */
	public void setFechaNacimientoUsuario(String fechaNacimientoUsuario) {
			this.fechaNacimientoUsuario = fechaNacimientoUsuario;
	}

	/**
	 * @return Retorna el tipo de usuario
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo Recibe tipo
	 * obligatorio, "cliente","administrativo","profesional"
	 */
	public void setTipo(String tipo) {
			this.tipo = tipo;
	}

	// Métodos sobreescritos
	
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" +	nombreUsuario + 
				", fechaNacimientoUsuario=" + fechaNacimientoUsuario + 
				", runUsuario=" + runUsuario + 
				", tipo="+ tipo + "]";
	}
}
