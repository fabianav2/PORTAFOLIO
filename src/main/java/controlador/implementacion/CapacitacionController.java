package controlador.implementacion;

import java.util.List;

import services.CapacitacionService;
import controlador.interfaces.ICapacitacionController;
import modelo.entity.Capacitacion;

public class CapacitacionController implements ICapacitacionController{

	CapacitacionService capacitacionService = new CapacitacionService();
	
	@Override
	public List<Capacitacion> findAllCapacitaciones() {
		
		return capacitacionService.findAllCapacitaciones();
		
	}
	
	@Override
	public Capacitacion saveCapacitacion(Capacitacion capacitacion) {
		
	    return capacitacionService.saveCapacitacion(capacitacion);
	}

	@Override
	public void deleteCapacitacionByIdentificador(int identificador) {
		
	    boolean isDeleted = capacitacionService.deleteCapacitacionByIdentificador(identificador);
	    
	    if(isDeleted) {
	      System.out.println("Capacitación eliminada");
	    } else {
	      System.out.println("Fallo al eliminar capacitación");
	    }
	    
	}

	@Override
	public Capacitacion updateCapacitacion(Capacitacion capacitacion) {
		
	    return capacitacionService.updateCapacitacion(capacitacion);
	}

	@Override
	public Capacitacion findByIdentificadorCapacitacion(int identificador) {
		
	    return capacitacionService.findByIdentificadorCapacitacion(identificador);
	}
	
}
