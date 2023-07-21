package controlador.implementacion;

import java.util.List;

import services.UsuarioService;
import controlador.interfaces.IUsuarioController;
import modelo.entity.Usuario;

public class UsuarioController implements IUsuarioController {
	
	UsuarioService usuarioService = new UsuarioService();

	@Override
	public List<Usuario> findAllUsuarios() {

		return usuarioService.findAllUsuarios();
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {

		return usuarioService.saveUsuario(usuario);
		
	}

	@Override
	public void deleteUsuarioByRun(int run) {
		
	    boolean isDeleted = usuarioService.deleteUsuarioByRun(run);
	    
	    if(isDeleted) {
	      System.out.println("Capacitación eliminada");
	    } else {
	      System.out.println("Fallo al eliminar capacitación");
	    }
	    
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {

		return usuarioService.updateUsuario(usuario);
	}

	@Override
	public Usuario findByRunUsuario(int run) {

		return usuarioService.findByRunUsuario(run);
	}

}
