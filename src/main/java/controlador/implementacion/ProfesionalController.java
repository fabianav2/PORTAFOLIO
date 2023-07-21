package controlador.implementacion;

import java.util.List;

import services.ProfesionalService;
import controlador.interfaces.IProfesionalController;
import modelo.entity.Profesional;

public class ProfesionalController implements IProfesionalController {
	
	ProfesionalService profesionalService = new ProfesionalService();

	@Override
	public List<Profesional> findAllProfesionales() {

		return profesionalService.findAllProfesionales();
	}

	@Override
	public Profesional saveProfesional(Profesional profesional) {

		return profesionalService.saveProfesional(profesional);
		
	}

	@Override
	public void deleteProfesionalByRun(int run) {
		
	    boolean isDeleted = profesionalService.deleteProfesionalByRun(run);
	    
	    if(isDeleted) {
	      System.out.println("Profesional eliminado");
	    } else {
	      System.out.println("Fallo al eliminar profesional");
	    }
	    
	}

	@Override
	public Profesional updateProfesional(Profesional profesional) {

		return profesionalService.updateProfesional(profesional);
	}

	@Override
	public Profesional findByRunProfesional(int run) {

		return profesionalService.findByRunProfesional(run);
		
	}

}
