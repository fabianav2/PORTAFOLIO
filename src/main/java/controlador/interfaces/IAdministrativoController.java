package controlador.interfaces;

import java.util.List;

import modelo.entity.Administrativo;

public interface IAdministrativoController {
	
	// desplegar todos
	public List<Administrativo> findAllAdministrativos();
	// crear
	public Administrativo saveAdministrativo(Administrativo administrativo);
	// eliminar
	public void deleteAdministrativoByRun(int run);
	// actualizar
	public Administrativo updateAdministrativo(Administrativo administrativo);
	// buscar de 1
	public Administrativo findByRunAdministrativo(int run);


}
