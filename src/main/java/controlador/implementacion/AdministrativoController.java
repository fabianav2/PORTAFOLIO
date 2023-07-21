package controlador.implementacion;

import java.util.List;

import services.AdministrativoService;
import controlador.interfaces.IAdministrativoController;
import modelo.entity.Administrativo;

public class AdministrativoController implements IAdministrativoController {
	
	AdministrativoService administrativoService = new AdministrativoService();

	@Override
	public List<Administrativo> findAllAdministrativos() {
		
		return administrativoService.findAllAdministrativos();
	}

	@Override
	public Administrativo saveAdministrativo(Administrativo administrativo) {
		
		return administrativoService.saveAdministrativo(administrativo);
	}

	@Override
	public void deleteAdministrativoByRun(int run) {
		
	    boolean isDeleted = administrativoService.deleteAdministrativoByRun(run);
	    
	    if(isDeleted) {
	      System.out.println("Administrativo eliminado");
	    } else {
	      System.out.println("Fallo al eliminar administrativo");
	    }
	    
	}

	@Override
	public Administrativo updateAdministrativo(Administrativo administrativo) {
		
		return administrativoService.updateAdministrativo(administrativo);
	}

	@Override
	public Administrativo findByRunAdministrativo(int run) {

		return administrativoService.findByRunAdministrativo(run);
		
	}

}
