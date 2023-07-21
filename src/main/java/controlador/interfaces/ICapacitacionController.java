package controlador.interfaces;

import java.util.List;

import modelo.entity.Capacitacion;

public interface ICapacitacionController {
	
	// desplegar todos
	public List<Capacitacion> findAllCapacitaciones();
	// crear
	public Capacitacion saveCapacitacion(Capacitacion capacitacion);
	// eliminar
	public void deleteCapacitacionByIdentificador(int identificador);
	// actualizar
	public Capacitacion updateCapacitacion(Capacitacion capacitacion);
	// buscar de 1
	public Capacitacion findByIdentificadorCapacitacion(int identificador);
	
}
