package modelo.entity;

/** 
 * @version 1.0.0  Trabajo Sprint M5
 * @author Fabiana Vega
 * @author Cristian Díaz
 */

/**
 * Clase Cliente extiende de clase Usuario
 * Atributos:
 * rutCliente
 * nombres
 * apellidos
 * telefonos
 * afp
 * sistemaSalud
 * direccion
 * comuna
 * edad
 */
public class Cliente extends Usuario{

	private int rutCliente;
	private String nombres;
	private String apellidos;
	private String telefonos;
	private String afp;
	private int sistemaSalud;
	private String direccion;
	private String comuna;
	private byte edad;
	
	// Constructores
	
	public Cliente() {}
	
	public Cliente(int runUsuario, String nombreUsuario, String fechaNacimiento, String tipo,
			int rutCliente, String nombres, String apellidos,String telefonos, String afp,
			int sistemaSalud, String direccion, String comuna, byte edad) {
		
		super(runUsuario, nombreUsuario, fechaNacimiento, tipo);
		
		this.rutCliente=rutCliente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefonos = telefonos;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;
	}
	
	//Metodos de la clase
	
	/**
	 * @param sistemaSalud Recibe entero sistema de salud 1=FONASA, 2=ISAPRE
	 * @return Retorna String nombre sistema salud
	 */
	public String obtenerSistemaSalud(int sistemaSalud) {
		String sisSalud="";
		switch (sistemaSalud) {
			case 1:
				sisSalud="FONASA";
		break;
			case 2:
				sisSalud="ISAPRE";
				break;
		default:
			sisSalud="Sin Sistema de salud";
		}
		return "Sus sistema de salud es: "+sisSalud;
	}
	
	/**
	 * @param nombres Recibe String nombres y String apellidos
	 * @param apellidos Retorna String nombre completo
	 * @return
	 */
	public String obtenerNombre(String nombres, String apellidos) {
		String nombreCompleto = nombres + " "+ apellidos; 
		return nombreCompleto; 
	}
	
	// Metodos getters y setters
	

	/**
	 * @return Retorna entero rut del cliente
	 */
	public int getRutCliente() {
		return rutCliente;
	}
	
	/**
	 * @param rutCliente Recibe y valida entero rut del cliente
	 * corresponde a un número menor a 99.999.999
	 */
	public void setRutCliente(int rutCliente) {
		this.rutCliente=rutCliente;
	}
	
	/**
	 * @return Retorna String nombres
	 */
	public String getNombres() {
		return nombres;
	}
	
	/**
	 * @param nombres Recibe y valida string nombres
	 * obligatorio, mínimo 5 caracteres, máximo 30
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	/**
	 * @return Retorna cadena apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 * @param apellidos Recibe y valida cadena apellidos
	 * obligatorio, mínimo 5 caracteres, máximo 30
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	/**
	 * @return Retorna cadena telefonos
	 */
	public String getTelefonos() {
		return telefonos;
	}

	/**
	 * @param telefonos Recibe y valida cadena telefonos
	 * obligatorio
	 */
	public void setTelefonos(String telefonos) {
		if (telefonos.length()!=0) {
			this.telefonos = telefonos;
		} else {
			System.out.println("El dato telefono es obligatorio");
		}
	}

	/**
	 * @return Retorna cadena nombre AFP
	 */
	public String getAfp() {
		return afp;
	}
	
	/**
	 * @param afp Recibe y valida cadena AFP
	 * mínimo 4 caracteres, máximo 30
	 */
	public void setAfp(String afp) {
		this.afp = afp;
	}

	/**
	 * @return Retorna entero sistema de salud
	 * 1=FONASA
	 * 2=ISAPRE
	 */
	public int getSistemaSalud() {
		return sistemaSalud;
	}
	
	/**
	 * @param sistemaSalud Recibe y valida entero sistema de salud
	 * 1=FONASA y 2=ISAPRE
	 */
	public void setSistemaSalud(int sistemaSalud) {
		if (sistemaSalud==1 || sistemaSalud==2) {
			this.sistemaSalud = sistemaSalud;
		}else {
			System.out.println("Sistema de salud debe ser 1=Fonasa o 2=Isapre");
		}
	}
	
	/**
	 * @return Retorna string con direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * @param direccion Recibe y valida string direccion
	 * máximo 70 caracteres
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return Retorna string comuna
	 */
	public String getComuna() {
		return comuna;
	}
	
	/**
	 * @param comuna Recibe y valida string comuna
	 * máximo 50 caracteres
	 */
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	/**
	 * @return Retorna byte edad
	 */
	public byte getEdad() {
		return edad;
	}
	
	/**
	 * @param edad Recibe y valida byte edad
	 * obligatorio, número mayor o igual a cero, y menor a 150
	 */
	public void setEdad(byte edad) {
		if (edad<0 || edad>150) {
			System.out.println("Error en edad, debe ser entre 0 uy 150");
		} else {
			this.edad = edad;
		}
	}

	
	// Métodos sobreescritos
	
	@Override
	public String toString() {
		return "Cliente [rutCliente=" + rutCliente + 
				", nombres=" + nombres + 
				", apellidos=" + apellidos	+ 
				", telefonos=" + telefonos + 
				", afp=" + afp + 
				", sistemaSalud=" + sistemaSalud + 
				", direccion="	+ direccion + 
				", comuna=" + comuna + 
				", edad=" + edad + 
				", toString()=" + super.toString() + "]";
	}
	
}
