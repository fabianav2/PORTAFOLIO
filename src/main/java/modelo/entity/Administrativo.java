package modelo.entity;

/** 
 * @version 1.0.0  Trabajo Sprint M5
 * @author Fabiana Vega
 * @author Cristian Díaz
 */

/** Clase Administrativo extiende de clase Usuario
* Atributos:
* run
* area
* aniosExperiencia
*/
public class Administrativo extends Usuario {

	private int run;
	private String area;
	private String aniosExperiencia;
	
	// Constructores
	
	public Administrativo() {}
	
	public Administrativo(int runUsuario, String nombreUsuario, String fechaNacimiento, String tipo,
			int run, String area, String aniosExperiencia) {
		super(runUsuario, nombreUsuario,fechaNacimiento,tipo);
		
		this.setRun(run);
		this.setAniosExperiencia(aniosExperiencia);
		this.setArea(area);
	}
	
	// Métodos getters y setters
	
	/**
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
	 * @return Retorna cadena area
	 */
	public String getArea() {
		return area;
	}
	
	/**
	 * @param area Recibe y valida cadena area
	 * obligatorio, mínimo 5 caracteres, máximo 20
	 */
	public void setArea(String area) {
	this.area = area;
	}
	
	/**
	 * @return retorna cadena años de experiencia 
	 */
	public String getAniosExperiencia() {
		return aniosExperiencia;
	}
	
	/**
	 * @param aniosExperiencia Recibe y valida cadena aniosExperiencia
	 * máximo 100 caracteres
	 */
	public void setAniosExperiencia(String aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}
	
	// Métodos sobreescritos
	
	@Override
	public String toString() {
		return "Administrativo [" +
				", run=" + run +
				", area=" + area + 
				", aniosExperiencia=" + aniosExperiencia + 
				", toString()="	+ super.toString() + "]";
	}

}