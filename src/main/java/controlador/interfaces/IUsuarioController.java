package controlador.interfaces;

import java.util.List;

import modelo.entity.Usuario;

public interface IUsuarioController {
	
	// desplegar todos
	public List<Usuario> findAllUsuarios();
	// crear
	public Usuario saveUsuario(Usuario usuario);
	// eliminar
	public void deleteUsuarioByRun(int run);
	// actualizar
	public Usuario updateUsuario(Usuario usuario);
	// buscar de 1
	public Usuario findByRunUsuario(int run);


}
