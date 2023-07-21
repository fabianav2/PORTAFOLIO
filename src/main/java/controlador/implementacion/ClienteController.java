package controlador.implementacion;


import java.util.List;

import services.ClienteService;
import controlador.interfaces.IClienteController;
import modelo.entity.Cliente;

public class ClienteController implements IClienteController{

	ClienteService clienteService = new ClienteService();
	
	@Override
	public List<Cliente> findAllClientes(){
		
		return clienteService.findAllClientes();
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		
		return clienteService.saveCliente(cliente);
	}

	@Override
	public void deleteClienteByRut(int rut) {
		
	    boolean isDeleted = clienteService.deleteClienteByRut(rut);
	    
	    if(isDeleted) {
	      System.out.println("Cliente eliminado");
	    } else {
	      System.out.println("Fallo al eliminar cliente");
	    }
		
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		
		return clienteService.updateCliente(cliente);
	}

	@Override
	public Cliente findByRutCliente(int rut) {

		return clienteService.findByRutCliente(rut);
	}
	
}
