package modelo.entity;

import java.io.Serializable;

/** 
 * @version 1.0.0  Trabajo Grupal Módulo 5
 * @author Cristian Díaz
 * @author Fabiana Vega
 */

/**
 * Clase Capacitacion
 * Atributos:
 * identificador
 * rut
 * dia
 * hora
 * lugar
 * duracion
 * cantidadAsistentes
 */
public class Capacitacion implements Serializable{
	
	// Variables de clase (atributos)
	private int identificador;
	private int rut;
	private String dia;
	private String hora;
	private String lugar;
	private String duracion;
	private int cantidadAsistentes;
	
	// Metodos Constructores
	
	public Capacitacion() {	}
	
	public Capacitacion(int identificador,
			int rut,
			String dia,
			String hora,
			String lugar,
			String duracion,
			int cantidadAsistentes) {
		
		this.setIdentificador(identificador);
		this.setRut(rut);
		this.setDia(dia);
		this.setHora(hora);
		this.setLugar(lugar);
		this.setDuracion(duracion);
		this.setCantidadAsistentes(cantidadAsistentes);

	}

	//Metodos de la clase
	
	
	/**
	 * @param lugar Recibe cadena lugar
	 * @param hora Recibe cadena hora
	 * @param dia Recibe cadena dia
	 * @param duracion Recibe entero duracion
	 * @return Retorna mensaje con detalle de la capacitacion
	 */
	public String mostrarDetalle(String lugar,
			String hora,
			String dia,
			int duracion) {
		
		String mensaje= "La capacitación será en "+lugar
				+ " a las "+hora
				+ " del dia "+dia
				+ " y durará "+duracion+" minutos";
		
		return mensaje;
	}
	
	// Metodos getters y setters
	
	/**
	 * @return Retorna entero identificador
	 */
	public int getIdentificador() {
		return this.identificador;
	}
	
	/**
	 * @param identificador Recibe y valida entero identificador
	 * obligatorio, número interno de la capacitación manejado por la empresa
	 */
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	/**
	 * @return Retorna entero rut del cliente
	 */
	public int getRut() {
		return this.rut;
	}
	
	/**
	 * @param rut Recibe y valida entero rut
	 * obligatorio
	 */
	public void setRut(int rut) {
		this.rut = rut;
	}
	
	/**
	 * @return Retorna cadena dia
	 */
	public String getDia() {
		return dia;
	}
	
	/**
	 * @param dia Recibe y valida dia
	 * texto, día de la semana. 
	 * Debe ser un valor permitido entre lunes y Domingo (en ese formato)
	 */
	public void setDia(String dia) {
		this.dia=dia.toUpperCase();
	}
	
	/**
	 * @return Retorna cadena hora
	 */
	public String getHora() {
		return hora;
	}
	
	/**
	 * @param hora Recibe y valida cadena hora
	 * debe ser una hora válida del día, 
	 * en formato HH:MM (hora desde 0 a 23, minutos entre 0 y 59)
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	/**
	 * @return Retorna cadena lugar
	 */
	public String getLugar() {
		return lugar;
	}
	
	/**
	 * @param lugar Recibe y valida cadena lugar
	 * obligatorio, mínimo 10 caracteres, máximo 50
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	/**
	 * @return Retorna cadena duracion
	 */
	public String getDuracion() {
		return duracion;
	}
	
	/**
	 * @param duracion Recibe y valida cadena duracion
	 * máximo 70 caracteres
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	/**
	 * @return Retorna entero cantidad asistentes
	 */
	public int getCantidadAsistentes() {
		return cantidadAsistentes;
	}
	
	/**
	 * @param cantidadAsistentes Recibe y valida entero cantidad de asistentes
	 * obligatorio, número entero menor que 1000
	 */
	public void setCantidadAsistentes(int cantidadAsistentes) {
		this.cantidadAsistentes = cantidadAsistentes;
	}

	@Override
	public String toString() {
		return "Capacitacion [identificador=" + identificador + ", rut=" + rut + ", dia=" + dia
				+ ", hora=" + hora + ", lugar=" + lugar + ", duracion=" + duracion + ", cantidadAsistentes="
				+ cantidadAsistentes + "]";
	}	

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
}