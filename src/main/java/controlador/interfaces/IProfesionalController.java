package controlador.interfaces;

import java.util.List;

import modelo.entity.Profesional;

public interface IProfesionalController {
	
	// desplegar todos
	public List<Profesional> findAllProfesionales();
	// crear
	public Profesional saveProfesional(Profesional profesional);
	// eliminar
	public void deleteProfesionalByRun(int run);
	// actualizar
	public Profesional updateProfesional(Profesional profesional);
	// buscar de 1
	public Profesional findByRunProfesional(int run);



}
