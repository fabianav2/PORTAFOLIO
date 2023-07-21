package controlador.interfaces;

import java.util.List;

import modelo.entity.Cliente;

public interface IClienteController {

	// desplegar todos
	public List<Cliente> findAllClientes();
	// crear
	public Cliente saveCliente(Cliente cliente);
	// eliminar
	public void deleteClienteByRut(int rut);
	// actualizar
	public Cliente updateCliente(Cliente cliente);
	// buscar de 1
	public Cliente findByRutCliente(int rut);

}
